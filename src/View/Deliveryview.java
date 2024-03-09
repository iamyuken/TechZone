package View;

import java.util.*;

import Resource.Delivery;
public class Deliveryview {

    public Scanner sc = scanner.scan();
    public Delivery newdelivery(int id)
    {
        sc.nextLine();
        System.out.println("                                             Enter the Delivery Details");
        System.out.print("Enter the Mobile Number :  ");
        String mobile = sc.nextLine();
        System.out.print("Enter the Address of the delivery :  ");
        String address = sc.nextLine();
        System.out.print("Enter the City :  ");
        String city = sc.nextLine();
        Delivery deli = new Delivery(id,mobile,address,city);
        return deli;
    }

    public int updelivery()
    {
        System.out.println("                                             Enter 1 to Update the Address details");
        System.out.println("                                             Enter 2 to Complete the order");
        int n = 0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.println("                                       Please Enter the Valid Number");
            updelivery();
        }
        return n;
    }
}
