    Title labrob2
    Assume cs:c, ds:d, ss:s

 s  segment stack
    dw  128 dup(?)
s ends
 
d segment 
    x dw ?
    y dw ?
    z dw ?
    
d ends

c segment

start:
mov y, 2
mov x, 0 
mov z, 9
   ;(y<2 and x>5)
cmp y,2 
jl m1
  ;===============
  
  ;(x>0 or z<8)      
c2:
cmp x, 0
jg m2 
cmp z, 8
jl m2
  ;===============
  
  ;else
mov AX, 3
mul z 
jmp stop
  ;===============        
            
 ;(2x+3y)*z      
m1:  
cmp x,5
jl c2 
mov AX,2
mul x
xchg AX,BX
mov AX,3
mul y
add AX,BX
mul z 
jmp stop
     
  ;(3x - z)/y-1   
m2:  
mov AX, y
sub AX,1 
xchg BX,AX
mov AX,3
mul x
sub AX, z 
DIV BX  
jmp stop
stop:
c   ends
    end start