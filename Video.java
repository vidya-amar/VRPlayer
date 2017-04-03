package com.vrplayerapp.in;

/**
 * Created by Admin on 28-02-2017.
 */

public class Video {
    private String vidName;
    private  int vidImage;

    public Video(String vidName, int vidImage) {
        this.vidName = vidName;
        this.vidImage = vidImage;
    }

    public String getVidName() {
        return vidName;
    }

    public void setVidName(String vidName) {
        this.vidName = vidName;
    }

    public int getVidImage() {
        return vidImage;
    }

    public void setVidImage(int vidImage) {
        this.vidImage = vidImage;
    }
}
