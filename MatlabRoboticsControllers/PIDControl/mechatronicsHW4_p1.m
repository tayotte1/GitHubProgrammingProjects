    t = (0 : .1 : 250);
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
    n = 1;
    for q = 0 : .1  : 250;
        x1(n) = 5*exp(.01*q)*sin(.03*q) - 1/cos(atan(exp(.01*q)*(.05*sin(.03*q)+.15*cos(.03*q))));
        n = n+1;
    end
    plot(t,x1,'r')
    

%PLOT TOP LINE
    n = 1;
    for q = 0 : .1  : 250;
        x2(n) = 5*exp(.01*q)*sin(.03*q) + 1/cos(atan(exp(.01*q)*(.05*sin(.03*q)+.15*cos(.03*q))));
        n = n+1;
    end

    plot(t,x2, 'r')
    axis([0 250 -125 125]);
    hold off
