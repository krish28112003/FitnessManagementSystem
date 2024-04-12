package View;
import Resources.LoginDTO;
import Util.Input;


public class LoginPage {
    public static LoginDTO loginPage() {
        Input.getStringLine();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("ENTER YOUR MAIL ID");
        String mailid = Input.getString();
        System.out.println("ENTER YOUR USER ID");
        String UserID = Input.getString();
        System.out.println("ENTER YOUR PASSWORD");
        String password = Input.getString();
        return new LoginDTO(mailid,UserID,password);
    }

    public static void SuccessFullLogin()  {
        System.out.println("LOGIN SUCCESSFULLY");
    }

    public static void passwordIncorrect() {
        System.out.println("YOUR MAIL ID OR PASSWORD IS WRONG! PLEASE ENTER THE RIGHT MAIL_ID OR PASSWORD");

    }
}
