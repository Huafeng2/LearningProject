package com.mingrisoft.service;

import com.mingrisoft.dbservice.DBConnection;
import com.mingrisoft.dbservice.Function;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    DBConnection DBConn = new DBConnection();
    Function Fun = new Function();
    public static int AdminID = 0;
    public static int AdminType = 0;

    public Login() {

    }

    public boolean LoginCheck(String s1, String s2) {

        try {
            ResultSet rs = null;
            Connection Conn = DBConn.getConn();
            boolean OK = false;
            OK = Fun.CheckLogin(Conn, s1, s2, rs);
            if(OK && null != rs && rs.next()){
                AdminID = rs.getInt("AdminID");
                AdminType = rs.getInt("AdminType");
            }
            return OK;

        } catch (SQLException e) {
            return false;
        }
    }
}
