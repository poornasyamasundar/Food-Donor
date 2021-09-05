
/*

This class provides a function that establishes a connection with the database using SQL queries

 */


package com.example.phase1;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
/*
This Class has one static function which can be used to get the server connection, I request everyone to user this function so that all data gets stored in only one databasee.
 */
public class ConnectionClass
{
    public static Connection getConnection()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://mysql-46517-0.cloudclusters.net:19832/donor?characterEncoding=latin1&useConfigs=maxPerformance","admin","58YydlHl");
            return con;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
