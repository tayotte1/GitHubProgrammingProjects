function [color depth] = videoread()

clc

% Initialize
color = cell(476);
depth = cell(476);

% Read Depth Images
k = 1;
for s = 17:41
    for ms = 0:18
        file = ['depth_340_11_34_' num2str(s) '_' num2str(ms) '.png'];
        depth{k} = imcrop(imread(file),[5 33 285 195]);
        k = k+1;
    end
end


% Read Color Images
k = 1;
for s = 17:41
    for ms = 0:18
        file = ['color_340_11_34_' num2str(s) '_' num2str(ms) '.jpg'];
        color{k} = imcrop(imread(file),[1 33 285 195]);
        temp = color{k}(:,:,1);
        color{k}(:,:,1) = color{k}(:,:,3);
        color{k}(:,:,3) = temp;
        k = k+1;
    end
end
