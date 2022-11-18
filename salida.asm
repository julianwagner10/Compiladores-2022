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
_errorRecursionPropia DB "Error en invocacion a funcion, se detecto una recursion de la misma" , 0
_w_main DD ?
_x_main DD ?
__var3 DD ?
_y_main DD ?
__var2 DD ?
_id_main DD ?
_10 DD 10
_2 DD 2
_1 DD 1
_0 DD 0
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
CMP EBX, _10
JG FOR_CMP 1
MOV EBX, _id_main
ADD EBX, _2
MOV _id_main, EBX
MOV EBX, _0
MOV _w_main, EBX
FOR_INICIO 2:
MOV EBX, _w_main
CMP EBX, _id_main
JG FOR_CMP 2
MOV EBX, _w_main
ADD EBX, _1
MOV _w_main, EBX
MOV EBX, _y_main
CMP EBX, _w_main
JNE IF_CMP 1
MOV EBX, _y_main
SUB EBX, _w_main
CMP EBX, _limiteInferioINT
JA Error_Suma_Enteros
MOV _var2, EBX
MOV EBX, _var2
MOV _y_main, EBX
JMP IF_THEN 1
IF_CMP 1:
IF_THEN 1:
JMP FOR_INICIO 2
FOR_CMP 2:
MOV EBX, _y_main
ADD EBX, _2
CMP EBX, _limiteSuperiorInt
JG Error_Suma_Enteros
MOV _var3, EBX
MOV EBX, _var3
MOV _x_main, EBX
MOV EBX, _x_main
CMP EBX, _y_main
JGE IF_CMP 3
JMP FOR_INICIO 1
JMP IF_THEN 2
IF_CMP 3:
JMP FOR_CMP 1
IF_THEN 2:
JMP FOR_INICIO 1
FOR_CMP 1:
invoke ExitProcess, 0
end start