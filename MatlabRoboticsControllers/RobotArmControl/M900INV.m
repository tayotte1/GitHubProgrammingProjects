% Tom Ayotte
% Robots Lab 4
% 
function [angles] = M900INV(T)

p = T*[0;0;-.27;1];

angles = THREEINV(p(1:3));
if angles ~= zeros(6,1)
    d1 = .95;
    alpha1 = pi/2;
    a1 = .37;
    theta1 = angles(1);
    dh1 = [alpha1 a1 d1 theta1];

    d2 = 0;
    alpha2 = 0;
    a2 = 1.05;
    theta2 = angles(2);
    dh2 = [alpha2 a2 d2 theta2];

    d3 = 0;
    alpha3 = pi/2;
    a3 = .2;
    theta3 = angles(3);
    dh3 = [alpha3 a3 d3 theta3];

    T03 = DHF(dh1)*DHF(dh2)*DHF(dh3);

    R03 = T03(1:3,1:3);
    R06 = T(1:3,1:3);

    R36 = R03'*R06;

    angles(4,1) = atan2(R36(2,3),R36(1,3));
    angles(5,1) = atan2(sqrt(1-R36(3,3)^2),R36(3,3));
    angles(6,1) = atan2(R36(3,2),-R36(3,1));
end
