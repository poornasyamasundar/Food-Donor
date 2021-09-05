package com.example.phase1;

import android.util.Log;

import androidx.annotation.NonNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CurrentDonorsClass
{
    public static CurrentDonor getCurrentDonor( String name )
    {
        Connection connection = ConnectionClass.getConnection();
        CurrentDonor d = new CurrentDonor();
        if( connection == null )
        {
            return d;
        }
        try
        {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from CurrentDonorList where name = '" + name + "'");
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
            Log.e("Error in getting currentDonor = ", e.getMessage());
        }
        return d;
    }

    public static boolean insertCurrentDonor(@NonNull CurrentDonor currentDonor )
    {
        Connection connection = ConnectionClass.getConnection();
        String statement = "Insert into CurrentDonorList ( name, address, email, phone, quantity ) Values ( '"
                +currentDonor.getName()+"', '"+currentDonor.getAddress()+"', '"+currentDonor.getEmail()+"', '"+currentDonor.getPhno()+"',"+currentDonor.getQuantity()+" )";
        Log.d("Query", statement);
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
            return true;
        }
        catch (Exception e )
        {
            Log.e("Error in inserting CurrentDonor = ", e.getMessage());
        }
        return false;
    }

    public static boolean updateCurrentDonor( CurrentDonor currentDonor )
    {
        Connection connection = ConnectionClass.getConnection();
        try
        {
            Statement st = connection.createStatement();
            String s = "update CurrentDonorList set address = '"+currentDonor.getAddress()+"', email = '"+currentDonor.getEmail()+"', phone = '"+currentDonor.getPhno()+"', quantity = "+currentDonor.getQuantity()+" where name = '"+currentDonor.getName()+"'";
            st.executeUpdate(s);
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while updating currentDonor = ", e.getMessage());
        }
        return false;
    }

    public static boolean deleteCurrentDonor( String name )
    {
        Connection connection = ConnectionClass.getConnection();
        try
        {
            Statement st = connection.createStatement();
            st.executeUpdate("delete from CurrentDonorList where name = '" + name + "'");
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error in deleting the currentDonor = ", e.getMessage());
        }
        return false;
    }

    @NonNull
    public static ArrayList getAllCurrentDonors()
    {
        ArrayList<CurrentDonor> array = new ArrayList<>();

        Connection connection = ConnectionClass.getConnection();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from CurrentDonorList");
            while(rs.next())
            {
                CurrentDonor d = new CurrentDonor();
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
            Log.e("Couldn't fetch CurrentDonors list = ", e.getMessage());
        }
        return array;
    }
}
