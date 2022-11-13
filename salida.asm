.386
.model flat, stdcall
option casemap :none
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib
.data
_limiteSuperiorInt DD 2147483647
_limiteInferiorInt DD -2147483648
_limiteInferiorFloatPositivo DQ -36.824505
_limiteSuperiorFloatPositivo DQ 41.402824
_limiteInferiorFloatNegativo DQ -39.175495
_limiteSuperiorFloatNegativo DQ 34.597176
_errorOverflowInt DB "Error suma enteros", 0
_errorOverflowFloat DB "Error suma flotante" , 0
_errorRecursionPropia DB "Error en invocacion a funcion" , 0
_2_2 DQ 2.2
_x_main_f1 DD ?
_w_main DD ?
_f1_main DD ?
_y_main DD ?
__var1 DD ?
__var0 DD ?
_z_main DQ ?
_23 DD 23
_2 DD 2
_t_main DD ?
.code
Error_Suma_Enteros:
invoke MessageBox, NULL, addr _errorOverflowInt, _errorOverflowInt, MB_OK
invoke ExitProcess, 0
Error_Suma_Flotantes:
invoke MessageBox, NULL, addr _errorOverflowFloat, addr _errorOverflowFloat, MB_OK
invoke ExitProcess, 0
Error_Invocacion_Funcion:
invoke MessageBox, NULL, addr _errorRecursionPropia, addr _errorRecursionPropia, MB_OK
invoke ExitProcess, 0

f1.main:
MOV EBX, _x.main.f1
CMP EBX, _y.main
JGE IF_CMP 1
MOV EBX, _y_main
ADD EBX, _2
CMP EBX, _limiteSuperiorInt
JG Error_Suma_Enteros
MOV _var0, EBX
MOV EBX, __var0
MOV _y_main, EBX
JMP IF_THEN 1
IF_CMP 1:
MOV EBX, _x_main_f1
MOV _y_main, EBX
IF_THEN 1:
ret

start:
MOV EBX, _t_main
ADD EBX, _w_main
CMP EBX, _limiteSuperiorInt
JG Error_Suma_Enteros
MOV _var1, EBX
MOV EBX, __var1
MOV _t_main, EBX
MOV _y.main, _23
FLD _2.2
FSTP _z.main
CALL f1.main
invoke ExitProcess, 0
end start