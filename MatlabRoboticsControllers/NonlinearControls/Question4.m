% Question 4:

clc

% Set T
T = 10;

% Solving for A:

L = [0 0 T^3 3*T^2;
     0 0 T^2 2*T;
     0 1 T 1;
     1 0 1 0];

in = inv(L);
   
Y = [0,1,5,1;
    5,0,2.5,0];

A = Y*in

Y = [5,-1,0,-1;
    2.5,0,0,0];

A = Y*in

% =========================================

% Call car_flat_care to get the parallel parking trajectory

% First trajectory:
x0 = [0; 5; 0];
xf = [5; 2.5; 0];

car_flat_care(x0,xf,1)
hold on


% Second trajectory:
x0 = [5; 2.5; 0];
xf = [0; 0; 0];

car_flat_care(x0,xf,-1)
