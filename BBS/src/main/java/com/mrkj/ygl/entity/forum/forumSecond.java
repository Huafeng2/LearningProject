package com.mrkj.ygl.entity.forum;

import java.util.Date;

public class forumSecond {
    private String secId;

    private String mainId;

    private Integer secSequence;

    private String secCreatuser;

    private Date secCreatime;

    private String secNickname;

    private Integer secResequence;

    private String secDelete;

    private String secContent;

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId == null ? null : secId.trim();
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId == null ? null : mainId.trim();
    }

    public Integer getSecSequence() {
        return secSequence;
    }

    public void setSecSequence(Integer secSequence) {
        this.secSequence = secSequence;
    }

    public String getSecCreatuser() {
        return secCreatuser;
    }

    public void setSecCreatuser(String secCreatuser) {
        this.secCreatuser = secCreatuser == null ? null : secCreatuser.trim();
    }

    public Date getSecCreatime() {
        return secCreatime;
    }

    public void setSecCreatime(Date secCreatime) {
        this.secCreatime = secCreatime;
    }

    public String getSecNickname() {
        return secNickname;
    }

    public void setSecNickname(String secNickname) {
        this.secNickname = secNickname == null ? null : secNickname.trim();
    }

    public Integer getSecResequence() {
        return secResequence;
    }

    public void setSecResequence(Integer secResequence) {
        this.secResequence = secResequence;
    }

    public String getSecDelete() {
        return secDelete;
    }

    public void setSecDelete(String secDelete) {
        this.secDelete = secDelete == null ? null : secDelete.trim();
    }

    public String getSecContent() {
        return secContent;
    }

    public void setSecContent(String secContent) {
        this.secContent = secContent == null ? null : secContent.trim();
    }
}