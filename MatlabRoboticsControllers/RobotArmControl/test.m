% Tom Ayotte
% Robots Lab 4

% This code was adapted from code written by Ryan Keating

% Test 1
theta = [-pi/4;pi/2;-pi;pi/3;pi/4;3*pi/2];
figure(1)
T = FWD(theta)
G = T*[0;0;0;1];
PLOTFWD(theta)
hold on
a = M900INV(FWD(theta))
PLOTFWD(M900INV(FWD(theta)))
hold on
plot3(G(1),G(2),G(3),'g*');
axis([-2 2 -2 2 -2 3.3])
view(3)
hold off

% Test 2
theta = [0;pi/2;2*pi/3;pi/3;pi;3*pi/10];
figure(2)
T = FWD(theta)
G = T*[0;0;0;1];
PLOTFWD(theta);
hold on
a = M900INV(FWD(theta))
PLOTFWD(M900INV(FWD(theta)))
hold on
plot3(G(1),G(2),G(3),'g*');
axis([-2 2 -2 2 -2 3.3])
view(3)

% Unreachable Example
theta = [-pi/12;pi/2;pi;pi/3;-pi/4;3*pi/5];
figure(3)
T = FWD(theta);
T(1,4) = T(1,4)+8;
G = T*[0;0;0;1];
%PLOTFWD(theta);
hold on
M900INV(T)
PLOTFWD(M900INV(T))
hold on
plot3(G(1),G(2),G(3),'g*');
hold off
axis([-7 7 -7 7 -7 7])
view(3)


% Non-Unique Example
theta = [0;pi/2;2*pi/3;pi/4;0;pi/4];
figure(4)
T = FWD(theta)
G = T*[0;0;0;1];
PLOTFWD(theta);
hold on
a = M900INV(FWD(theta))
PLOTFWD(M900INV(FWD(theta)))
hold on
plot3(G(1),G(2),G(3),'g*');
axis([-2 2 -2 2 -2 3.3])
view(3)

