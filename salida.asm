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
_limiteSuperiorFloatPositivo DQ 41.402824
_errorOverflowInt DB "Error suma enteros", 0
_errorOverflowFloat DB "Error suma flotante" , 0
_f1_main DD ?
_f3_main_f1 DD ?
_21 DD 21
_z_main_f1 DQ ?
_x_main_f1 DD ?
_v_main DD ?
_x_main DD ?
_4 DD 4
__var4 DD ?
__var3 DD ?
_2 DD 2
_45 DD 45
__var2 DD ?
__var1 DD ?
__var0 DD ?
_2_5 DQ 2.5
_f2_main_f1 DD ?
_t_main_f1_f3 DD ?
_w_main_f1 DD ?
_y_main DD ?
_x_main_f1_f2 DD ?
.code
Error_Suma_Enteros:
invoke MessageBox, NULL, addr _errorOverflowInt, _errorOverflowInt, MB_OK
invoke ExitProcess, 0
Error_Suma_Flotantes:
invoke MessageBox, NULL, addr _errorOverflowFloat, addr _errorOverflowFloat, MB_OK
invoke ExitProcess, 0
f3_main_f1:
MOV EBX, _w_main_f1
CMP EBX, _y_main
JGE IF_CMP 1
MOV EBX, _y_main
ADD EBX, _2
CMP EBX, _limiteSuperiorInt
JG Error_Suma_Enteros
MOV _var0, EBX
MOV EBX, _var0
MOV _y_main, EBX
MOV EBX, y_main
MOV _w_main_f1, EBX
JMP IF_THEN 1
IF_CMP 1:
IF_THEN 1:
MOV EBX, t_main_f1_f3
MOV _var1, EBX
ret

f2_main_f1:
MOV EBX, _x_main_f1_f2
CMP EBX, _y_main
JGE IF_CMP 3
MOV EBX, y_main
MOV _x_main_f1_f2, EBX
MOV EBX, _y_main
ADD EBX, _2
CMP EBX, _limiteSuperiorInt
JG Error_Suma_Enteros
MOV _var2, EBX
MOV EBX, _var2
MOV _y_main, EBX
JMP IF_THEN 2
IF_CMP 3:
MOV EBX, x_main_f1_f2
MOV _y_main, EBX
IF_THEN 2:
MOV EBX, y_main
MOV _var3, EBX
ret

f1_main:
FLD _2_5
FSTP _z_main_f1
CALL f2_main_f1
MOV EBX, _var3
MOV _x_main_f1, EBX
MOV _w_main_f1, _45
CALL f3_main_f1
MOV EBX, _var1
MOV _y_main, EBX
MOV EBX, x_main_f1
MOV _var4, EBX
ret

start:
MOV _y_main, _21
MOV _v_main, _4
CALL f1_main
MOV EBX, _var4
MOV _x_main, EBX
invoke ExitProcess, 0
end start