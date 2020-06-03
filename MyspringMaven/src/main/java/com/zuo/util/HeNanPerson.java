package com.zuo.util;

public class HeNanPerson extends Chinese implements Comparable<HeNanPerson> {
    private String state;

    public HeNanPerson(String name, String age, String address, String country, String state) {
        super(name, age, address, country);
        this.state = state;
    }

    public HeNanPerson(String state) {
        this.state = state;
    }

    public HeNanPerson() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int compareTo(HeNanPerson o) {
        return this.state.compareTo(o.getState());
    }

    @Override
    public String toString() {
        return "HeNanPerson{" +
                "province='" + state + '\'' +
                '}';
    }
}
