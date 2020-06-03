package com.mrkj.ygl.entity.sys;

public class Dictionary {
	
    private Integer dictId;

    private String dictGroup;

    private String dictKey;

    private String dictValue;

    private String dictParent;

    private Integer dictOrder;

    private String dictIsleaf;
    
    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictGroup() {
        return dictGroup;
    }

    public void setDictGroup(String dictGroup) {
        this.dictGroup = dictGroup == null ? null : dictGroup.trim();
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictParent() {
        return dictParent;
    }

    public void setDictParent(String dictParent) {
        this.dictParent = dictParent == null ? null : dictParent.trim();
    }

    public Integer getDictOrder() {
        return dictOrder;
    }

    public void setDictOrder(Integer dictOrder) {
        this.dictOrder = dictOrder;
    }

	public String getDictIsleaf() {
		return dictIsleaf;
	}

	public void setDictIsleaf(String dictIsleaf) {
		this.dictIsleaf = dictIsleaf;
	}

}