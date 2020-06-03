package com.mrkj.ygl.entity.forum;

import java.util.Date;

public class forumMain {
    private String mainId;

    private String mainTitle;

    private String mainFlag;

    private String mainType;

    private Date mainCreatime;

    private String mainCreatuser;

    private Integer mainRecommend;

    private String mainDelete;

    private String mainNickname;

    private Integer mainZan;

    private String mainContent;

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId == null ? null : mainId.trim();
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle == null ? null : mainTitle.trim();
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag == null ? null : mainFlag.trim();
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType == null ? null : mainType.trim();
    }

    public Date getMainCreatime() {
        return mainCreatime;
    }

    public void setMainCreatime(Date mainCreatime) {
        this.mainCreatime = mainCreatime;
    }

    public String getMainCreatuser() {
        return mainCreatuser;
    }

    public void setMainCreatuser(String mainCreatuser) {
        this.mainCreatuser = mainCreatuser == null ? null : mainCreatuser.trim();
    }

    public Integer getMainRecommend() {
        return mainRecommend;
    }

    public void setMainRecommend(Integer mainRecommend) {
        this.mainRecommend = mainRecommend;
    }

    public String getMainDelete() {
        return mainDelete;
    }

    public void setMainDelete(String mainDelete) {
        this.mainDelete = mainDelete == null ? null : mainDelete.trim();
    }

    public String getMainNickname() {
        return mainNickname;
    }

    public void setMainNickname(String mainNickname) {
        this.mainNickname = mainNickname == null ? null : mainNickname.trim();
    }

    public Integer getMainZan() {
        return mainZan;
    }

    public void setMainZan(Integer mainZan) {
        this.mainZan = mainZan;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent == null ? null : mainContent.trim();
    }
}