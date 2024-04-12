package View;
import Controller.UserController;
import Resources.UserDTO;
import Util.Input;

public class FitnessGoal
{
    public static UserDTO fitnessGoal()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        Input.getStringLine();
        System.out.println("ENTER YOUR GOAL TYPE -- PRESS 1 TO WEIGHT GAIN | PRESS 2 TO WEIGHT LOSS |PRESS 3 TO MAINTAIN WEIGHT");
        int goaltype_i=Input.getInt();
        String goaltype= UserController.FitnessGoal(goaltype_i);
        System.out.println("ENTER YOUR TARGET WEIGHT -- IF YOUR MAINTAIN YOUR WEIGHT TYPE 0");
        float target_weight = Input.getFloat();
        System.out.println("ENTER YOUR TARGET DATE");
        String target_date=Input.getDate();
        System.out.println("ENTER YOUR CURRENT STATUS OR CURRENT REALTIME WEIGHT");
        float current_weight=Input.getFloat();
        return new UserDTO(goaltype,target_weight,target_date,current_weight);
    }

}
