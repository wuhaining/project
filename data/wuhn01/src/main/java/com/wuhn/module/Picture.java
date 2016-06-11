package com.wuhn.module;

import java.util.Date;

public class Picture {
    private String pictureid;

    private String userid;

    private String directory;

    private String imagename;

    private Integer identity;

    private String describecontent;

    private Date ordernumber;

    private String title;

    public String getPictureid() {
        return pictureid;
    }

    public void setPictureid(String pictureid) {
        this.pictureid = pictureid == null ? null : pictureid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory == null ? null : directory.trim();
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename == null ? null : imagename.trim();
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getDescribecontent() {
        return describecontent;
    }

    public void setDescribecontent(String describecontent) {
        this.describecontent = describecontent == null ? null : describecontent.trim();
    }

    public Date getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Date ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}