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
_errorCero DB "Error division", 0
_errorNegativo DB "Error resta" , 0
_ceroDOUBLE DQ 0.0
_ceroULONGINT DD 0
_2.4 DQ 2.4
_2.3 DQ 2.3
__var0 DQ ?
_z.main DQ ?

.code
start: 
.code
Error_Resta_Negativa:
invoke MessageBox, NULL, addr _errorNegativo, addr _errorNegativo, MB_OK
invoke ExitProcess, 0
Error_Division_Cero:
invoke MessageBox, NULL, addr _errorCero, addr _errorCero, MB_OK
invoke ExitProcess, 0
START:
FNINIT
FLD _2.3
FLD _2.4
FADD
FSTP __var0
FLD __var0
FSTP _z.main
nullinvoke ExitProcess, 0
END STARTinvoke ExitProcess, 0
end start