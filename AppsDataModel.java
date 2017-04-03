package com.vrplayerapp.in;

/**
 * Created by Admin on 20-03-2017.
 */

public class AppsDataModel {
    private String headerTxt;
    private String footerTxt;
    private String imageUrl;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFooterTxt() {
        return footerTxt;
    }

    public void setFooterTxt(String footerTxt) {
        this.footerTxt = footerTxt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHeaderTxt() {

        return headerTxt;
    }

    public void setHeaderTxt(String headerTxt) {
        this.headerTxt = headerTxt;
    }

    public AppsDataModel(String headerTxt, String footerTxt, String imageUrl, Integer index) {
        this.headerTxt = headerTxt;
        this.footerTxt = footerTxt;
        this.imageUrl = imageUrl;
        this.id = index;
    }
}
