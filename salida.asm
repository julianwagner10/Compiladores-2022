.386
.model flat, stdcall
option casemap :none
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib
.STACK 200h
.data
_limiteSuperiorInt DD 2147483647
_limiteSuperiorFloatPositivo DQ 3.4028235E38
_limiteInferiorFloatPositivo DQ 1.17549435E-38
_limiteSuperiorFloatNegativo DQ -3.4028235E38
_limiteInferiorFloatNegativo DQ -1.17549435E-38
_limiteFloatCero DQ 0.0
_errorOverflowInt DB "Error suma enteros", 0
_errorOverflowFloat DB "Error suma flotante" , 0
_2_40282347F__38 DQ 2.40282347E+38
_x_main DQ ?
__var5 DW ?
__var4 DW ?
__var3 DW ?
__var2 DW ?
__var1 DW ?
__var0 DQ ?
_id_main DQ ?
_z_main DQ ?
_3_39282347F__38 DQ 3.39282347E+38
.code
Error_Suma_Enteros:
invoke MessageBox, NULL, addr _errorOverflowInt, addr _errorOverflowInt, MB_OK
invoke ExitProcess, 0
Error_Suma_Flotantes:
invoke MessageBox, NULL, addr _errorOverflowFloat, addr _errorOverflowFloat, MB_OK
invoke ExitProcess, 0
start:
FLD _3_39282347F__38
FADD _2_40282347F__38
FSTP __var0
FLD __var0
FCOMP _limiteInferiorFloatPositivo
FSTSW __var1
MOV AX, __var1
SAHF
JA LabelLimiteSupPositivo 
JBE LabelLimiteInfNegativo 
LabelLimiteSupPositivo: 
FLD __var0
FCOMP _limiteSuperiorFloatPositivo
FSTSW __var2
MOV AX, __var2
SAHF
JB LabelNoOverflow 
JAE Error_Suma_Flotantes 
LabelLimiteInfNegativo: 
FLD __var0
FCOMP _limiteSuperiorFloatNegativo
FSTSW __var3
MOV AX, __var3
SAHF
JA LabelLimiteSupNegativo 
JBE Error_Suma_Flotantes 
LabelLimiteSupNegativo: 
FLD __var0
FCOMP _limiteInferiorFloatNegativo
FSTSW __var4
MOV AX, __var4
SAHF
JB LabelNoOverflow 
JAE LabelCero 
LabelCero: 
FLD __var0
FCOMP _limiteFloatCero
FSTSW __var5
MOV AX, __var5
SAHF
JNE Error_Suma_Flotantes 
LabelNoOverflow: 
FLD __var0
FSTP _x_main
invoke ExitProcess, 0
end start