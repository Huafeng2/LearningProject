package com.mingrisoft;

import com.mingrisoft.dbservice.DBConnection;
import com.mingrisoft.service.News;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBConnectionTest extends TestCase {

    @Test
    public void testDBpro() {
        DBConnection dbConnection = new DBConnection();
        System.out.println(dbConnection.getPara("DBType"));
    }

    @Test
    public void testDBConn() {
        DBConnection dbConnection = new DBConnection();
        Assert.assertNotNull(dbConnection.getConn());
    }

    @Test
    public void testNewsList() {
        News news = new News();
        news.ListNewsFront("/myWeb/front/newsFrontList.jsp?", null);
    }

}