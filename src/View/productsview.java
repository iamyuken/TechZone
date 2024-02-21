package View;

import java.util.*;
import java.util.ArrayList;

public class productsview {
    
    public Scanner sc = scanner.scan();
    public void display(ArrayList<ArrayList<String>> a)
    {
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                                        PRODUCT DETAILS                                                %n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("------------------------------------------------%n");
        System.out.printf("| %-5s | %-25s | %-8s |%n","ID","PRODUCT NAME","STOCK");
        System.out.printf("------------------------------------------------%n");
        for(int i=0;i<a.size();i++)
        {
            ArrayList<String> b = new ArrayList<>(a.get(i));
            System.out.printf("| %-5s | %-25s | %-8s |%n",b.get(0),b.get(1),b.get(2));
        }
        System.out.printf("------------------------------------------------%n");
    }

    public int selectproduct()
    {
        System.out.print("Enter the ID to Select the Product you want to buy :  ");
        int n=0;
        try{
            n=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Please Enter the proper number");
            selectproduct();
        }
        return n;
    }
}
