package com.example.sathv.jbossoutreachrepositories;

/**
 * Created by sathv on 11/24/2018.
 */

public class ContributeModel {
    String username, realname, imageurl, contributions;

    public ContributeModel(String username, String realname, String imageurl, String contributions) {
        this.username = username;
        this.realname = realname;
        this.imageurl = imageurl;
        this.contributions = contributions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getContributions() {
        return contributions;
    }

    public void setContributions(String contributions) {
        this.contributions = contributions;
    }
}
