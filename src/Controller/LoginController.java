package Controller;

import Model.LoginDAO;
import Resources.LoginDTO;
import View.LoginPage;

import java.sql.SQLException;

public class LoginController
{
    public boolean checkPassword(LoginDTO loginDTO) throws SQLException
    {
        boolean isPasswordCorrect= LoginDAO.isPasswordCorrect(loginDTO);
        if(isPasswordCorrect)
        {
            LoginPage.SuccessFullLogin();
        }
        else
        {
            LoginPage.passwordIncorrect();
            return false;
        }
        return isPasswordCorrect;
    }

}
