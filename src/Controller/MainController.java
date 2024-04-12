package Controller;

import Model.*;
import Resources.LoginDTO;
import Resources.UserDTO;
import Util.Input;
import View.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainController
{
    public void mainController() throws SQLException, IOException {
        Welcome w = new Welcome();
        int response=w.welcomeWindow();
        if(response==1)
        {
            UserController uC =new UserController();
            UserDTO obj = SignUp.signUpDetails();
            uC.saveUser(obj);
        }
        else if (response==2)
        {
            LoginDTO obj = LoginPage.loginPage();
            LoginController lC=new LoginController();
            boolean flag = lC.checkPassword(obj);
            if(flag)
            {
                int useractive = LoginDAO.isNewUser(obj);
                if(useractive==1)
                {
                    UserDTO obj2= UserPage.isNewUser();
                    boolean flag1 = UserController.saveUserFitnessDetails(obj,obj2);
                    if(flag1)
                    {
                        UserPage.SuccessDisplay();
                    }
                    else
                    {
                        UserPage.failed();
                    }
                    UserDTO obj3=FitnessGoal.fitnessGoal();
                    UserController userController=new UserController();
                    userController.saveGoal(obj3,obj);
                    UserDTO userDTO=UserDAO.retriveFitnessData(obj,obj3);
                    UserDAO.changeFirstUsertoExisting(obj);
                    FitnessTableDAO.setFitnessTable(obj,userDTO);
                
                }
                else {
                    while (true) {
                        int num = UserPage.changeInWeight();
                        if (num == 1) {
                            UserPage.Update_current_weight();
                            UserDAO.UpdateWeight(Input.getFloat(), obj);
                            UserPage.Update_current_weight_success();
                        } else if (num == 2) {
                            UserPage.Update_BodyFat_Percentage();
                            UserDAO.UpdateBodyFatPercentage(Input.getFloat(), obj);
                            UserPage.Update_BodyFat_success();
                        }
                        else if (num == 4)
                        {
                            byte[] data=FitnessTableDAO.getDietPlan(obj);
                            EmailDAO.sendEmail(data,obj);
                        }
                        else if (num == 5)
                        {

                        }
                        else if (num == 0)
                        {
                            System.exit(0);
                        }
                    }
                }
            }
        }
        else if (response==3)
        {
            Admin admin=new Admin();
            AdminController adminController=new AdminController();
            adminController.adminController();
        }
        else if (response==0)
        {
            w.exit();
            System.exit(0);
        }
    }
}
