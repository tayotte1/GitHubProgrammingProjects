%Tom Ayotte

function xdot = eom(t, q)

% Set parameters:
m = 1;
D = diag([.01, .1, .02]);
J = .1;
r = .2;
M = [m,0,0;0,m,0;0,0,J];

% propotional control gains
kp = [1,0,0; 0,1,0; 0,0,1];
% derivative control gains
kd = [2,0,0; 0,2,0; 0,0,2];

pos = [q(1);q(2);q(3)];
vel = [q(4);q(5);q(6)];
x = [pos;vel];

xdot = [zeros(3), diag([1,1,1]); -inv(M)*kp, -inv(M)*(D+kd)]*x;


  
  