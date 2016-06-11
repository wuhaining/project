package com.wuhn.module;

public class Dict {
    private String dictentryid;

    private String dicttypeid;

    private Integer orderno;

    private String dictid;

    private String dictname;

    private String dictshort;

    private String parentdictid;

    private Byte isenable;

    public String getDictentryid() {
        return dictentryid;
    }

    public void setDictentryid(String dictentryid) {
        this.dictentryid = dictentryid == null ? null : dictentryid.trim();
    }

    public String getDicttypeid() {
        return dicttypeid;
    }

    public void setDicttypeid(String dicttypeid) {
        this.dicttypeid = dicttypeid == null ? null : dicttypeid.trim();
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getDictid() {
        return dictid;
    }

    public void setDictid(String dictid) {
        this.dictid = dictid == null ? null : dictid.trim();
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname == null ? null : dictname.trim();
    }

    public String getDictshort() {
        return dictshort;
    }

    public void setDictshort(String dictshort) {
        this.dictshort = dictshort == null ? null : dictshort.trim();
    }

    public String getParentdictid() {
        return parentdictid;
    }

    public void setParentdictid(String parentdictid) {
        this.parentdictid = parentdictid == null ? null : parentdictid.trim();
    }

    public Byte getIsenable() {
        return isenable;
    }

    public void setIsenable(Byte isenable) {
        this.isenable = isenable;
    }
}