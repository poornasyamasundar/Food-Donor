package com.example.phase1;

import android.os.Build;
import android.util.Log;

        import androidx.annotation.RequiresApi;

        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.ArrayList;

        import java.time.LocalDate;

public class FeedBackClass {


    public static ArrayList getAllComments()
    {
        Connection connection = ConnectionClass.getConnection();
        ArrayList<FeedBack> comments = new ArrayList<>();

        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from feedbacks");
            while(rs.next())
            {
                //if(rs.getInt("id") == id)
                //{
                FeedBack comment = new FeedBack();
                comment.setName(rs.getString("name"));
                comment.setId(rs.getInt("id"));
                comment.setDate(rs.getInt("date"));
                comment.setMonth(rs.getInt("month"));
                comment.setYear(rs.getInt("year"));
                comment.setComment(rs.getString("comment"));

                comments.add(comment);
                // }
            }

        }
        catch (Exception e) {
            Log.e("Error while fetching the data", e.getMessage());
        }

        return comments;
    }


    public static ArrayList getComments(String name)
    {
        Connection connection = ConnectionClass.getConnection();
        ArrayList<FeedBack> comments = new ArrayList<>();

        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from feedbacks where name = '" + name + "'");
            while(rs.next())
            {
                //if(rs.getInt("id") == id)
                //{
                FeedBack comment = new FeedBack();
                comment.setName(rs.getString("name"));
                comment.setId(rs.getInt("id"));
                comment.setDate(rs.getInt("date"));
                comment.setMonth(rs.getInt("month"));
                comment.setYear(rs.getInt("year"));
                comment.setComment(rs.getString("comment"));

                comments.add(comment);
                // }
            }

        }
        catch (Exception e) {
            Log.e("Error while fetching the data", e.getMessage());
        }

        return comments;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean addComment(String name, String comment)
    {
        int date, month, year;

        String today = LocalDate.now().toString();

        date = Integer.parseInt(today.substring(8));
        month = Integer.parseInt(today.substring(5,7));
        year = Integer.parseInt(today.substring(0,4));

        Connection connection = ConnectionClass.getConnection();
        String statement = "Insert into feedbacks ( name, date, month, year, comment ) Values ( '"+name+"', "+date+", "+month+", "+year+", '"+comment+"' )";
        Log.d("Query", statement);

        try {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
            return true;
        }
        catch (Exception e )
        {
            Log.e("Error while saving the data", e.getMessage());
        }
        return false;
    }

    public static boolean deleteComment(FeedBack feedback)
    {
        String name = feedback.getName();
        int id = feedback.getId();

        Connection connection = ConnectionClass.getConnection();
        try{
            Statement st = connection.createStatement();
            st.executeUpdate("delete from feedbacks where name = '" + name + "'" + " and id = " + id);
            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while deleting the comment", e.getMessage());
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean modifyComment(FeedBack feedback)
    {
        String name = feedback.getName();
        int id = feedback.getId();
        String comment = feedback.getComment();

        Connection connection = ConnectionClass.getConnection();

        int date, month, year;

        String today = LocalDate.now().toString();

        date = Integer.parseInt(today.substring(8));
        month = Integer.parseInt(today.substring(5,7));
        year = Integer.parseInt(today.substring(0,4));

        try{
            Statement st = connection.createStatement();

            String s = "update feedbacks set comment = '"+comment+"', date = "+date+", month = "+month+", year = "+
                    year+" where name = '"+name+"' and id = " + id;
            st.executeUpdate(s);

            return true;
        }
        catch(Exception e )
        {
            Log.e("Error while updating the comment", e.getMessage());
        }
        return false;
    }

}