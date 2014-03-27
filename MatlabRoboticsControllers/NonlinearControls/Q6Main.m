% Tom Ayotte
% Nonlinear Control HW1 Q6
% Feb 19, 2014

clc

%============ Obstacle-Free Case =============%


% Delete previous line to run

figure(1)
%Zero Initial Velocity
q0 = [3; 2; -pi/4; 0; 0; 0];
[tvec,xvec] = ode45(@eom,[0,10],q0);
plot(xvec(:,1),xvec(:,2),'mo');

%Non Zero Initial Velocity
q0 = [3; 2; -pi/4; 1; 0; 0];
[tvec,xvec] = ode45(@eom,[0,10],q0);
hold on
plot(xvec(:,1),xvec(:,2),'go');
hold off
legend('Zero Initial Velocity','[1 0 0] Initial Velocity','Location','NorthWest');
title('Obstacle Free');
%}



%============ Obstacle Avoidance =============%


% Delete previous line to run

figure(2)
% Plot Obstacle, From Kobilarov Example HW:
p0 = [1;1]; % position
r0 = .25; % obstacle radius
ellipsoid(p0(1),p0(2), 0, r0, r0, 0);
hold on

%Obstacle Avoidance
k0=10;
%Zero Initial Velocity
q0 = [3; 2; -pi/4; 0; 0; 0];
[tvec,xvec] = ode45(@eom2,[0,30], q0, [], r0, p0, k0);
plot(xvec(:,1),xvec(:,2),'mo');

%Non Zero Initial Velocity
q0 = [3; 2; -pi/4; -2; 2; 0];
[tvec,xvec] = ode45(@eom2,[0,30], q0, [], r0, p0, k0);
hold on
plot(xvec(:,1),xvec(:,2),'go');

axis([-1 4 -1 4])
legend('[-2 2 0] Initial Velocity','Zero Initial Velocity','Location','NorthWest');
title('Obstacle Avoidance');
%}

%============ Obstacle Avoidance, Changing k0 =============%


% Delete previous line to run

figure(3)
% plot obstacle, From Kobilarov example HW:
p0 = [1;1]; % position
r0 = .25; % obstacle radius
ellipsoid(p0(1),p0(2), 0, r0, r0, 0);
hold on

colorVec = hsv(5);
i = 1;
%Zero Initial Velocity
q0 = [3; 2; -pi/4; 0; 0; 0];
for k0 = 1:4:10
    [tvec,xvec] = ode45(@eom2,[0,30], q0, [], r0, p0, k0);
    plot(xvec(:,1),xvec(:,2),'o','Color',colorVec(i,:));
    i = i+1;
end
axis([-1 4 -1 4])
% I don't know why the legend order gets all screwed up
legend('k0=9','k0=1','k0=5','Location','NorthWest');
title('Obstacle Avoidance, Changing k0');
%}

