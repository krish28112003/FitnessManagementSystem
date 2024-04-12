package View;

import Util.Input;

public class Welcome
{
    public int welcomeWindow() {
        while(true) {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println("WELCOME TO FITNESS MANAGEMENT SYSTEM HERE YOU CAN TRACK, MAINTAIN YOUR CALORIE AND YOUR OVERALL FITNESS LEVEL");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println(" ".repeat(40)+ "PRESS 1 TO SIGN UP");
            System.out.println(" ".repeat(40)+ "PRESS 2 TO LOGIN");
            System.out.println(" ".repeat(40)+ "PRESS 3 TO ADMIN LOGIN");
            System.out.println(" ".repeat(40)+"PRESS 0 TO EXIT");
            int response = 0;
            try {
                response = Input.getInt();
            } catch (Exception e) {
                System.out.println("INVALID! ENTER THE VALID NUMBER");
            }
            return response;
        }
    }
    public void exit()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(" ".repeat(40)+"THANK YOU FOR VISITING! SEE YA");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }
}
