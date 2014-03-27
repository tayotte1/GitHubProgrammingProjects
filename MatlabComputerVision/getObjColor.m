function [colorVal playColor] = getObjColor(readColor)

% Choose which color the object is based on ranges
    if readColor(1,1)>=0 && readColor(1,1)<.05||readColor(1,1)>.8
        playColor = 1;
        colorVal = 0.025;
    elseif readColor(1,1)>=.05 && readColor(1,1)<.1
        playColor = 2;
        colorVal = .1;
    elseif readColor(1,1)>=.1 && readColor(1,1)<.15
        playColor = 3;
        colorVal = .125;
    elseif readColor(1,1)>=.15 && readColor(1,1)<.2
        playColor = 4;
        colorVal = .35;
    elseif readColor(1,1)>=.2 && readColor(1,1)<.4
        playColor = 5;
        colorVal = .45;
    elseif readColor(1,1)>=.4 && readColor(1,1)<.5
        playColor = 6;
        colorVal = .55;
    elseif readColor(1,1)>=.5 && readColor(1,1)<.62
        playColor = 7;
        colorVal = .65;
    elseif readColor(1,1)>=.62 && readColor(1,1)<.8
        playColor = 8;
        colorVal = .75;
    elseif readColor(1,3)<.12
        playColor = 0;
        colorVal = 0;
    end
    