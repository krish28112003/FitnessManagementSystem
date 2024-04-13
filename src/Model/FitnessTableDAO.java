package Model;
import Resources.LoginDTO;
import Resources.UserDTO;
import Util.DB;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FitnessTableDAO {

    public static ArrayList<UserDTO> getfitnessTable(LoginDTO loginDTO) {
        try {
            Connection conn = DB.getConnection();
            String query = "SELECT * FROM FITNESS_TABLE WHERE USER_ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, loginDTO.getUserID());
            //ps.executeUpdate();
            ArrayList<UserDTO> data = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                float m_calorie = rs.getFloat(2);
                float p_intake = rs.getFloat(3);
                float c_intake = rs.getFloat(4);
                float f_intake = rs.getFloat(5);
                data.add(new UserDTO(id, m_calorie, p_intake, c_intake, f_intake));
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void setFitnessTable(LoginDTO loginDTO, UserDTO userDTO) {
        try {
            Connection conn = DB.getConnection();
            String query = "INSERT INTO FITNESS_TABLE(User_ID, MAINTAINACE_CALORIE, PROTEIN_INTAKE, CARBS_INTAKE, FAT_INTAKE) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, loginDTO.getUserID());
            ps.setFloat(2, (float) (userDTO.getBody_Weight() * 2.2 * 14));
            ps.setFloat(3, (float) (userDTO.getBody_Weight() * 2.2));
            ps.setFloat(4, userDTO.getBody_Weight() * 10);
            ps.setFloat(5, (float) (userDTO.getBody_Weight() * 1.5));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static float getMaintainceCalorie(LoginDTO loginDTO) {
        float f = 0;
        try {
            Connection conn = DB.getConnection();
            String query = "SELECT MAINTAINACE_CALORIE FROM FITNESS_TABLE WHERE USER_ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, loginDTO.getUserID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f = rs.getFloat("MAINTAINACE_CALORIE");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return f;
    }

    
    public static byte[] getDietPlan(LoginDTO loginDTO) throws IOException {
        float maintainceCalorie = FitnessTableDAO.getMaintainceCalorie(loginDTO);
        try {

            Connection conn = DB.getConnection();
            String query = "SELECT FILE_NAME,FILE_DATA FROM DIETFILE WHERE FIL_NO=1";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String filename = rs.getString("FILE_NAME");
                InputStream fileData = rs.getBinaryStream("FILE_DATA");
                FileOutputStream fos = new FileOutputStream(filename);
                byte[] buffer = new byte[1024];
                while (fileData.read(buffer) > 0) {
                    fos.write(buffer);
                }
                fos.close();
                System.out.println("PDF file retrieved successfully.");
                return buffer;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        if (maintainceCalorie >= 500 && maintainceCalorie <= 1000) {
            try {

                Connection conn = DB.getConnection();
                String query = "SELECT FILE_NAME,FILE_DATA FROM DIETFILE WHERE FIL_NO=1";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String filename = rs.getString("FILE_NAME");
                    InputStream fileData = rs.getBinaryStream("FILE_DATA");
                    FileOutputStream fos = new FileOutputStream(filename);
                    byte[] buffer = new byte[1024];
                    while (fileData.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    fos.close();
                    //System.out.println(fos);
                    System.out.println("PDF file retrieved successfully.");
                    return buffer;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
        else if (maintainceCalorie >= 1500 && maintainceCalorie <= 2000) {
            try {

                Connection conn = DB.getConnection();
                String query = "SELECT FILE_NAME,FILE_DATA FROM DIETFILE WHERE FIL_NO=1";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String filename = rs.getString("FILE_NAME");
                    InputStream fileData = rs.getBinaryStream("FILE_DATA");
                    FileOutputStream fos = new FileOutputStream(filename);
                    byte[] buffer = new byte[1024];
                    while (fileData.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    fos.close();
                    //System.out.println(fos);
                    System.out.println("PDF file retrieved successfully.");
                    return buffer;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;

        } else if (maintainceCalorie >= 2000 && maintainceCalorie <= 2500)
        {
            try {

                Connection conn = DB.getConnection();
                String query = "SELECT FILE_NAME,FILE_DATA FROM DIETFILE WHERE FIL_NO=1";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String filename = rs.getString("FILE_NAME");
                    InputStream fileData = rs.getBinaryStream("FILE_DATA");
                    FileOutputStream fos = new FileOutputStream(filename);
                    byte[] buffer = new byte[1024];
                    while (fileData.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    //System.out.println(fos);
                    System.out.println("PDF file retrieved successfully.");
                    return buffer;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;

        } else if (maintainceCalorie >= 2500 && maintainceCalorie <= 3000) {
            try {

                Connection conn = DB.getConnection();
                String query = "SELECT FILE_NAME,FILE_DATA FROM DIETFILE WHERE FIL_NO=2";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String filename = rs.getString("FILE_NAME");
                    InputStream fileData = rs.getBinaryStream("FILE_DATA");
                    FileOutputStream fos = new FileOutputStream(filename);
                    byte[] buffer = new byte[1024];
                    while (fileData.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    //System.out.println(fos);
                    System.out.println("PDF file retrieved successfully.");
                    return buffer;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
        return null;
    }

    public static FileInputStream getFitnessPlan() {
        return null;
    }
}
