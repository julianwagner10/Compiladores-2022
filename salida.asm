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
_x_main DD ?
_46 DD 46
__var1 DD ?
_id_main DD ?
_a1_main DQ ?
_z_main DD ?
_4 DD 4
_2 DD 2
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

start:
MOV EBX, _2
MOV _id_main, EBX
FOR_INICIO 1:
MOV EBX, _id_main
CMP EBX, _4
JLE FOR_CMP 1
MOV EBX, _id_main
ADD EBX, _2
MOV _id_main, EBX
MOV EBX, 2
MOV _z_main, EBX
MOV EBX, _x_main
CMP EBX, _z_main
JLE IF_CMP 1
MOV EBX, _z_main
MOV _var1, EBX
JMP BREAK_CTRL 1
IF_CMP 1:
JMP FOR_INICIO 1
FOR_CMP 1:
MOV EBX, _46
MOV _var1, EBX
BREAK_CTRL 1:
FLD _var1
FSTP _a1_main
invoke ExitProcess, 0
end start