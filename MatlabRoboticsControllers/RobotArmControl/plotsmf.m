function plotsmf(m,let)
%
% Function accepts a single 4x4 matrix and plots the frame
%
%  usage example:
%
%  h = [1 0 0 1; 0 1 0 0; 0 0 1 0; 0 0 0 1]
%  plotsmf(h) 
%
%
%
% 18 Sept 97 RB+LLW
%

[rows, cols] = size(m);
if ((rows ~= 4) | (cols ~= 4))
  error('PLOTF requires a 4x4 matrix argument. Check your dimensions.');
end

d = det(m);
if ((d <0.999) | (d >1.001))
  fprintf(1,'Error in PLOTF: the argument is not a rotation. Determinent is %f, should be 1.0\n',d);
  error('aborting');
end

zer=m(1:3,4);
veclen = 0.1;
plotv3(zer,zer+m(1:3,1)*veclen,'r');
hold on 
plotv3(zer,zer+m(1:3,2)*0.1,'y');
plotv3(zer,zer+m(1:3,3)*0.1,'c');
xx = strcat('X_',let);
yy = strcat('Y_',let);
zz = strcat('Z_',let);
text(m(1,4)+veclen*m(1,1),m(2,4)+veclen*m(2,1),m(3,4)+veclen*m(3,1),xx);
text(m(1,4)+veclen*m(1,2),m(2,4)+veclen*m(2,2),m(3,4)+veclen*m(3,2),yy);
text(m(1,4)+veclen*m(1,3),m(2,4)+veclen*m(2,3),m(3,4)+veclen*m(3,3),zz);

xlabel('X_0');
ylabel('Y_0');
zlabel('Z_0');

axis equal;
grid on;
