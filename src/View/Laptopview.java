package View;

import java.util.ArrayList;
import java.util.Scanner;

import Resource.Laptop;

public class Laptopview {
    
    public Scanner sc = scanner.scan();
    public void display(ArrayList<Laptop> a){
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                                        LAPTOP DETAILS                                                %n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-5s | %-10s | %-18s | %-10s | %-5s | %-10s | %-10s | %-7s | %-5s | %-16s |%n","ID","Brand Name","Model","Processor","Ram","Storage","Generation","Windows","Price","Available Stock");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
        for(int i=0;i<a.size();i++)
        {
            System.out.printf("| %-5s | %-10s | %-18s | %-10s | %-5s | %-10s | %-10s | %-7s | %-5s | %-16s |%n",a.get(i).getid(),a.get(i).getbrand(),a.get(i).getmodel(),a.get(i).getprocessor(),a.get(i).getram(),a.get(i).getstorage(),a.get(i).getgeneration(),a.get(i).getwindows(),a.get(i).getprice(),a.get(i).getcount());
        }
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
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
            orderid();
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

    public Laptop updatelap()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Laptop up=new Laptop();
        up.setbrand(brand);
        up.setmodel(model);
        return up;
    }

    public Laptop newupdate(Laptop up)
    {
        System.out.print("Enter the Processor :  ");
        String processor = sc.nextLine();
        System.out.print("Enter the RAM :  ");
        String ram = sc.nextLine();
        System.out.print("Enter the Storage :  ");
        String storage = sc.nextLine();
        System.out.print("Enter the Generation :  ");
        String gen = sc.nextLine();
        System.out.print("Enter the Windows :  ");
        String windows = sc.nextLine();
        System.out.print("Enter the Price :  ");
        int price = sc.nextInt();
        up.setprocessor(processor);
        up.setram(ram);
        up.setstorage(storage);
        up.setgeneration(gen);
        up.setwindows(windows);
        up.setprice(price);
        return up;
    }

    public Laptop deletelap()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Laptop up=new Laptop();
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
