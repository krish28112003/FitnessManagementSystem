package Model;
import java.io.File;

import Util.DB;
import Util.Input;
import View.Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO
{
    public static boolean addDietPlan(FileInputStream diet, File file) throws FileNotFoundException
    {
        try {
            Connection conn = DB.getConnection();
            String query = "Insert into DIETFILE(FIL_NO, FILE_NAME, FILE_DATA) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            Admin.S_no();
            ps.setInt(1, Input.getInt());
            Admin.Calorielog();
            ps.setString(2, Input.getString());
            ps.setBinaryStream(3,diet,(int) file.length());
            int  rs = ps.executeUpdate();
            if(rs!=1)
            {
                return true;
            }
               return false;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static void addFitnessPlan() throws FileNotFoundException
    {
        String filedirectory = Admin.filedirectory();
        File file=new File(filedirectory);
        FileInputStream fis=new FileInputStream(file);

        try {
            Connection conn = DB.getConnection();
            String query = "Insert into FITNESSFILE(FIL_NO, FILE_NAME, FILE_DATA) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            Admin.S_no();
            ps.setInt(1, Input.getInt());
            Admin.Fitnesslog();
            ps.setString(2, Input.getString());
            ps.setBinaryStream(3,fis,(int)file.length());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
