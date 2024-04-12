package View;
import Util.Input;
import Resources.UserDTO;
import java.util.Random;

public class SignUp
{
    public static UserDTO signUpDetails()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        Input.getStringLine();
        System.out.println("ENTER YOUR NAME");
        String name=Input.getStringLine();
        System.out.println("ENTER YOUR DATE OF BIRTH IN [YYYY-MM-DD] FORMAT");
        String dob=Input.getDate();
        System.out.println("ENTER YOUR GENDER");
        String gender=Input.getString();
        System.out.println("ENTER YOUR CONTACT NUMBER");
        String C_number=Input.getPhoneNumber();
        System.out.println("ENTER YOUR MAIL ID");
        String Email=Input.getString();
        System.out.println("ENTER YOUR NEW PASSWORD");
        String Password=Input.getString();
        String UserID="U";
        int randomnum=100+new Random().nextInt(900);
        UserID = UserID.concat(String.valueOf(randomnum));
        int ActiveUserState=1;
        return new UserDTO(UserID,name,dob,gender,C_number,Email,Password,ActiveUserState);
    }
    public static void  AlreadyUser()
    {
        System.out.println("USER ALREADY EXISTS");
    }

    public static void dataAddedSuccessful(UserDTO userDTO)
    {
        System.out.println(userDTO.getUserName()+" YOUR ACCOUNT WAS SUCCESSFULLY REGISTERED HERE IS YOU USER ID "+userDTO.getUserID());
    }
}

