package com.mrkj.ygl.entity.forum;

import java.util.Date;

public class forumInfo {
    private Integer infoId;

    private Integer infoReply;

    private Integer infoSee;

    private String infoLastuser;

    private Date infoLastime;

    private String mainId;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getInfoReply() {
        return infoReply;
    }

    public void setInfoReply(Integer infoReply) {
        this.infoReply = infoReply;
    }

    public Integer getInfoSee() {
        return infoSee;
    }

    public void setInfoSee(Integer infoSee) {
        this.infoSee = infoSee;
    }

    public String getInfoLastuser() {
        return infoLastuser;
    }

    public void setInfoLastuser(String infoLastuser) {
        this.infoLastuser = infoLastuser == null ? null : infoLastuser.trim();
    }

    public Date getInfoLastime() {
        return infoLastime;
    }

    public void setInfoLastime(Date infoLastime) {
        this.infoLastime = infoLastime;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId == null ? null : mainId.trim();
    }
}