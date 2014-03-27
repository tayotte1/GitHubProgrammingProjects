function f = car_flat_care(x0,xf,u1)
% Adapted from:
% EN.530.678: HW#3 sample
% 1) compute a reference path using a polynomial in flat output space
% 2) track the path using the the linearized dynamics
%
% M. Kobilarov, Spring 2014


% boundary conditions in state space
T = 10;

%%%%%%%%% TRAJECTORY GENERATION %%%%%%%%%%%%%

% norm of initial and final velocity along desired path
% it determines how much the curves will bend
% and can be freely chosen

% I use it to determine the direction of motion
S.u1 = u1;

% boundary conditions in flat output space 
y0 = car_h(x0);
yf = car_h(xf);
dy0 = S.u1*[cos(x0(3)); sin(x0(3))]; % desired starting velocity
dyf = S.u1*[cos(xf(3)); sin(xf(3))]; % desired end velocity

% compute path coefficients
A = poly3_coeff(y0, dy0, yf, dyf, T);

% plot desired path
X = A*poly3([0:.01:T]);
plot(X(1,:), X(2,:), '--r', 'LineWidth',1.5)
hold on


%%%%%%%%% TRAJECTORY TRACKING %%%%%%%%%%%%%
S.A = A;

% perturb initial condition if its the first trajectory
if(S.u1>0)
    x = x0 + [.25;.25;.1];
else
    x = x0;
end

% simulate system
[ts, xs] = ode45(@car_ode, [0 T], x, [], S);

% visualize
plot(xs(:,1), xs(:,2), '.b', 'LineWidth', 1.5);

legend('desired', 'executed')


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


function A = poly3_coeff(y0, dy0, yf, dyf, T)
% computes cubic curve connecting (y0,dy0) and (yf, dyf) at time T

Y = [y0, dy0, yf, dyf];
L = [poly3(0), dpoly3(0), poly3(T), dpoly3(T)];
A = Y*inv(L);


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function y = car_h(x)
% output function

y = x(1:2);


function f = poly3(t)
f = [t.^3; t.^2; t; ones(size(t))];

function f = dpoly3(t)
f = [3*t.^2; 2*t; ones(size(t)); zeros(size(t))];

function f = d2poly3(t)
f = [6*t; 2; zeros(size(t)); zeros(size(t))];


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


function u = car_ctrl(t, x, S)
% tracking control law

% get desired outputs (x-y positions, velocities, accelerations)
yd = S.A*poly3(t);
dyd = S.A*dpoly3(t);
d2yd = S.A*d2poly3(t);

% desired angle
x3d = atan(dyd(2)/dyd(1));

xd = [yd; x3d];

num = S.u1*(dyd(1)*d2yd(2) - d2yd(1)*dyd(2));
den = (dyd(1)^2 + dyd(2)^2)^(3/2);


% desired inputs
ud = [S.u1*norm(dyd); 
      atan(num/den)];

% linearization, i.e. \dot (x - xd) = A(x - xd) + B(u - ud)
A = [0 0 -sin(x3d);
     0 0 cos(x3d);
     0 0 0]*ud(1);

B = [cos(x3d) 0;
     sin(x3d) 0;
     tan(ud(2)) ud(1)*sec(ud(2))^2];

% compute gain matrix for linear system (this solves the Lyapunov
% equation for the linearization dynamics)
[X,L,K] = care(A, B, eye(3));

% set control law
u = ud - K*(x - xd);


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function dq = car_ode(t, q, S)
% Car ODE
u = car_ctrl(t, q, S);

dq = [cos(q(3))*u(1);
      sin(q(3))*u(1);
      u(1)*tan(u(2))];

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
