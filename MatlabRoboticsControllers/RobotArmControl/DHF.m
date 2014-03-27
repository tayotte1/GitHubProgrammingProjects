% Tom Ayotte
% Robots Lab 3
% Question 1

function [T] = DHF(vector)

alpha = vector(1);
a = vector(2);
d = vector(3);
theta = vector(4);

T = [cos(theta) -sin(theta)*cos(alpha) sin(theta)*sin(alpha) a*cos(theta);
    sin(theta) cos(theta)*cos(alpha) -cos(theta)*sin(alpha) a*sin(theta);
    0 sin(alpha) cos(alpha) d;
    0 0 0 1];
