package Model;

import Resources.LoginDTO;
import Util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO
{
    public static boolean isPasswordCorrect(LoginDTO loginDTO) {
        try
        {
            Connection conn= DB.getConnection();
            String query="SELECT User_MAILID,User_PASSWORD,User_ID FROM USERS WHERE User_MAILID=? AND User_ID=? AND User_PASSWORD=? ";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,loginDTO.getMailID());
            ps.setString(2,loginDTO.getUserID());
            ps.setString(3,loginDTO.getPassword());
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public static int isNewUser(LoginDTO loginDTO) {


        try {
           Connection conn = DB.getConnection();
            String query = "SELECT ACTIVE_STATUS FROM USERS WHERE User_MAILID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, loginDTO.getMailID());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return rs.getInt("ACTIVE_STATUS");
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public static boolean isAdminPasswordCorrect(LoginDTO loginDTO) {
        try
        {
            Connection conn= DB.getConnection();
            String query="SELECT Admin_mailID,Admin_password FROM  ADMINS WHERE Admin_mailID=? AND Admin_password=?";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,loginDTO.getAdminMailID());
            ps.setString(2,loginDTO.getAdminPassword());
            ResultSet rs= ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
