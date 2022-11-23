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
_limiteSuperiorFloatPositivo DQ 41.402824
_errorOverflowInt DB "Error suma enteros", 0
_errorOverflowFloat DB "Error suma flotante" , 0
_x_main DD ?
_id_main DD ?
_z_main DD ?
_3 DD 3
_1 DD 1
_84 DD 84
_0 DD 0
.code
Error_Suma_Enteros:
invoke MessageBox, NULL, addr _errorOverflowInt, _errorOverflowInt, MB_OK
invoke ExitProcess, 0
Error_Suma_Flotantes:
invoke MessageBox, NULL, addr _errorOverflowFloat, addr _errorOverflowFloat, MB_OK
invoke ExitProcess, 0
start:
MOV EBX, _0
MOV _id_main, EBX
outer_main:
MOV EBX, _id_main
CMP EBX, _84
JG FOR_CMP1
MOV EBX, _id_main
ADD EBX, _3
MOV _id_main, EBX
MOV EBX, _0
MOV _x_main, EBX
outer2_main:
MOV EBX, _x_main
CMP EBX, _id_main
JG FOR_CMP2
MOV EBX, _x_main
ADD EBX, _1
MOV _x_main, EBX
JMP outer2_main
FOR_CMP2:
JMP outer_main
FOR_CMP1:
invoke ExitProcess, 0
end start