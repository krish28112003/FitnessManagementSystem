package View;

import Resources.LoginDTO;
import Util.Input;

public class Admin
{
    public static LoginDTO admin_login()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("ENTER YOUR MAIL ID");
        String mailid = Input.getString();
        System.out.println("ENTER YOUR PASSWORD");
        String password = Input.getString();
        return new LoginDTO(mailid,password);
    }

    public static int Update()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(" ".repeat(40)+"PRESS 1 TO UPDATE THE DIET PLAN");
        System.out.println(" ".repeat(40)+"PRESS 2 TO UPDATE THE WORKOUT PLAN");
        System.out.println(" ".repeat(40)+"PRESS 0 TO EXIT");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        return Input.getInt();
    }
    public static void S_no()
    {
        System.out.println("ENTER THE SERIAL NUMBER");
    }
    public static void Calorielog()
    {
        System.out.println("ENTER THE CALORIE LOG");
    }

    public static void Fitnesslog()
    {
        System.out.println("ENTER THE FITNESS LOG");
    }
    public static String filedirectory()
    {
        Input.getStringLine();
        System.out.println("PASTE THE FILE DIRECTORY");
        String str = Input.getStringLine();
        LoginDTO obj  = new LoginDTO();
        obj.setFilePath(str);
        return  str;
    }
    public static void fileAdded()
    {
        System.out.println("FILE WAS SUCCESSFULLY ADDED");
    }
    public static void failed()
    {
        System.out.println("FAILED TO UPLOAD A FILE");
    }
}
