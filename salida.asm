.386
.model flat, stdcall
option casemap :none
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib

.data
.data
_errorOverflowInt DB "Error suma enteros", 0
_errorOverflowFloat DB "Error suma flotante" , 0
_errorRecursionPropia DB "Error en invocacion a funcion" , 0
_2.5 DQ 2.5
_x.main DQ ?
_y.main DQ ?
__var0 DQ ?

.code
start: 
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

FLD _x.main
FCOMP 2.5
FSTSW __var0
MOV AX, __var0
SAHF
JBE IF_CMP 1
FLD x.main
FSTP y.main
JMP IF_THEN 1
IF_CMP 1:
IF_THEN 1:
invoke ExitProcess, 0
END STARTinvoke ExitProcess, 0
end start