package Controller;
import Model.UserDAO;
import Resources.LoginDTO;
import Resources.UserDTO;
import View.SignUp;
import javax.swing.*;
import java.sql.SQLException;

public class UserController extends JFrame
{
    public void saveUser(UserDTO user) throws SQLException
    {
        boolean isalreadyuser = UserDAO.isUserAlreadyExists(user);
        if (isalreadyuser)
        {
            SignUp.AlreadyUser();
        }
        else
        {
            UserDAO.saveUser(user);
            SignUp.dataAddedSuccessful(user);
        }
    }

    public void saveGoal(UserDTO userDTO,LoginDTO loginDTO) throws SQLException
    {
        UserDAO.saveGoal(userDTO,loginDTO);
    }
    public static boolean saveUserFitnessDetails(LoginDTO login, UserDTO userDTO) throws SQLException {
        boolean flag = UserDAO.saveUserFitnessDetail(login, userDTO);
        if (flag) {
            return true;
        }
        return false;
    }

    public static String userActivityLevel(int data)
    {
        return switch (data)
        {
            case 1 -> "Sedentary";
            case 2 -> "Lightly Active";
            case 3 -> "Moderatly Active";
            case 4 -> "Highly Active";
            default -> null;
        };
    }

    public static String FitnessGoal(int data)
    {
        return switch (data){
            case 1 -> "Weight Gain";
            case 2 -> "Weight Lose";
            case 3 -> "Maintain Weight";
            default ->  null;
        };
    }
}
