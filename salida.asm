.386
.model flat, stdcall
option casemap :none
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib

.data

errorOverflowInt db "Error suma enteros", 0

.code

start:

invoke MessageBox, NULL, addr errorOverflowInt, errorOverflowInt, MB_OK



end start