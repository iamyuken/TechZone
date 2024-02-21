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
        admincontroller admin = new admincontroller();
        usercontroller users = new usercontroller();
        user data=log.signin();
        data=l.signin(data);
        if(user.getrole()!=null)
        {
            if(user.getrole().equals("User"))
            users.productsinfo();
            else if(user.getrole().equals("Admin"))
            // admin.view();
            System.out.print("Admin");
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
        l.signupmail();
        if(log.checkmail(user.getmail()))
        signup();
        else{
            System.out.println("                                                 User Already Exists");
            System.out.println("                                              Signup with another mailId");
            signupcheck();
        }
    }

    public void signup()
    {
        LoginDAO log = new LoginDAO();
        Loginview l = new Loginview();
        user data=l.signup();
        log.signup(data);
        welcome();
    }
}
