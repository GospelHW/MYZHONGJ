package com.lg.logindemo.model;

/**
 * Created by sunyi on 2017/8/18.
 */

public class User {
    private int id;
    private String uName;
    private String uPwd;
    private String uRePwd;
    private String uAge;
    private String uSex;
    private String uPhone;
    private String uAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuRePwd() {
        return uRePwd;
    }

    public void setuRePwd(String uRePwd) {
        this.uRePwd = uRePwd;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }
}
