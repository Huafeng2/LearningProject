package com.zuo.initspringbean;

public class Customer1 {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init(){
        System.out.println("Init method after properties are set : " + message);
    }

    public void destory(){
        System.out.println("end");
    }

    @Override
    public String toString() {
        return "Customer1{" +
                "message='" + message + '\'' +
                '}';
    }
}
