function [AP] = setVolume(vol,s,Fs)

    AP = audioplayer(uint8(vol*s),Fs);
    
end