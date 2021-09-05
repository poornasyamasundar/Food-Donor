
/*
    This Class contains only static methods which can be used to manipulate the donors database.
    
    It provides methods like:
    getDonar - this returns an object of the type Donar that has all the required details by grabbing the information from the Donars database using the name which
                        is unique.
    insertDonar - this takes in an object of the type Donar and inserts this data into the DOnars database.
                           
    
    updateDonor - this updates the details of the  donar if his details are already there in the Donars database and return true.
                         If this donar is not there in the Donars database, then this method returns false.
                         
    deleteDonor - this method deletes a donar and his details from the Donars database and returns true.
                            If the donar is not present in the Donars database, it returns false.
             
     getAllDonors - this method returns a list of all the donars present in the Donars database and their respective details, each in the form of Donar object.
                         
    getCount - returns the total number of donars registered in our app
 
 */

package com.example.phase1;

import android.util.Log;

import androidx.annotation.NonNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DonorClass
{
    public static Donor getDonor( String name )     // Given a donor's name this function returns the corresponding donor object from the database.
    {
        Connection connection = ConnectionClass.getConnection();
        Donor d = new Donor();
        if( connection == null )
        {
            return null;
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
                int i = rs.getInt("donortype");
                if( i == 1 )
                {
                    d.setType(true);
                }
                else
                {
                    d.setType(false);
                }
                d.setNoOfDonations(rs.getInt("noofdonations"));
                return d;
            }
            return null;
        }
        catch ( Exception e )
        {
            Log.e("Error in getting donor", e.getMessage());
        }
        return null;
    }

    public static boolean insertDonor(@NonNull Donor donor )        // This function insert a new donor into the object, note: this function shouldn't be used if the donor is already
            //existing( if exists then duplicates will be created in the table ), for updating use the next function.
    {
        Connection connection = ConnectionClass.getConnection();
        String statement = "Insert into DonorList ( name, address, email, phone, donortype, noofdonations ) Values ( '"
                +donor.getName()+"', '"+donor.getAddress()+"', '"+donor.getEmail()+"', '"+donor.getPhno()+"', ";
        if( donor.getType() )
        {
            statement = statement + "1, ";
        }
        else
        {
            statement = statement + "0, ";
        }
        statement = statement + donor.getNoOfDonations()+ " )";
        Log.d("Query", statement);
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
            return true;
        }
        catch (Exception e )
        {
            Log.e("Error in inserting donor", e.getMessage());
        }
        return false;
    }

    public static boolean updateDonor( Donor donor )    //This function updates the details of an already existing donor in the database, if the donor doesn't exist then use the insert function.
    {
        Connection connection = ConnectionClass.getConnection();
        try
        {
            Statement st = connection.createStatement();
            String s = "update DonorList set address = '"+donor.getAddress()+"', email = '"+donor.getEmail()+"', phone = '"+donor.getPhno()+"', donortype = "+donor.getType()+", noofdonations = "+donor.getNoOfDonations()+ " where name = '"+donor.getName()+"'";
            st.executeUpdate(s);
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while updating the donor", e.getMessage());
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
            Log.e("Error in deleting the donor", e.getMessage());
        }
        return false;
    }

    @NonNull
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
                int i = rs.getInt("donortype");
                if( i == 1 )
                {
                    d.setType(true);
                }
                else
                {
                    d.setType(false);
                }
                d.setNoOfDonations(rs.getInt("noofdonations"));
                array.add(d);
            }
        }
        catch(Exception e )
        {
            Log.e("Couldn't fetch donors list", e.getMessage());
        }
        return array;
    }

    public static int getCount()
    {
        Connection connection = ConnectionClass.getConnection();
        try{
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM DonorList");
            r.next();
            int count = r.getInt("rowcount");
            r.close();
            return count;
        }
        catch(Exception e )
        {
            Log.e("Couldn't fetch donor count", e.getMessage());
        }
        return -1;
    }
}
