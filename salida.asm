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
_tesmenorquew_ DB 't es menor que w', 0 
_t_main_f3 DQ ?
_w_main DD ?
_x_main DD ?
_y_main DQ ?
__var2 DD ?
__var1 DD ?
_f3_main DD ?
__var0 DW ?
_tesmayoroigualquew_ DB 't es mayor o igual que w', 0 
_5 DD 5
_22 DD 22
_20 DD 20
.code
Error_Suma_Enteros:
invoke MessageBox, NULL, addr _errorOverflowInt, addr _errorOverflowInt, MB_OK
invoke ExitProcess, 0
Error_Suma_Flotantes:
invoke MessageBox, NULL, addr _errorOverflowFloat, addr _errorOverflowFloat, MB_OK
invoke ExitProcess, 0

f3_main:
FLD _20
FSTP _t_main_f3
FLD _t_main_f3
FCOMP _w_main
FSTSW __var0
MOV AX, __var0
SAHF
JAE IF_CMP1
MOV EBX, _w_main
ADD EBX, _5
CMP EBX, _limiteSuperiorInt
JA Error_Suma_Enteros
MOV __var1, EBX
MOV EBX, __var1
MOV _w_main, EBX
invoke MessageBox, NULL, addr _tesmenorquew_, addr _tesmenorquew_, MB_OK 
JMP IF_THEN1
IF_CMP1:
invoke MessageBox, NULL, addr _tesmayoroigualquew_, addr _tesmayoroigualquew_, MB_OK 
IF_THEN1:
MOV EBX, _w_main
MOV __var2, EBX
ret

start:
FLD _x_main
FSTP _y_main
MOV EBX, _22
MOV _w_main, EBX
CALL f3_main
FLD __var2
FSTP _y_main
invoke ExitProcess, 0
end start