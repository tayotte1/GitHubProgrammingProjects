% Function that does everything

function [playCol,vol] = project(videoFile,depthFile,backgroundD,m)
% clc
% close all


% Initialize variables
color = zeros(10,3);
Objects = zeros(100,5,4);
Im = videoFile;
depth = depthFile;
disparity = 80;




Ihsv = rgb2hsv(Im);     %convert to hsv
Is = Ihsv(:,:,2);       %isolate the saturation (s)
Is2 =  imfilter(Is,fspecial('gaussian',[5 5], 5)); %gaussian smoothing filter
Is3 = im2bw(Is2,.4);    %Threshold the image
Is4 = imfill(Is3,'holes');
L = bwlabel(Is4,8);     %Label connected components

%Show the segmented image
subplot(2,2,2)
imshow(L);
title('Segmented Image','FontSize',15)


% Convert to grayscale and get size of image
I = rgb2gray(Im);
[sizeY,sizeX] = size(I);
line = uint16(.35*sizeY);

% Normalize depth image
D2 = im2double(depth);
min_ = min(min(D2));
max_ = max(max(D2));


% Identify Objects
count = max(max(L));    % # of objects it thinks there is
count2 = 0;             % # of objects there really is
for z = 1:count
    [t u] = find(L==z);
    if (max(t)-min(t)>10&&max(u)-min(u)>10)&&(max(t)-min(t)<70&&max(u)-min(u)<70)
        if count2==0&&min(t)>line
            if(depth(t,u)>backgroundD-disparity)
                count2 = count2+1;
                Objects(count2,1) = min(t);
                Objects(count2,2) = min(u);
                Objects(count2,3) = max(t)-min(t);
                Objects(count2,4) = max(u)-min(u);
                Objects(count2,5) = line - (Objects(z,1)+(Objects(z,4)/2));
            end
        elseif min(t)>line&&count2>0
            if (.5*min(u)+.5*max(u))- (Objects(count2,2)+.5*Objects(count2,4))>10
                if(depth(t,u)>backgroundD-disparity)
                    count2 = count2+1;
                    Objects(count2,1) = min(t);
                    Objects(count2,2) = min(u);
                    Objects(count2,3) = max(t)-min(t);
                    Objects(count2,4) = max(u)-min(u);
                    Objects(count2,5) = line - (Objects(z,1)+(Objects(z,4)/2));
                end
            elseif (.5*min(u)+.5*max(u))- (Objects(count2,2)+.5*Objects(count2,4))<10&&count2>0
                if max(t)-min(t)>Objects(count2,3)&&max(u)-min(u)>Objects(count2,4)
                    if(depth(t,u)>backgroundD-disparity)
                        Objects(count2,1) = min(t);
                        Objects(count2,2) = min(u);
                        Objects(count2,3) = max(t)-min(t);
                        Objects(count2,4) = max(u)-min(u);
                        Objects(count2,5) = line - (Objects(z,1)+(Objects(z,4)/2));
                    end
                end
            end
        end
    end
end
        


% Show depth image
subplot(2,2,1)
imshow((D2-min_)/(max_-min_))
title('Depth','FontSize',15)

% Draw line in image
for q = 1:sizeX
    Im(line,q,1) = 0;
    Im(line,q,2) = 0;
    Im(line,q,3) = 0;
    Im(line+1,q,1) = 0;
    Im(line+1,q,2) = 0;
    Im(line+1,q,3) = 0;
end


% Show the original image with objects boxed
subplot(2,2,3)
imshow(Im);
title('Original Image with Objects','FontSize',15)
hold on
for z = 1:count2
    plot(rectangle('Position',[Objects(z,2),Objects(z,1),Objects(z,4),Objects(z,3)]))

    hsv = rgb2hsv(Im);

    temp(1,1:3) = hsv(Objects(z,1)+uint16((Objects(z,3)/2)),Objects(z,2)+uint16((Objects(z,4)/2)),:);
    temp(2,1:3) = hsv(Objects(z,1)+uint16((Objects(z,3)/2))+1,Objects(z,2)+uint16((Objects(z,4)/2))+1,:);
    temp(3,1:3) = hsv(Objects(z,1)+uint16((Objects(z,3)/2))+2,Objects(z,2)+uint16((Objects(z,4)/2))+2,:);
    
    color(z,1:3,:) = mean(temp);
    color(z,1) = round(color(z,1)*100)/100;
    
    [colorVal playColor] = getObjColor(color(z,1:3));
    
    if(colorVal>0)
        color(z,1:3) = [colorVal 1 1];
        Objects(z,1,2) = playColor;
    else
        color(z,1:3) = [0 0 0];
        Objects(z,1,2) = playColor;
    end
    
    color(z,1:3) = hsv2rgb(color(z,1:3));
    
end
hold off


pos = zeros(count2+1,1);

% Show color display
subplot(2,2,4)
title('Object Colors','FontSize',15)
hold on

for z = 1:count2
    rectangle('Position',[pos(z),0,uint16(Objects(z,3)*sizeX/sum(Objects(:,3))),sizeY],'FaceColor',color(z,1:3),'LineStyle','none');
    pos(z+1) = pos(z) + uint16(Objects(z,3)*sizeX/sum(Objects(:,3)));
end
daspect([1,1,1])
xlim([0, sizeX])
ylim([0, sizeY])
axis off


playCol = 0;
c = 0;
vol = 0;

% Find if hand is playing
if m>739
    for z = 1:count2
        m = median(mean(depth(uint16(line - .9*line-5):uint16(line - .9*line)+10, uint16(Objects(z,2)-10):uint16(Objects(z,2)+20))));
        if m<770&&m>backgroundD-150
            subplot(2,2,1)
            hold on
            rectangle('Position', [uint16(Objects(z,2)-10),uint16(line - .9*line-5),30,15]);
            c = c+1;
            playCol(c) = Objects(z,1,2);
            vol(c) = (Objects(z,1)-line);
            hold off
        end
    end
else
    pause(.001);
end



