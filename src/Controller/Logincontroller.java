package Controller;

import Model.*;
import View.*;
import Resource.*;
public class Logincontroller {
    

    public void welcome()
    {
        Loginview log = new Loginview();
        int choice=log.welcomescreen();
        if(choice==1)
        signincheck();
        else if(choice==2)
        signupcheck();
        else if(choice==3)
        return;
        else{
            System.out.println("Enter the Proper Number");
            welcome();
        }
    }

    public void signincheck()
    {
        Loginview log = new Loginview();
        LoginDAO l = new LoginDAO();
        // user use = new user();
        admincontroller admin = new admincontroller();
        usercontroller users = new usercontroller();
        user data=log.signin();
        data=l.signin(data);
        if(data.getrole()!=null)
        {
            if(data.getrole().equals("User"))
            users.productsinfo(data);
            else if(data.getrole().equals("Admin"))
            admin.productsinfo(data);
        }
        else{
            System.out.println("                                         User doesn't exists");
            System.out.println("                                Please Signup or Enter the correct mail_ID and Password");
            welcome();
        }
    }

    public void signupcheck()
    {
        LoginDAO log = new LoginDAO();
        Loginview l= new Loginview();
        user data = l.signupmail();
        if(log.checkmail(data.getmail()))
        signup(data);
        else{
            System.out.println("                                                 User Already Exists");
            System.out.println("                                              Signup with another mailId");
            // signupcheck();
            welcome();
        }
    }

    public void signup(user data)
    {
        LoginDAO log = new LoginDAO();
        Loginview l = new Loginview();
        data=l.signup(data);
        log.signup(data);
        welcome();
    }
}
