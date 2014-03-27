 clc
 clear
 t = (0 : .1 : 250);
 t1 = (250 : -.1 : 0);
 D1 = 2.5;
 D2 = 1.75;
 L = 5;
 r = 1;
 qq = 1;
 
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
    %plot(t1,x1,'r')
    

%PLOT TOP LINE
    n = 1;
    for q = 0 : .1  : 250;
        x2(n) = 5*exp(.01*q)*sin(.03*q) + 1/cos(atan(exp(.01*q)*(.05*sin(.03*q)+.15*cos(.03*q))));
        n = n+1;
    end

    %plot(t,x2, 'r')

% Make the polygon
    polyX(1:2501) = x2;
    polyX(2502:5002) = x1;
    polyX(5003) = x2(1);
    
    polyT(1:2501) = t;
    polyT(2502:5002) = t1;
    polyT(5003) = t(1);
    
    plot(polyT,polyX,'r');

%=========================================================================    
    
% Set initial position    
    cartX(1) = 0;
    cartY(1) = 0;
    phiLEFT = .5;
    phiRIGHT = .7;
    theta(1) = 0;
    
    n = 1;
    for z = 0 : qq : 1200
% Determine orientation    
        cartXX(n) = cartX(n) + D1*cos(atan(theta(n)));
        cartXY(n) = cartY(n) + D1*sin(atan(theta(n)));

        cartYY(n) = cartY(n) + D1*cos(atan(theta(n)));
        cartYX(n) = cartX(n) - D1*sin(atan(theta(n)));

% Place Sensors    
        leftXSensorX(n) = cartXX(n) - D2*sin(atan(theta(n)));
        leftXSensorY(n) = cartXY(n) + D2*cos(atan(theta(n)));
        rightXSensorX(n) = cartXX(n) + D2*sin(atan(theta(n)));
        rightXSensorY(n) = cartXY(n) - D2*cos(atan(theta(n)));
        ySensorX(n) = cartXX(n);
        ySensorY(n) = cartXY(n);

% Check Sensors
        inLEFT(n) = inpolygon(leftXSensorX(n),leftXSensorY(n),polyT,polyX);
        inRIGHT(n) = inpolygon(rightXSensorX(n),rightXSensorY(n),polyT,polyX);
        inY(n) = inpolygon(ySensorX(n),ySensorY(n),polyT,polyX);

        
% New Cart x,y,theta        
        cart(1:3,n+1) = [cartX(n);cartY(n);theta(n)] + [(r/2)*cos(theta(n)) (r/2)*cos(theta(n));(r/2)*sin(theta(n)) (r/2)*sin(theta(n));-r/L r/L]*[phiLEFT*qq;phiRIGHT*qq];

% Set new x,y,theta
        cartX(n+1) = cart(1,n+1);
        cartY(n+1) = cart(2,n+1);
        theta(n+1) = cart(3,n+1); 
        
% Set new phis        
        if inLEFT(n) == 1
            left = '.r';
        else
            left = '.';
        end

        if inRIGHT(n) == 1
            right = '.r';
        else
            right = '.';
        end

        if inY(n) == 1
            ySens = '.r';
        else
            ySens = '.';
            break;
        end


	if inLEFT(n) == 0 && inRIGHT(n) == 0 && inY(n) == 0
		phiLEFT = 0;
		phiRIGHT = 0;
		break;
	else if inLEFT(n) == 1 && inRIGHT(n) == 0 && inY(n) == 0
		state(n) = -2;
	else if inLEFT(n) == 1 && inRIGHT(n) == 1 && inY(n) == 0
		state(n) = -1;
	else if inLEFT(n) == 0 && inRIGHT(n) == 1 && inY(n) == 0
		state(n) = 0;
	else if inLEFT(n) == 0 && inRIGHT(n) == 1 && inY(n) == 1
		state(n) = 1;
	else if inLEFT(n) == 0 && inRIGHT(n) == 0 && inY(n) == 1
		state(n) = 2;
	end

if n == 1
	error(n) = state(n) - 0;
else
	error(n) = state(n) - state(n-1)
end
        

% Plot everything        
        plot(leftXSensorX(n),leftXSensorY(n),left)
        plot(rightXSensorX(n),rightXSensorY(n),right)
        plot(ySensorX(n),ySensorY(n),ySens)
        
        if mod(n,21) == 0
            plot([cartX(n) 1.1*cartXX(n)],[cartY(n) 1.1*cartXY(n)],'g',[cartX(n) cartYX(n)],[cartY(n) cartYY(n)],'g','LineWidth', 5)
            plot(cartX(n),cartY(n),'o')
        end
        

        n = n+1;

    end
    plot(cartX,cartY,'k','LineWidth',2)
    axis([-5 255 -130 130]);
    hold off
    
    