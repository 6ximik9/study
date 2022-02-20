Assume d:da, s:ss, c:cs

s segment 
    db 255 ?(dup)
s ends


d segment 
    x dw 0
    y dw 0
    z dw 0   
    b dw 0
    
d ends 



c segment 
start:
    mov x, 2
    mov y, 5
    mov z, 4  
    mov b, 10
    
    
    mov CX, 5 
    a1:
    
    a2:
            
   mov AX, y         
   sub AX, z
   mul b
   mul x
    
   add x,2
   cmp x,10
   jle a2
   
   mov x, 2 
   add y,1
   loop a1