 t = (0 : .1 : 250);
 t1 = (250 : -.1 : 0);
 D1 = 5;
 D2 = 1.5;
%PLOT MIDDLE LINE
    n = 1;
    for q = 0 : .1  : 250;
        x(n) = 5*exp(.01*q)*sin(.03*q);
        n = n+1;
    end
    figure(1)
    plot(t,x)
    hold on

%PLOT BOTTOM LINE
    n = 2501;
    for q = 0 : .1  : 250;
        x1(n) = 5*exp(.01*q)*sin(.03*q) - 1/cos(atan(exp(.01*q)*(.05*sin(.03*q)+.15*cos(.03*q))));
        n = n-1;
    end
    plot(t1,x1,'r')
    

%PLOT TOP LINE
    n = 1;
    for q = 0 : .1  : 250;
        x2(n) = 5*exp(.01*q)*sin(.03*q) + 1/cos(atan(exp(.01*q)*(.05*sin(.03*q)+.15*cos(.03*q))));
        n = n+1;
    end

    plot(t,x2, 'r')
    
%PLOT CART ORIENTATION
for q = 1 : 500 : 2501
    cartXX = t(q) + D1*cos(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));
    cartXY = x(q) + D1*sin(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));

    cartYY = x(q) + D1*cos(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));
    cartYX = t(q) - D1*sin(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));
    
    leftXSensorX = cartXX - D2*sin(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));
    leftXSensorY = cartXY + D2*cos(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));
    rightXSensorX = cartXX + D2*sin(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));
    rightXSensorY = cartXY - D2*cos(atan(exp(.01*t(q))*(.05*sin(.03*t(q))+.15*cos(.03*t(q)))));
    ySensorX = cartXX;
    ySensorY = cartXY;

    plot([t(q) cartXX],[x(q) cartXY],'g',[t(q) cartYX],[x(q) cartYY],'g','LineWidth', 5)
    plot(t(q),x(q),'o')
    plot(leftXSensorX,leftXSensorY,'.')
    plot(rightXSensorX,rightXSensorY,'.')
    plot(ySensorX,ySensorY,'.')
    
end
    axis([-5 255 -130 130]);
    hold off
