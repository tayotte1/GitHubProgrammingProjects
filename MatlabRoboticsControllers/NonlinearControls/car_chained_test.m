function f = car_chained_test
% Adapted from:
% EN.530.678: HW#3 sample
% steering for the unicycle by converting to chain-form
% and employing polynomial parametrization in v-space
%
% M. Kobilarov, Spring 2014

% Set initial and final states
qf = [0; 0; 0; 0];
q0 = [10; 7; -pi/4; 0];

T = 1;

[ts, qs] = car_traj(q0, qf, T);
% visualize
plot(qs(:,1), qs(:,2), '.');
hold on

% also plot direction to visualize the angle theta
quiver(qs(:,1), qs(:,2), .1*cos(qs(:,3)), .1*sin(qs(:,3)));
axis equal


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [ts, qs] = car_traj(q0, qf, T)

% transform 
z0 = q2z(q0);
zf = q2z(qf);

% compute control law coefficients
S.v1 = (zf(1) - z0(1))/T;

M = [ T^3/3,           T^2/2            T;
     (T^4/12)*S.v1,   (T^3/6)*S.v1,    (T^2/2)*S.v1;
     (T^5/60)*S.v1^2, (T^4/24)*S.v1^2, (T^3/6)*S.v1^2];

S.c = inv(M)*[zf(2) - z0(2);
              zf(3) - z0(3) - T*S.v1*z0(2);
              zf(4) - z0(4) - S.v1*z0(3)*T - (S.v1^2*z0(2)*T^2)/2];


% simulate system
[ts, qs] = ode45(@car_ode, [0 T], q0, [], S);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function z = q2z(q)
% coordinate transformation
z = [q(1); tan(q(4))/(cos(q(3))^3); tan(q(3)); q(2)];

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function u = car_ctrl(t, q, S)
% control law

v2 = S.c(3) + S.c(2)*t + S.c(1)*t^2;

% set up cos and sin of theta and phi to declutter
ct = cos(q(3));
st = sin(q(3));
cp = cos(q(4));
sp = sin(q(4));

u = [0;0];

u(1) = S.v1/(ct*cp);
u(2) = (v2 - (3*st*sp*tan(q(4))*u(1))/ct^4)*(ct^3*cp^2);



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function dq = car_ode(t, q, S)
% Car ODE
u = car_ctrl(t, q, S);

dq = [cos(q(3))*cos(q(4))*u(1);
      sin(q(3))*cos(q(4))*u(1);
      sin(q(4))*u(1);
      u(2)];

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%