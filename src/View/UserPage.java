package View;
import Controller.ImageController;
import Controller.UserController;
import Resources.UserDTO;
import Util.Input;


public class UserPage
{
    public static UserDTO isNewUser()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(" ".repeat(40)+"WELCOME TO YOUR NEW FITNESS JOURNEY");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("ENTER YOUR HEIGHT");
        float height= Input.getFloat();
        System.out.println("ENTER YOUR WEIGHT");
        float weight=Input.getFloat();
        System.out.println("ENTER YOUR BODY FAT PERCENTAGE! NOW IMAGE WILL SHOWN CHOOSE ACCORDING TO YOUR BODY");
        ImageController.executeImage();
        int bodyfat=Input.getInt();
        System.out.println("ENTER YOUR ACTIVITY - \n PRESS 1 TO SEDENTARY- \n PRESS 2 TO LIGHTLY ACTIVE- \n PRESS 3 TO MODERATLY ACTIVE- \n PRESS 4 TO HIGHLY ACTIVE");
        int activity_level_choice=Input.getInt();
        String activity_level=UserController.userActivityLevel(activity_level_choice);
        return new UserDTO(height,weight,bodyfat,activity_level);
    }


    public static void SuccessDisplay()
    {
        System.out.println("DATA ADDED SUCCESSFULLY");
    }
    public static void failed()
    {
        System.out.println("FAIL TO ADD DATA");
    }
    public static int changeInWeight()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(" ".repeat(40)+"PRESS 1: TO CHANGE THE WEIGHT");
        System.out.println(" ".repeat(40)+"PRESS 2: TO CHANGE THE BODYFAT");
        System.out.println(" ".repeat(40)+"PRESS 3: TO SEE THE CURRENT FITNESS TABLE");
        System.out.println(" ".repeat(40)+"PRESS 4: TO GET A DIET PLAN");
        System.out.println(" ".repeat(40)+"PRESS 5: TO GET A WORKOUT PLAN");
        System.out.println(" ".repeat(40)+"PRESS 0: TO EXIT");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        return Input.getInt();
    }

    public static void Update_current_weight()
    {
        System.out.println("ENTER THE CURRENT WEIGHT");
    }
    public static void Update_BodyFat_Percentage()
    {
        System.out.println("ENTER THE CURRENT BODY FAT PERCENTAGE");
        System.out.println("ENTER YOUR BODY FAT PERCENTAGE! NOW IMAGE WILL SHOWN CHOOSE ACCORDING TO YOUR BODY");
        ImageController.executeImage();
    }
    public static void Update_current_weight_success()
    {
        System.out.println("CURRENT WEIGHT WAS UPDATED SUCCESSFULLY/");
    }
    public static void Update_BodyFat_success()
    {
        System.out.println("CURRENT BODYFAT WAS UPDATED SUCCESSFULLY/");
    }
}
