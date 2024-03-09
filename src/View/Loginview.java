package View;

import java.util.*;

import Resource.user;
public class Loginview {

    public Scanner sc = scanner.scan();
    public boolean f=false;

    public int welcomescreen(){
        boolean f=false;
        int n=0;
        while(!f){
            System.out.println("                                               WELCOME TO TECHZONE");
            System.out.println("                         <------------------------ Enter 1 to Signin ---------------------->");
            System.out.println("                         <------------------------ Enter 2 to Signup ---------------------->");
            System.out.println("                         <------------------------ Enter 3 to EXIT ------------------------>");
            try{
                n=sc.nextInt();
                f=true;
            }
            catch (Exception e){
                System.out.print("Enter the Proper Number");
                sc.nextLine();
            }
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
    
    public user signup(user data)
    {
        // if(!f){
        //     sc.nextLine();
        //     f=true;
        // }
            // user user = new user();
            System.out.print("Enter the Password :  ");
            String password = sc.nextLine();
            System.out.print("Enter the Name :  ");
            String name = sc.nextLine();
            String role="User";
            data.setpassword(password);
            data.setname(name);
            data.setrole(role);
            System.out.println(data.getmail());
            // user data = new user(name,user.getmail(),password,role);
            return data;
    }

    public user signupmail()
    {
        sc.nextLine();
        user use = new user();
        System.out.print("Enter the MailID :  ");
        String mail = sc.nextLine();
        use.setmail(mail);
        return use;
    }
}
