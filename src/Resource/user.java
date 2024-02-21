package Resource;

public class user {
    
    private  int id;
    private String name;
    private String mail;
    private String password;
    private String role;

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
    public user()
    {

    }
    public user(String Name,String Mail,String Password,String Role)
    {
        name=Name;
        mail=Mail;
        password=Password;
        role=Role;
    }

    public int getid(){
        return id;
    }

    public String getname(){
        return name;
    }

    public String getmail(){
        return mail;
    }

    public String getpassword(){
        return password;
    }

    public String getrole(){
        return role;
    }

    public void setid(int Id){
        id=Id;
    }

    public void setname(String Name){
        name=Name;
    }

    public void setmail(String Mail){
        mail=Mail;
    } 

    public void setpassword(String Password){
        password=Password;
    }

    public void setrole(String Role){
        role=Role;
    }
}
