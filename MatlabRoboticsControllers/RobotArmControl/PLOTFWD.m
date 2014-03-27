function PLOTFWD(vector)
pi = 3.14159265359;
% Set DH parameters for each frame
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

% Calculate transformation matrices
p1 = DHF(dh1);
p2 = p1*DHF(dh2);
p3 = p2*DHF(dh3);
p4 = p3*DHF(dh4);
p5 = p4*DHF(dh5);
p6 = p5*DHF(dh6);


% Check if values are really small and set them to 0 for formatting
for m = 1:4
    for n = 1:4
        if p1(n,m) < .001 && p1(n,m) > -.001
            p1(n,m) = 0;
        end
        if p2(n,m) < .001 && p2(n,m) > -.001
            p2(n,m) = 0;
        end
        if p3(n,m) < .001 && p3(n,m) > -.001
            p3(n,m) = 0;
        end
        if p4(n,m) < .001 && p4(n,m) > -.001
            p4(n,m) = 0;
        end
        if p5(n,m) < .001 && p5(n,m) > -.001
            p5(n,m) = 0;
        end
        if p6(n,m) < .001 && p6(n,m) > -.001
            p6(n,m) = 0;
        end        
    end
end

p0 = [1 0 0 0; 0 1 0 0; 0 0 1 0; 0 0 0 1];
plotsmf(p0,'0') 
hold on
plotsmf(p1,'1')
plotsmf(p2,'2')
plotsmf(p3,'3')
plotsmf(p4,'4')
plotsmf(p5,'5')
plotsmf(p6,'6')

% Get points of each frame
p0 = [0;0;0;1];
p1 = p1(1:4,4);
p2 = p2(1:4,4);
p3 = p3(1:4,4);
p4 = p4(1:4,4);
p5 = p5(1:4,4);
p6 = p6(1:4,4);


% Plot wireframe of robot
plotv4(p0,p1)
hold on
plotv4(p1,p2)
plotv4(p2,p3)
plotv4(p3,p4)
plotv4(p4,p5)
plotv4(p5,p6)
hold off

