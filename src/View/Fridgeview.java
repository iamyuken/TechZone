package View;

import java.util.ArrayList;
import java.util.Scanner;

import Resource.Fridge;

public class Fridgeview {
    
     public Scanner sc = scanner.scan();
    public void display(ArrayList<Fridge> a){
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                                        FRIDGE DETAILS                                                %n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("--------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-10s | %-18s | %-10s | %-15s | %-10s | %-16s |%n","ID","Brand Name","Model","Capacity","Door type","Price","Available Stock");
        System.out.printf("--------------------------------------------------------------------------------------------------------%n");
        for(int i=0;i<a.size();i++)
        {
            System.out.printf("| %-3s | %-10s | %-18s | %-10s | %-15s | %-10s | %-16s |%n",a.get(i).getid(),a.get(i).getbrand(),a.get(i).getmodel(),a.get(i).getcapacity(),a.get(i).getdoortype(),a.get(i).getprice(),a.get(i).getcount());
        }
        System.out.printf("--------------------------------------------------------------------------------------------------------%n");
    }

    public int orderid()
    {
        System.out.print("Enter the ID you want to buy :  ");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter a Valid ID");
            sc.nextLine();
        }
        return n;
    }

    public int ordercount()
    {
        System.out.print("Enter the Count of the Product :  ");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter a Valid ID");
            sc.nextLine();
        }
        return n;
    }

    public int reorder()
    {
        System.out.println("                                       Enter 1 to Order the Products again");
        System.out.println("                                       Enter 2 to Complete the Order");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter a Valid ID");
            sc.nextLine();
        }
        return n;
    }

    public int updateordelete()
    {
        System.out.println("                                       Enter 1 to Update the Products");
        System.out.println("                                       Enter 2 to Delete the Products");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter a Valid ID");
            sc.nextLine();
        }
        sc.nextLine();
        return n;
    }

    public Fridge updatefri()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Fridge up=new Fridge();
        up.setbrand(brand);
        up.setmodel(model);
        return up;
    }

    public Fridge newupdate(Fridge up)
    {
        System.out.print("Enter the Capacity :  ");
        String cap = sc.nextLine();
        System.out.print("Enter the Door type :  ");
        String door = sc.nextLine();
        System.out.print("Enter the Price :  ");
        int price = sc.nextInt();
        up.setcapacity(cap);
        up.setdoortype(door);
        up.setprice(price);
        return up;
    }

    public Fridge deletefri()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Fridge up=new Fridge();
        up.setbrand(brand);
        up.setmodel(model);
        return up;
    }

    public int deleteview()
    {
        System.out.println("                                       Enter 1 to Reduce the Count of the Products");
        System.out.println("                                       Enter 2 to Delete the Whole Product");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter a Valid ID");
            sc.nextLine();
        }
        sc.nextLine();
        return n;
    }

    public int deletecount()
    {
        System.out.println("                                       Enter the Count of the Products to Reduce");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter a Valid ID");
            sc.nextLine();
        }
        sc.nextLine();
        return n;
    }
}
