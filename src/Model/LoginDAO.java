package Model;
import Resource.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    PreparedStatement pst,ps,p;

    public LoginDAO(){
        try{
            pst = DBConnection.getConnection().prepareStatement("Select User_ID,Name,Role from user where Mail_ID= ? and Password=?");
            ps = DBConnection.getConnection().prepareStatement("Select User_ID,Name,Role from user where Mail_ID= ?");
            p = DBConnection.getConnection().prepareStatement("Insert into user (Name,Mail_ID,Password,Role) values(?,?,?,?)");
        }
        catch(Exception e){
            System.out.print("                            Error");
            e.printStackTrace();
        }
    }


    public user signin(user data)
    {
        try{
            pst.setString(1,data.getmail());
            pst.setString(2,data.getpassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return new user(rs.getInt(1),rs.getString(2),data.getmail(),data.getpassword(),rs.getString(3));
            }
            else{
                return new user(0,null,null,null,null);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    
    
    public boolean checkmail(String mail)
    {
        try{
            ps.setString(1,mail);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void signup(user data){
        try{
            p.setString(1,data.getname());
            p.setString(2,data.getmail());
            p.setString(3,data.getpassword());
            p.setString(4,data.getrole());
            p.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
