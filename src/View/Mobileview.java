package View;

import java.util.*;

import Resource.Mobiles;

public class Mobileview {
    
    public Scanner sc = scanner.scan();
    public void display(ArrayList<Mobiles> a){
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                                        MOBILE DETAILS                                                %n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-10s | %-18s | %-5s | %-10s | %-10s | %-19s | %-8s | %-16s |%n","ID","Brand Name","Model","Ram","Storage","Sim type","Cellular technology","Price","Available Stock");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
        for(int i=0;i<a.size();i++)
        {
            System.out.printf("| %-3s | %-10s | %-18s | %-5s | %-10s | %-10s | %-19s | %-8s | %-16s |%n",a.get(i).getid(),a.get(i).getbrand(),a.get(i).getmodel(),a.get(i).getram(),a.get(i).getstorage(),a.get(i).getsimtype(),a.get(i).getcellulartechnology(),a.get(i).getprice(),a.get(i).getcount());
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

    public Mobiles updatemob()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Mobiles up=new Mobiles();
        up.setbrand(brand);
        up.setmodel(model);
        return up;
    }

    public Mobiles newupdate(Mobiles up)
    {
        System.out.print("Enter the RAM :  ");
        String ram = sc.nextLine();
        System.out.print("Enter the Storage :  ");
        String storage = sc.nextLine();
        System.out.print("Enter the simtype :  ");
        String simtype = sc.nextLine();
        System.out.print("Enter the Cellular technology :  ");
        String celltech = sc.nextLine();
        System.out.print("Enter the Price :  ");
        int price = sc.nextInt();
        up.setram(ram);
        up.setstorage(storage);
        up.setsimtype(simtype);
        up.setcellulartechnology(celltech);
        up.setprice(price);
        return up;
    }

    public Mobiles deletemob()
    {
        System.out.print("Enter the BrandName :  ");
        String brand = sc.nextLine();
        System.out.print("Enter the Model :  ");
        String model = sc.nextLine();
        Mobiles up=new Mobiles();
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
