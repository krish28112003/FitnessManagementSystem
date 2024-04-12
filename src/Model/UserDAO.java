package Model;
import Resources.LoginDTO;
import Resources.UserDTO;
import Util.DB;

import java.sql.*;


public class UserDAO
{
    public static void saveUser(UserDTO userDTO) {
        try {
            Connection conn = DB.getConnection();
            String query = "Insert into USERS(User_ID,User_NAME,User_DOB,User_GENDER,User_CONTACTNUMBER,User_MAILID,User_PASSWORD,ACTIVE_STATUS) values(?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userDTO.getUserID());
            ps.setString(2, userDTO.getUserName());
            ps.setString(3, userDTO.getDoB());
            ps.setString(4, userDTO.getGender());
            ps.setString(5, userDTO.getContact_number());
            ps.setString(6, userDTO.getUserMailID());
            ps.setString(7, userDTO.getUserPassword());
            ps.setInt(8, userDTO.activeStatus);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void saveGoal(UserDTO userDTO,LoginDTO loginDTO) {
        try {
            Connection conn = DB.getConnection();
            String query = "Insert into USER_FITNESS_GOAL(User_ID,GOAL_TYPE,TARGET_VALUE,TARGET_DATE,CURRENT_STATUS) values(?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, loginDTO.getUserID());
            ps.setString(2, userDTO.getGoal_type());
            ps.setFloat(3, userDTO.getTarget_value());
            ps.setString(4, userDTO.getTarget_date());
            ps.setFloat(5, userDTO.getCurrent_status());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public static boolean saveUserFitnessDetail(LoginDTO loginDTO, UserDTO userDTO) {

        try
        {
            Connection conn = DB.getConnection();
            String query = "INSERT INTO USER_FITNESS_DETAILS(User_ID, User_HEIGHT, User_WEIGHT, BODYFAT_PERCENTAGE, ACTIVE_LEVEL) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1, loginDTO.getUserID());
            ps.setFloat(2, userDTO.getHeight());
            ps.setFloat(3, userDTO.getWeight());
            ps.setFloat(4, userDTO.getBody_fat_percentage());
            ps.setString(5, userDTO.getActivity_level());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage()); // Handle the exception appropriately, e.g., log it
        }
        return false;
    }

    public static boolean isUserAlreadyExists(UserDTO userDTO) {
        //database check
        try {
            Connection conn = DB.getConnection();
            String query = "SELECT User_MAILID FROM USERS WHERE User_MAILID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userDTO.getUserMailID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static UserDTO retriveFitnessData(LoginDTO loginDTO, UserDTO userDTO) {
        try {
            Connection conn = DB.getConnection();
            String query = "SELECT GOAL_TYPE,CURRENT_STATUS FROM USER_FITNESS_GOAL WHERE USER_ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, loginDTO.getUserID());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                String goal_type = rs.getString("GOAL_TYPE");
                float weight = rs.getFloat("CURRENT_STATUS");
                userDTO.setGoal(goal_type);
                userDTO.setBody_Weight(weight);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return userDTO;
    }
    public static void changeFirstUsertoExisting(LoginDTO loginDTO) {
        try{
            Connection conn=DB.getConnection();
            String query="UPDATE USERS SET ACTIVE_STATUS= 0 WHERE User_ID=?";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,loginDTO.getUserID());
            int rs=ps.executeUpdate();
            if(rs!=1)
                System.out.println("Data not inserted");
            else
                System.out.println("not inserted");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void UpdateWeight(float weight,LoginDTO loginDTO) {
        try {
            Connection conn=DB.getConnection();
            String query1="UPDATE USER_FITNESS_DETAILS SET User_WEIGHT=? WHERE User_ID=?";
            PreparedStatement ps1=conn.prepareStatement(query1);
            ps1.setFloat(1,weight);
            ps1.setString(2,loginDTO.getUserID());
            ps1.executeUpdate();
            PreparedStatement ps2=conn.prepareStatement(query1);
            ps2.setFloat(1,weight);
            ps2.setString(2,loginDTO.getUserID());
            ps2.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void UpdateBodyFatPercentage(float bodyfat,LoginDTO loginDTO) {
        try {
            Connection conn=DB.getConnection();
            String query1="UPDATE USER_FITNESS_DETAILS SET BODYFAT_PERCENTAGE=? WHERE User_ID=?";
            PreparedStatement ps1=conn.prepareStatement(query1);
            ps1.setFloat(1,bodyfat);
            ps1.setString(2,loginDTO.getUserID());
            ps1.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
