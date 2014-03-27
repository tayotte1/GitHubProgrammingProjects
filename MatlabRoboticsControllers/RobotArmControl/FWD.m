% Tom Ayotte
% Robots Lab 3
% Question 4

function [T] = FWD(vector)
pi = 3.14159265359;

d1 = .95;
alpha1 = pi/2;
a1 = .37;
theta1 = vector(1);
dh1 = [alpha1 a1 d1 theta1];

d2 = 0;
alpha2 = 0;
a2 = 1.05;
theta2 = vector(2);
dh2 = [alpha2 a2 d2 theta2];

d3 = 0;
alpha3 = pi/2;
a3 = .2;
theta3 = vector(3);
dh3 = [alpha3 a3 d3 theta3];

d4 = 1.25;
alpha4 = (3*pi)/2;
a4 = 0;
theta4 = vector(4);
dh4 = [alpha4 a4 d4 theta4];

d5 = 0;
alpha5 = pi/2;
a5 = 0;
theta5 = vector(5);
dh5 = [alpha5 a5 d5 theta5];

d6 = .27;
alpha6 = 0;
a6 = 0;
theta6 = vector(6);
dh6 = [alpha6 a6 d6 theta6];

T = DHF(dh1)*DHF(dh2)*DHF(dh3)*DHF(dh4)*DHF(dh5)*DHF(dh6);



