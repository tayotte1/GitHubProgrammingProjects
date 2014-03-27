% Tom Ayotte
% Robots Lab 4
% Question 3
close all

a = THREEINV([0;0;3])
PLOTFWD(a)
axis([-3 3 -3 3 -3 3])
view(3)
text(0,0,3.5,'0,0,3')

figure(2)
a2 = THREEINV([1;2;1])
PLOTFWD(a2)
axis([-3 3 -3 3 -3 3])
view(3)
text(1,2,1.5,'1,2,1')

