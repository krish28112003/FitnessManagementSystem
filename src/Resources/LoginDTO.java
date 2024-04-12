package Resources;

public class LoginDTO
{
    private String MailID;
    private String UserID;
    private String Password;
    private String AdminMailID;
    private String AdminPassword;
    private String filePath;

    public LoginDTO(String MailID, String UserId, String Password)
    {
        this.MailID=MailID;
        this.UserID=UserId;
        this.Password=Password;
    }

    public LoginDTO(String AdminMailId, String AdminPassword)
    {
        this.AdminMailID=AdminMailId;
        this.AdminPassword=AdminPassword;
    }
    public LoginDTO()
    {
        this.filePath=filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }


    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }

    public String getAdminMailID() {
        return AdminMailID;
    }

    public void setAdminMailID(String adminMailID) {
        AdminMailID = adminMailID;
    }


    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMailID() {
        return MailID;
    }

    public void setMailID(String mailID) {
        MailID = mailID;
    }


}
