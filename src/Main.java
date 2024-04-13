//main
import Controller.MainController;
import java.io.IOException;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException, IOException
    {
        //ImageController.executeImage();
        MainController mc=new MainController();
        while (true)
        {
            mc.mainController();
        }    
    }
}