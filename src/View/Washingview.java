package View;

import java.util.ArrayList;
import java.util.Scanner;

import Resource.Washing;

public class Washingview {
    
    public Scanner sc = scanner.scan();
    public void display(ArrayList<Washing> a){
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                                        WASHING MACHINE DETAILS                                                %n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("----------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-10s | %-20s | %-16s | %-10s | %-16s |%n","ID","Brand Name","Model","Washing Capacity","Price","Available Stock");
        System.out.printf("----------------------------------------------------------------------------------------------%n");
        for(int i=0;i<a.size();i++)
        {
            System.out.printf("| %-3s | %-10s | %-20s | %-16s | %-10s | %-16s |%n",a.get(i).getid(),a.get(i).getbrand(),a.get(i).getmodel(),a.get(i).getwashingcapacity(),a.get(i).getprice(),a.get(i).getcount());
        }
        System.out.printf("----------------------------------------------------------------------------------------------%n");
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
        System.out.print("Enter the Count of the Product you want :  ");
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

    public Washing updatewash()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Washing up=new Washing();
        up.setbrand(brand);
        up.setmodel(model);
        return up;
    }

    public Washing newupdate(Washing up)
    {
        System.out.print("Enter the Capacity :  ");
        String cap = sc.nextLine();
        System.out.print("Enter the Price :  ");
        int price = sc.nextInt();
        up.setwashingcapacity(cap);
        up.setprice(price);
        return up;
    }

    public Washing deletewash()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Washing up=new Washing();
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
