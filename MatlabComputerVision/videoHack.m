% Program to start project
clc
close all


% Load images and sounds

[color depth] = videoread();

sounds = cell(1,8);

[s1,Fs1] = wavread('250HZ.wav');
s1 = .7*s1;
s1 = [s1 s1];

p1 = audioplayer(s1,.5*Fs1);
sounds{1} = p1;

p2 = audioplayer(s1,.6*Fs1);
sounds{2} = p2;

p3 = audioplayer(s1,.7*Fs1);
sounds{3} = p3;

p4 = audioplayer(s1,.8*Fs1);
sounds{4} = p4;

p5 = audioplayer(s1,.9*Fs1);
sounds{5} = p5;

p6 = audioplayer(s1,1*Fs1);
sounds{6} = p6;

p7 = audioplayer(s1,1.1*Fs1);
sounds{7} = p7;

p8 = audioplayer(s1,1.2*Fs1);
sounds{8} = p8;

ls = length(sounds);

figure;
backgroundD = median(mean(depth{1}));


% Run program as if reading video:

for l = 300:475

    % Get background depth
    m = mean(mean(depth{l}(70:120,:)));
    
    % Get current frame and run it through 'project'
    i = color{l};
    j = depth{l};
    [playCol vol] = project(i,j,backgroundD,m);
    
    
    % Stop sounds that shouldn't be playing
    for y = 1:ls
        if ismember(y,playCol)==0;
            stop(sounds{y})
            sounds{y} = setVolume(1,s1,((.5+.1*(y-1))*Fs1));
        end
    end
    
    % Play sounds that should be playing
    if playCol>0
        for p = 1:length(playCol)
            if(sounds{playCol(p)}.isplaying==0)
                temps1 = s1;
                sounds{playCol(p)} = setVolume(vol(p)*4,s1,((.5+.1*(playCol(p)-1))*Fs1));
                play(sounds{playCol(p)}); 
                pause(.001);
            end
        end
    end
   pause(15/60) 
end
