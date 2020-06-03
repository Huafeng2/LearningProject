package com.zuo.util;

public class Chinese extends Person {
    private String province;

    public Chinese(String name, String age, String address, String province) {
        super(name, age, address);
        this.province = province;
    }

    public Chinese(String province) {
        this.province = province;
    }

    public Chinese(){

    }

    public String getCountry() {
        return province;
    }

    public void setCountry(String province) {
        this.province = province;
    }
}
