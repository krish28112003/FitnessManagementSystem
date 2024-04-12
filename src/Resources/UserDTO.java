package Resources;

public class UserDTO
{
    private String UserID;
    private String userName;
    private  String DoB;
    private String gender;
    private String contact_number;
    private String userMailID;
    private String userPassword;
    public int activeStatus=1;

    private String Goal;
    private float body_Weight;
    private float height;
    private float weight;
    private int body_fat_percentage;
    private String activity_level;
    private String goal_type;
    private float target_value;
    private String target_date;

    private float Maintainance_Calorie;
    private float Protein_intake;
    private float Carbs_Intake;
    private String UID;
    private float Fat_Intake;

    public UserDTO(String UID, float Maintainance_Calorie,float Protein_intake,float Carbs_Intake,float Fat_Intake)
    {
        this.UID=UID;
        this.Maintainance_Calorie=Maintainance_Calorie;
        this.Protein_intake=Protein_intake;
        this.Carbs_Intake=Carbs_Intake;
        this.Fat_Intake=Fat_Intake;
    }

    public UserDTO(String UserID, String userName, String DoB, String gender, String contact_number, String userMailID, String userPassword, int activeStatus)
    {
        this.UserID=UserID;
        this.userName=userName;
        this.DoB=DoB;
        this.gender=gender;
        this.contact_number=contact_number;
        this.userMailID=userMailID;
        this.userPassword=userPassword;
        this.activeStatus=activeStatus;
    }

    public int isActiveStatus()
    {
        return activeStatus;
    }

    public float getWeight() {
        return weight;
    }

    public int getBody_fat_percentage() {
        return body_fat_percentage;
    }

    public void setBody_fat_percentage(int body_fat_percentage) {
        this.body_fat_percentage = body_fat_percentage;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getActivity_level() {
        return activity_level;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setActivity_level(String activity_level) {
        this.activity_level = activity_level;
    }

    public UserDTO(float height, float weight, int body_fat_percentage, String activity_level)
    {
        this.height=height;
        this.weight=weight;
        this.body_fat_percentage=body_fat_percentage;
        this.activity_level=activity_level;
    }
    public String getUserMailID() {
        return userMailID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getContact_number() {return contact_number;}

    public void setContact_number(String contact_number) {this.contact_number = contact_number;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public int getActiveStatus() {return activeStatus;}

    public void setActiveStatus(int activeStatus) {this.activeStatus = activeStatus;}

    public String getDoB() {return DoB;}

    public void setDoB(String doB) {DoB = doB;}

    public String getUserName() {
        return userName;
    }

    public void setUserMailID(String userMailID) {
        this.userMailID = userMailID;
    }

    public String getUserID() {return UserID;}

    public void setUserID(String userID) {UserID = userID;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {this.userPassword = userPassword;}

    public String getGoal_type() {
        return goal_type;
    }

    public String getTarget_date() {
        return target_date;
    }

    public float getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(float current_status) {
        this.current_status = current_status;
    }

    public void setTarget_date(String target_date) {
        this.target_date = target_date;
    }

    public float getTarget_value() {
        return target_value;
    }

    public void setTarget_value(float target_value) {
        this.target_value = target_value;
    }

    public void setGoal_type(String goal_type) {
        this.goal_type = goal_type;
    }

    private float current_status;
    public UserDTO(String goal_type, float target_value, String target_date, float current_status)
    {
        this.goal_type=goal_type;
        this.target_value=target_value;
        this.target_date=target_date;
        this.current_status=current_status;
    }

    public String getGoal() {
        return Goal;
    }

    public float getBody_Weight()
    {
        return body_Weight;
    }

    public void setBody_Weight(float body_Weight) {
        this.body_Weight = body_Weight;
    }

    public void setGoal(String goal)
    {
        this.Goal = goal;
    }


    UserDTO(String Goal,float body_Weight)
    {
        this.Goal=Goal;
        this.body_Weight=body_Weight;
    }
}
