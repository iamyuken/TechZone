package View;

import java.util.*;

import Resource.user;
public class Loginview {

    public Scanner sc = scanner.scan();
    public boolean f=false;

    public int welcomescreen(){
        System.out.println("                                               WELCOME TO TECHZONE");
        System.out.println("                         <------------------------ Enter 1 to Signin ---------------------->");
        System.out.println("                         <------------------------ Enter 2 to Signup ---------------------->");
        System.out.println("                         <------------------------ Enter 3 to EXIT ------------------------>");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch (Exception e){
            System.out.print("Enter the Proper Number");
            welcomescreen();
        }
        return n;
    }

    public user signin()
    {
        sc.nextLine();
        System.out.print("Enter the MailID :  ");
        String mail = sc.nextLine();
        System.out.print("Enter the Password :  ");
        String password = sc.nextLine();
        user data = new user(mail, password);
        return data;
    }
    
    public user signup()
    {
        if(!f){
            sc.nextLine();
            f=true;
        }
        user user = new user();
            System.out.print("Enter the Password :  ");
            String password = sc.nextLine();
            System.out.print("Enter the Name :  ");
            String name = sc.nextLine();
            String role="User";
            user data = new user(name,user.getmail(),password,role);
            return data;
    }

    public void signupmail()
    {
        if(!f){
            sc.nextLine();
            f=true;
        }
        user use = new user();
        System.out.print("Enter the MailID :  ");
        String mail = sc.nextLine();
        use.setmail(mail);
    }
}
