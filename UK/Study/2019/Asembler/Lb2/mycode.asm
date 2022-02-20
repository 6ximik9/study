; the current cursor position: 

PUTC    MACRO   char
        PUSH    AX
        MOV     AL, char
        MOV     AH, 0Eh
        INT     10h
        POP     AX
ENDM
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


org 100h

;;;;;;;;;;;;;;;;;;;;;;;;;;;;
jmp start
msg_task db 'Task: f=(5z-4x)/(y-8)$'
msg1 db 'Enter valure of x: $'  
msg2 db 'Enter valure of y: $'
msg3 db 'Enter valure of z: $'
msg4 db 0dh,0ah, 'Enter valure of x: $' 

; first, second and third (x, y, z) number:
x dw ?
y dw ?
z dw ?
scan_num dw 0  
print_num dw 0

; imput from users
start:
 ; new line:
 putc 0Dh
 putc 0Ah
 lea dx, msg1
 mov ah, 09h
 int 21h     
 
call scan_num
mov x, cx      

putc 0Dh   
putc 0Ah

lea dx, msg2
mov ah, 09h
int 21h      

call scan_num
mov y, cx

putc 0Dh
putc 0Ah

lea dx, msg3
mov ah, 09h
int 21h

call scan_num
mov z, cx

putc 0Dh
putc 0Ah


lea dx, msg4
mov ah, 09h
int 21h
                   
cmp y, 2
jb m1

cmp x,5
jg m1

cmp y, 0
jg m2

cmp z,8
jb m2     



mov ax, 3
mul x
jmp stop

m1:
mov ax,2
imul x
xchg ax,bx
mov ax,3
imul y
add ax,bx
imul z
jmp stop

m2:
mov ax,3
imul x
imul x
sub ax, z
mov cx, y
sub cx,1
IDIV cx
jmp stop

stop:
call print_num
mov ah, 0
int 16h

ret ;return back to os.
