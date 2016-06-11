package com.wuhn.module;

public class Role {
    private String roleid;

    private String rolepermission;

    private String identify;

    private String description;

    private Integer orderno;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolepermission() {
        return rolepermission;
    }

    public void setRolepermission(String rolepermission) {
        this.rolepermission = rolepermission == null ? null : rolepermission.trim();
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }
}