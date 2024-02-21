package Resource;

public class user {
    
    private static int id;
    private static String name;
    private static String mail;
    private static String password;
    private static String role;

    public user(String Mail,String Password)
    {
        mail=Mail;
        password=Password;
    }

    public user(int Id,String Name,String Mail,String Password,String Role)
    {
        id=Id;
        name=Name;
        mail=Mail;
        password=Password;
        role=Role;
    }
    
    public user(String Name,String Mail,String Password,String Role)
    {
        name=Name;
        mail=Mail;
        password=Password;
        role=Role;
    }

    public static int getid(){
        return id;
    }

    public static String getname(){
        return name;
    }

    public static String getmail(){
        return mail;
    }

    public static String getpassword(){
        return password;
    }

    public static String getrole(){
        return role;
    }

    public static void setid(int Id){
        id=Id;
    }

    public static void setname(String Name){
        name=Name;
    }

    public static void setmail(String Mail){
        mail=Mail;
    } 

    public static void setpassword(String Password){
        password=Password;
    }

    public static void setrole(String Role){
        role=Role;
    }
}
