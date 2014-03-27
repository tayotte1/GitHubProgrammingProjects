%Tom Ayotte

function xdot = eom2(t, q, r0, p0, k0)

% Set parameters:
m = 1;
D = diag([.01, .1, .02]);
J = .1;
r = .2;
M = [m,0,0;0,m,0;0,0,J];
d0 = 1;
dq = sqrt((q(1)-p0(1))^2 + (q(2)-p0(2))^2) - r0;
c = [0,-1,0;1,0,0;0,0,0];
K0 = (k0/dq)*c;



% propotional control gains
kp = [1,0,0; 0,1,0; 0,0,1];
% derivative control gains
kd = [2,0,0; 0,2,0; 0,0,2];

pos = [q(1);q(2);q(3)];
vel = [q(4);q(5);q(6)];
x = [pos;vel];

%From Kobilarov Example HW
g = pos(1:2) - p0;     
g = dq*g/norm(g);     % direction vector from obstacle to position
a = -vel(1:2)'*g/(norm(vel(1:2))*dq);

if dq < d0 && a > 0
    xdot = [zeros(3), diag([1,1,1]); -inv(M)*kp, -inv(M)*(D+kd+K0)]*x;
else
    xdot = [zeros(3), diag([1,1,1]); -inv(M)*kp, -inv(M)*(D+kd)]*x;
end