    Title labrob1
    Assume cs:c, ds:d, ss:s

 s  segment stack
    dw  128 dup(?)
s ends
 
d segment 
    x dw 1
    y dw -6
    z dw 1
    f dw 0
    a dw 0
    
d ends

c segment

start: 
    mov x,1
    mov y,1
    mov z,3
    
    mov AX,18
    mul x
    mov BX,AX
    
    mov AX,9
    mul y
    add BX,Ax
    add BX, -5
    
    mov a,BX
    mov AX,3
    mul z
    sub AX,2
    
    mov BX,a
    
            div BX 


c   ends
    end start