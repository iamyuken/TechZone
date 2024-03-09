package View;

import java.util.*;
import java.util.ArrayList;
import Resource.*;

public class productsview {
    
    public Scanner sc = scanner.scan();
    public void display(ArrayList<products> a)
    {
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                                        PRODUCT DETAILS                                                %n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("------------------------------------------------%n");
        System.out.printf("| %-5s | %-25s | %-8s |%n","ID","PRODUCT NAME","STOCK");
        System.out.printf("------------------------------------------------%n");
        for(int i=0;i<a.size();i++)
        {
            System.out.printf("| %-5s | %-25s | %-8s |%n",a.get(i).getid(),a.get(i).getproductname(),a.get(i).getcount());
        }
        System.out.printf("------------------------------------------------%n");
    }

    public int selectproduct(user data)
    {
        if(data.getrole().equals("User"))
        System.out.print("Enter the ID to Select the Product you want to buy :  ");
        else
        System.out.print("Enter the ID to Update or delete the product :  ");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter the proper number");
            selectproduct(data);
        }
        return n;
    }
}
