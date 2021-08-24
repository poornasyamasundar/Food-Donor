package com.example.phase1;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
    This Class contains only static functions which can be used to manipulate the donors list.
    The Database Table containing the Donor list is DonorList,
 */
public class DonorClass
{
    public static Donor getDonor( String name )     // Given a donor's name this function returns the corresponding donor object from the database.
    {
        Connection connection = ConnectionClass.getConnection();
        Donor d = new Donor();
        if( connection == null )
        {
            return d;
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from DonorList where name = '" + name + "'");
            while( rs.next() )
            {
                d.setName(rs.getString("name"));
                d.setAddress(rs.getString("address"));
                d.setEmail(rs.getString("email"));
                d.setPhno(rs.getString("phone"));
                d.setLatitude(Float.parseFloat(rs.getString("latitude")));
                d.setLongitude(Float.parseFloat(rs.getString("longitude")));
                int i = rs.getInt("donortype");
                if( i == 1 )
                {
                    d.setType(true);
                }
                else
                {
                    d.setType(false);
                }
            }
            return d;
        }
        catch ( Exception e )
        {
            Log.e("Error is", e.getMessage());
        }
        return d;
    }

    public static boolean insertDonor( Donor donor )        // This function insert a new donor into the object, note: this function shouldn't be used if the donor is already
            //existing( if exists then duplicates will be created in the table ), for updating use the next function.
    {
        Connection connection = ConnectionClass.getConnection();
        String statement = "Insert into DonorList ( name, address, email, phone, latitude, longitude, donortype ) Values ( '"+donor.getName()+"', '"+donor.getAddress()+"', '"+donor.getEmail()+"', '"+donor.getPhno()+"', '"+donor.getLatitude()+"', '"+donor.getLongitude()+"', ";
        if( donor.getType() )
        {
            statement = statement + "1 )";
        }
        else
        {
            statement = statement + "0 )";
        }
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

    public static boolean updateDonor( Donor donor )    //This function updates the details of an already existing donor in the database, if the donor doesn't exist then use the insert function.
    {
        Connection connection = ConnectionClass.getConnection();
        try
        {
            Statement st = connection.createStatement();
            String s = "update DonorList set address = '"+donor.getAddress()+"', email = '"+donor.getEmail()+"', phone = '"+donor.getPhno()+"', latitude = '"+
                    donor.getLatitude()+"', longitude = '"+donor.getLongitude()+"', donortype = "+donor.getType()+" where name = '"+donor.getName()+"'";
            st.executeUpdate(s);
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while uppdating the data", e.getMessage());
        }
        return false;
    }

    public static boolean deleteDonor( String name )    //This function is used to delete a donor. Not used in our project.
    {
        Connection connection = ConnectionClass.getConnection();
        try{
            Statement st = connection.createStatement();
            st.executeUpdate("delete from DonorList where name = '" + name + "'");
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error in deleting the object", e.getMessage());
        }
        return false;
    }

    public static ArrayList getAllDonors()  // this function returns a list of all donors in the database in the form of an arraylist.
    {
        ArrayList<Donor> array = new ArrayList<>();

        Connection connection = ConnectionClass.getConnection();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from DonorList");
            while(rs.next())
            {
                Donor d = new Donor();
                d.setName(rs.getString("name"));
                d.setAddress(rs.getString("address"));
                d.setEmail(rs.getString("email"));
                d.setPhno(rs.getString("phone"));
                d.setLatitude(Float.parseFloat(rs.getString("latitude")));
                d.setLongitude(Float.parseFloat(rs.getString("longitude")));
                int i = rs.getInt("donortype");
                if( i == 1 )
                {
                    d.setType(true);
                }
                else
                {
                    d.setType(false);
                }
                array.add(d);
            }
        }
        catch(Exception e )
        {
            Log.e("Couldn't fetch donors list", e.getMessage());
        }
        return array;
    }
}
