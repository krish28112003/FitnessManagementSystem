
package Controller;

import Model.AdminDAO;
import Model.LoginDAO;
import Resources.LoginDTO;
import View.Admin;
import View.LoginPage;
import View.Welcome;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class AdminController
{
    public void adminController() throws FileNotFoundException {
        LoginDTO loginDTO= Admin.admin_login();
        boolean b= LoginDAO.isAdminPasswordCorrect(loginDTO);
        if(b) {
            while (true) {
                int response1 = Admin.Update();
                if (response1 == 1) {
                    String filedirectory = Admin.filedirectory();
                    File file = new File(filedirectory);
                    FileInputStream fis = new FileInputStream(file);
                    boolean flag = AdminDAO.addDietPlan(fis, file);
                    if (!flag) {
                        Admin.fileAdded();
                    } else {
                        Admin.failed();
                    }
                } else if (response1 == 2) {
                    AdminDAO.addFitnessPlan();
                    Admin.fileAdded();
                } else {
                    Welcome w=new Welcome();
                    w.exit();
                    System.exit(0);
                }
            }
        }
        else
            LoginPage.passwordIncorrect();
    }
}
