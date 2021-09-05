package com.example.phase1;

import android.util.Log;

import androidx.annotation.NonNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CurrentReceiverClass
{
    public static CurrentReceiver getCurrentReceiver( String name )
    {
        Connection connection = ConnectionClass.getConnection();
        CurrentReceiver d = new CurrentReceiver();
        if( connection == null )
        {
            return d;
        }
        try
        {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from CurrentReceiverList where name = '" + name + "'");
            while( rs.next() )
            {
                d.setName(rs.getString("name"));
                d.setAddress(rs.getString("address"));
                d.setEmail(rs.getString("email"));
                d.setPhno(rs.getString("phone"));
                d.setQuantity(rs.getInt("quantity"));
            }
            return d;
        }
        catch ( Exception e )
        {
            Log.e("Error in getting currentReceiver = ", e.getMessage());
        }
        return d;
    }

    public static boolean insertCurrentReceiver(@NonNull CurrentReceiver currentReceiver )
    {
        Connection connection = ConnectionClass.getConnection();
        String statement = "Insert into CurrentReceiverList ( name, address, email, phone, quantity ) Values ( '"
                +currentReceiver.getName()+"', '"+currentReceiver.getAddress()+"', '"+currentReceiver.getEmail()+"', '"+currentReceiver.getPhno()+"',"+currentReceiver.getQuantity()+" )";
        Log.d("Query", statement);
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
            return true;
        }
        catch (Exception e )
        {
            Log.e("Error in inserting CurrentReceiver = ", e.getMessage());
        }
        return false;
    }

    public static boolean updateCurrentReceiver( CurrentReceiver currentReceiver )
    {
        Connection connection = ConnectionClass.getConnection();
        try
        {
            Statement st = connection.createStatement();
            String s = "update CurrentReceiverList set address = '"+currentReceiver.getAddress()+"', email = '"+currentReceiver.getEmail()+"', phone = '"+currentReceiver.getPhno()+"', quantity = "+currentReceiver.getQuantity()+" where name = '"+currentReceiver.getName()+"'";
            st.executeUpdate(s);
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while updating currentReceiver = ", e.getMessage());
        }
        return false;
    }

    public static boolean deleteCurrentReceiver( String name )
    {
        Connection connection = ConnectionClass.getConnection();
        try
        {
            Statement st = connection.createStatement();
            st.executeUpdate("delete from CurrentReceiverList where name = '" + name + "'");
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error in deleting the currentReceiver = ", e.getMessage());
        }
        return false;
    }

    @NonNull
    public static ArrayList getAllCurrentReceivers()
    {
        ArrayList<CurrentReceiver> array = new ArrayList<>();

        Connection connection = ConnectionClass.getConnection();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from CurrentReceiverList");
            while(rs.next())
            {
                CurrentReceiver d = new CurrentReceiver();
                d.setName(rs.getString("name"));
                d.setAddress(rs.getString("address"));
                d.setEmail(rs.getString("email"));
                d.setPhno(rs.getString("phone"));
                d.setQuantity(rs.getInt("quantity"));
                array.add(d);
            }
        }
        catch(Exception e )
        {
            Log.e("Couldn't fetch CurrentReceivers list = ", e.getMessage());
        }
        return array;
    }
}
