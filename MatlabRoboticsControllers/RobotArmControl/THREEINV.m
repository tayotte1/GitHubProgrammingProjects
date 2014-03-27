% Tom Ayotte
% Robots Lab 4

function [angles] = THREEINV(vector)

l1 = 1.05;
l2 = sqrt(1.25^2+.2^2);
Z = vector(3)-.95;
X = sqrt(vector(1)^2+vector(2)^2)-.37;
alpha = atan2(Z,X);
beta = acos((l2^2-l1^2-Z^2-X^2)/(-2*l1*sqrt(X^2+Z^2)));
gamma = acos((X^2+Z^2-l1^2-l2^2)/(-2*l1*l2));

test = sqrt(X^2+Z^2);


if test > l1+l2 || test < abs(l2-l1)
    'Error Point Out of Bounds'
    theta1 = 0;
    theta2 = 0;
    theta3 = 0;
else

    theta1 = atan2(vector(2),vector(1));

    if test == l2-l1
        theta2 = alpha + beta - pi;
        theta3 = pi;
    elseif test == l2+l1
        theta2 = alpha;
        theta3 = 0;
    elseif X < 0
        theta2 = alpha - beta;
        theta3 = pi - gamma + atan2(1.25,.2);
    else
        theta2 = alpha + beta;
        theta3 = gamma + pi + atan2(1.25,.2);
    end

end



angles = [theta1;theta2;theta3;0;0;0];



