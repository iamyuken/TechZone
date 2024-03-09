package Controller;

import java.util.*;

import Model.*;
import Resource.*;
import View.*;

public class admincontroller {
       
    public void productsinfo(user data)
    {
        productsDAO  p = new productsDAO();
        productsview view = new productsview();
        ArrayList<products> a = p.product();
        view.display(a);
        selectproduct(data);
    }
    
    public void selectproduct(user data){
        productsDAO  p = new productsDAO();
        productsview view = new productsview();
        int n = view.selectproduct(data);
        if(n==1){
            products product = p.selectproduct(n);
            TV(product,data);
        }
        else if(n==2){
            products product = p.selectproduct(n);
            Laptop(product,data);
        }
        else if(n==3){
            products product = p.selectproduct(n);
            Mobiles(product,data);
        }
        else if(n==4){
            products product = p.selectproduct(n);
            Fridge(product,data);
        }
        else if(n==5){
            products product = p.selectproduct(n);
            WashingMachine(product,data);
        }
        else{
            System.out.println("                                              Please Enter the Proper Number");
            selectproduct(data);
        }
    }

    public void TV(products product,user data){
        TVDAO tv = new TVDAO(product.getproductname());
        TVview t = new TVview();
        ArrayList<TV> a = tv.admindisplay();
        t.display(a);
        boolean f=false;
        while(!f){
            int choice = t.updateordelete();
            if(choice == 1)
            {
                Resource.TV up = t.updatetv();
                boolean found = false;
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(up.getbrand())) && (a.get(i).getmodel().equals(up.getmodel()))){
                        int count = t.ordercount();
                        up.setcount(count);
                        tv.adminupdate(up,product,a.get(i).getcount());
                        a.get(i).setcount(a.get(i).getcount()+count);
                        found=true;
                        System.out.print("                                     Product is Successfully Updated!!!");
                    }
                }
                if(!found)
                {
                    up = t.newupdate(up);
                    int count = t.ordercount();
                    up.setcount(count); 
                    tv.adminupdatenew(up,product,count);
                    System.out.print("                                          Product is Successfully Added!!!");
                }
                f=true;
            }
            else if(choice == 2)
            {
                Resource.TV del= t.deletetv();
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(del.getbrand())) && (a.get(i).getmodel().equals(del.getmodel())))
                    {
                        boolean bool=false;
                        while(!bool)
                        {
                            int n=t.deleteview();
                            if(n==1){
                                boolean s=false;
                                while(!s){
                                    int c = t.deletecount();
                                    int totcount = a.get(i).getcount();
                                    if(totcount>=c)
                                    {
                                        a.get(i).setcount(totcount-c);
                                        product.setcount(product.getcount()-c);
                                        tv.deletecount(a.get(i),product);
                                        s=true;
                                        System.out.print("The Count of the product is Reduced Successfully!!!");
                                    }
                                    else 
                                    System.out.println("                                               Enter the Proper Count!!!");
                                }
                                bool=true;
                            }
                            else if(n==2){
                                product.setcount(product.getcount()-a.get(i).getcount());
                                tv.delete(a.get(i),product);
                                System.out.print("The product is Deleted Successfully!!!");
                                bool=true;
                            }
                            else 
                            System.out.println("                                               Enter the Valid Number!!!");
                        }
                    }
                }
                f=true;
            }
            else{
                System.out.println("Enter the Valid Number");
            }
        }
    }


    public void Laptop(products product,user data){
        LaptopDAO laptop = new LaptopDAO(product.getproductname());
        Laptopview lap = new Laptopview();
        ArrayList<Laptop> a = laptop.admindisplay();
        lap.display(a);
        boolean f=false;
        while(!f){
            int choice = lap.updateordelete();
            if(choice == 1)
            {
                Resource.Laptop up = lap.updatelap();
                boolean found = false;
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(up.getbrand())) && (a.get(i).getmodel().equals(up.getmodel()))){
                        int count = lap.ordercount();
                        up.setcount(count);
                        laptop.adminupdate(up,product,a.get(i).getcount());
                        a.get(i).setcount(a.get(i).getcount()+count);
                        found=true;
                        System.out.print("                                     Product is Successfully Updated!!!");
                    }
                }
                if(!found)
                {
                    up = lap.newupdate(up);
                    int count = lap.ordercount();
                    up.setcount(count); 
                    laptop.adminupdatenew(up,product,count);
                    System.out.print("                                          Product is Successfully Added!!!");
                }
                f=true;
            }
            else if(choice == 2)
            {
                Resource.Laptop del= lap.deletelap();
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(del.getbrand())) && (a.get(i).getmodel().equals(del.getmodel())))
                    {
                        boolean bool=false;
                        while(!bool)
                        {
                            int n=lap.deleteview();
                            if(n==1){
                                boolean s=false;
                                while(!s){
                                    int c = lap.deletecount();
                                    int totcount = a.get(i).getcount();
                                    if(totcount>=c && c>=0)
                                    {
                                        a.get(i).setcount(totcount-c);
                                        product.setcount(product.getcount()-c);
                                        laptop.deletecount(a.get(i),product);
                                        s=true;
                                        System.out.print("The Count of the product is Reduced Successfully!!!");
                                    }
                                    else 
                                    System.out.println("                                               Enter the Proper Count The Entered count is greater than existing count!!!");
                                }
                                bool=true;
                            }
                            else if(n==2){
                                product.setcount(product.getcount()-a.get(i).getcount());
                                laptop.delete(a.get(i),product);
                                System.out.print("                                                   The product is Deleted Successfully!!!");
                                bool=true;
                            }
                            else 
                            System.out.println("                                               Enter the Valid Number!!!");
                        }
                    }
                }
                f=true;
            }
            else{
                System.out.println("                                                 Enter the Valid Number");
            }
        }
    }


    public void Mobiles(products product,user data){
        MobileDAO mobile = new MobileDAO(product.getproductname());
        Mobileview mob = new Mobileview();
        ArrayList<Mobiles> a = mobile.admindisplay();
        mob.display(a);
        boolean f=false;
        while(!f){
            int choice = mob.updateordelete();
            if(choice == 1)
            {
                Resource.Mobiles up = mob.updatemob();
                boolean found = false;
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(up.getbrand())) && (a.get(i).getmodel().equals(up.getmodel()))){
                        int count = mob.ordercount();
                        up.setcount(count);
                        mobile.adminupdate(up,product,a.get(i).getcount());
                        a.get(i).setcount(a.get(i).getcount()+count);
                        found=true;
                        System.out.print("                                     Product is Successfully Updated!!!");
                    }
                }
                if(!found)
                {
                    up = mob.newupdate(up);
                    int count = mob.ordercount();
                    up.setcount(count); 
                    mobile.adminupdatenew(up,product,count);
                    System.out.print("                                          Product is Successfully Added!!!");
                }
                f=true;
            }
            else if(choice == 2)
            {
                Resource.Mobiles del= mob.deletemob();
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(del.getbrand())) && (a.get(i).getmodel().equals(del.getmodel())))
                    {
                        boolean bool=false;
                        while(!bool)
                        {
                            int n=mob.deleteview();
                            if(n==1){
                                boolean s=false;
                                while(!s){
                                    int c = mob.deletecount();
                                    int totcount = a.get(i).getcount();
                                    if(totcount>=c && c>=0)
                                    {
                                        a.get(i).setcount(totcount-c);
                                        product.setcount(product.getcount()-c);
                                        mobile.deletecount(a.get(i),product);
                                        s=true;
                                        System.out.print("The Count of the product is Reduced Successfully!!!");
                                    }
                                    else 
                                    System.out.println("                                               Enter the Proper Count The Entered count is greater than existing count!!!");
                                }
                                bool=true;
                            }
                            else if(n==2){
                                product.setcount(product.getcount()-a.get(i).getcount());
                                mobile.delete(a.get(i),product);
                                System.out.print("                                                   The product is Deleted Successfully!!!");
                                bool=true;
                            }
                            else 
                            System.out.println("                                               Enter the Valid Number!!!");
                        }
                    }
                }
                f=true;
            }
            else{
                System.out.println("                                                 Enter the Valid Number");
            }
        }
    }


    public void Fridge(products product,user data){
        FridgeDAO fridge = new FridgeDAO(product.getproductname());
        Fridgeview fri = new Fridgeview();
        ArrayList<Fridge> a = fridge.admindisplay();
        fri.display(a);
        boolean f=false;
        while(!f){
            int choice = fri.updateordelete();
            if(choice == 1)
            {
                Resource.Fridge up = fri.updatefri();
                boolean found = false;
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(up.getbrand())) && (a.get(i).getmodel().equals(up.getmodel()))){
                        int count = fri.ordercount();
                        up.setcount(count);
                        fridge.adminupdate(up,product,a.get(i).getcount());
                        a.get(i).setcount(a.get(i).getcount()+count);
                        found=true;
                        System.out.print("                                     Product is Successfully Updated!!!");
                    }
                }
                if(!found)
                {
                    up = fri.newupdate(up);
                    int count = fri.ordercount();
                    up.setcount(count); 
                    fridge.adminupdatenew(up,product,count);
                    System.out.print("                                          Product is Successfully Added!!!");
                }
                f=true;
            }
            else if(choice == 2)
            {
                Resource.Fridge del= fri.deletefri();
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(del.getbrand())) && (a.get(i).getmodel().equals(del.getmodel())))
                    {
                        boolean bool=false;
                        while(!bool)
                        {
                            int n=fri.deleteview();
                            if(n==1){
                                boolean s=false;
                                while(!s){
                                    int c = fri.deletecount();
                                    int totcount = a.get(i).getcount();
                                    if(totcount>=c && c>=0)
                                    {
                                        a.get(i).setcount(totcount-c);
                                        product.setcount(product.getcount()-c);
                                        fridge.deletecount(a.get(i),product);
                                        s=true;
                                        System.out.print("The Count of the product is Reduced Successfully!!!");
                                    }
                                    else 
                                    System.out.println("                                               Enter the Proper Count The Entered count is greater than existing count!!!");
                                }
                                bool=true;
                            }
                            else if(n==2){
                                product.setcount(product.getcount()-a.get(i).getcount());
                                fridge.delete(a.get(i),product);
                                System.out.print("                                                   The product is Deleted Successfully!!!");
                                bool=true;
                            }
                            else 
                            System.out.println("                                               Enter the Valid Number!!!");
                        }
                    }
                }
                f=true;
            }
            else{
                System.out.println("                                                 Enter the Valid Number");
            }
        }
    }


    public void WashingMachine(products product,user data){
        WashingDAO washing = new WashingDAO(product.getproductname());
        Washingview wash = new Washingview();
        ArrayList<Washing> a = washing.admindisplay();
        wash.display(a);
        boolean f=false;
        while(!f){
            int choice = wash.updateordelete();
            if(choice == 1)
            {
                Resource.Washing up = wash.updatewash();
                boolean found = false;
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(up.getbrand())) && (a.get(i).getmodel().equals(up.getmodel()))){
                        int count = wash.ordercount();
                        up.setcount(count);
                        washing.adminupdate(up,product,a.get(i).getcount());
                        a.get(i).setcount(a.get(i).getcount()+count);
                        found=true;
                        System.out.print("                                     Product is Successfully Updated!!!");
                    }
                }
                if(!found)
                {
                    up = wash.newupdate(up);
                    int count = wash.ordercount();
                    up.setcount(count); 
                    washing.adminupdatenew(up,product,count);
                    System.out.print("                                          Product is Successfully Added!!!");
                }
                f=true;
            }
            else if(choice == 2)
            {
                Resource.Washing del= wash.deletewash();
                for(int i=0;i<a.size();i++)
                {
                    if((a.get(i).getbrand().equals(del.getbrand())) && (a.get(i).getmodel().equals(del.getmodel())))
                    {
                        boolean bool=false;
                        while(!bool)
                        {
                            int n=wash.deleteview();
                            if(n==1){
                                boolean s=false;
                                while(!s){
                                    int c = wash.deletecount();
                                    int totcount = a.get(i).getcount();
                                    if(totcount>=c && c>=0)
                                    {
                                        a.get(i).setcount(totcount-c);
                                        product.setcount(product.getcount()-c);
                                        washing.deletecount(a.get(i),product);
                                        s=true;
                                        System.out.print("The Count of the product is Reduced Successfully!!!");
                                    }
                                    else 
                                    System.out.println("                                               Enter the Proper Count The Entered count is greater than existing count!!!");
                                }
                                bool=true;
                            }
                            else if(n==2){
                                product.setcount(product.getcount()-a.get(i).getcount());
                                washing.delete(a.get(i),product);
                                System.out.print("                                                   The product is Deleted Successfully!!!");
                                bool=true;
                            }
                            else 
                            System.out.println("                                               Enter the Valid Number!!!");
                        }
                    }
                }
                f=true;
            }
            else{
                System.out.println("                                                 Enter the Valid Number");
            }
        }
    }
}