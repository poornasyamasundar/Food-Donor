
/*
    This Class contains only static methods which can be used to manipulate the users database.
    
    It provides methods like:
    getUser - this returns an object of the type User that has all the details by grabbing the information from the Users database using the name which
                        is unique.
    insertUser - this takes in an object of the type User and inserts this data into the Users database.
                           
    
    updateUser - this updates the details of the  user if his/her details are already there in the Users database and return true.
                         If this user is not there in the Users database, then this method returns false.
                         
    checkUser - this method checks if a user is present in the Users database and returns true if present, else returns false.
                         
    getCount - returns the total number of users registered in our app
 
 */

package com.example.phase1;

import android.content.SharedPreferences;
import android.text.SpanWatcher;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserClass
{
    public static User getUser( String username )
    {
        Connection connection = ConnectionClass.getConnection();
        User user = null;
        if( connection == null )
        {
            return user;
        }
        try
        {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Users where username = '" + username + "'");
            while( rs.next() )
            {
                user = new User();
                user.setName(rs.getString("name"));
                user.setPhno(rs.getString("phone"));
                user.setDoorNO(rs.getString("doorno"));
                user.setArea(rs.getString("area"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getInt("gender"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("pass"));
            }
            return user;
        }
        catch ( Exception e )
        {
            Log.e("Error is"+username, e.getMessage());
        }
        return user;
    }

    public static boolean checkUser( String username )
    {
        Connection connection = ConnectionClass.getConnection();
        if( connection == null )
        {
            return false;
        }
        try
        {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Users where username = '" + username + "'");
            if( rs.next() )
            {
                connection.close();
                return false;
            }
            return true;
        }
        catch ( Exception e )
        {
            Log.e("Error is", e.getMessage());
        }
        return false;
    }

    public static boolean insertUser( User user )
    {
        Connection connection = ConnectionClass.getConnection();
        String statement = "Insert into Users ( name, phone, doorno, area, email, gender, username, pass ) Values ( '"
                +user.getName()+"', '"+user.getPhno()+"', '"+user.getDoorNO()+"', '"+user.getArea()+"', '"+user.getEmail()+"', "+user.getGender()+", '"+user.getUserName()+"', '"+user.getPassword()+"')";
        Log.d("Query", statement);
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
            return true;
        }
        catch (Exception e )
        {
            Log.e("Error in inserting the object", e.getMessage());
        }
        return false;
    }

    public static boolean updateUser( User user )
    {
        Connection connection = ConnectionClass.getConnection();
        String statement = "Update Users set phone = '"+user.getPhno()+"', doorno = '"+user.getDoorNO()+"', area = '"+user.getArea()+"', email = '"+user.getEmail()+"', pass = '"+
                user.getPassword()+"' where username = '"+user.getUserName()+"'";
        try
        {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while uppdating the data", e.getMessage());
        }
        return false;
    }

    public static int getCount()
    {
        Connection connection = ConnectionClass.getConnection();
        try{
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Users");
            r.next();
            int count = r.getInt("rowcount");
            r.close();
            return count;
        }
        catch(Exception e )
        {
            Log.e("Couldn't fetch user count", e.getMessage());
        }
        return -1;
    }
}
