package Controller;

import java.util.*;
import Model.*;
import Resource.*;
import View.*;

public class usercontroller {
    
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
    
    
    public void  TV(products product,user data){
        TVDAO tv = new TVDAO(product.getproductname());
        TVview t = new TVview();
        DeliveryDAO deli = new DeliveryDAO();
        Deliveryview view = new Deliveryview();
        PurchaseddetailsDAO purchase = new PurchaseddetailsDAO();
        ArrayList<TV> a = tv.userdisplay();
        t.display(a);
        int id = t.orderid(),count=0;
        boolean found=false;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getid() == id)
            {
                found=true;
                
                TV iddetails = new TV();
                iddetails.setid(a.get(i).getid());
                iddetails.setbrand(a.get(i).getbrand());
                iddetails.setmodel(a.get(i).getmodel());
                iddetails.setdisplaysize(a.get(i).getdisplaysize());
                iddetails.setprice(a.get(i).getprice());
                iddetails.setcount(a.get(i).getcount());

                count=tvcount(a,id);
                Delivery d = deli.isdelivery(data.getid());
                if(d.getSno()==0){
                    Delivery details = view.newdelivery(data.getid());
                    deli.delivery(details);
                }
                else{
                    int choice=view.updelivery();
                    if(choice==1)
                    {
                        Delivery details = view.newdelivery(id);
                        deli.updatedelivery(details);
                    }
                }
                purchase p=tvpurch(product,data,iddetails, id,count);
                purchase.purchase(p);
                tv.reducecount(count,product,iddetails);
                System.out.println("                                      The ORDER was Completed SUCCESSFULLY!!!");
                int ch = t.reorder();
                if(ch==1)
                {
                    productsinfo(data);
                }
                else if(ch==2){
                    return;
                }
            }
        }
        if(!found)
        { 
            System.out.println("                                        Please See the Details Properly and Enter the Given Valid ID");
            TV(product,data);
        }
    }
    
    public int tvcount(ArrayList<TV> a, int id) {
        TVview tvView = new TVview();
        int availableStock = 0;
        
        for (TV tv : a) {
            if (tv.getid() == id) {
                availableStock = tv.getcount();
                break;
            }
        }
        while (true) {
            int count = tvView.ordercount();
            if (count <= availableStock) {
                return count; 
            } else {
                System.out.println("                                Sorry, we do not have enough stock. Available stock: " + availableStock);
            }
        }
    }
    
    public purchase tvpurch(products product,user data,TV iddetails,int id,int count)
    {
        Purchasedetailsview purview = new Purchasedetailsview();
        int pay = purview.choice();
        String date = purview.date();
        purchase p=null;
        if(pay==1)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "UPI");
        }
        else if(pay==2)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Debit Card");
        }
        else if(pay==3)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Credit Card");
        }
        else{ 
            System.out.println("                                                Please Enter a Valid Number");
            tvpurch(product, data, iddetails, id, count);
        }
        return p;
    }
    


    
    public void  Laptop(products product,user data){
        LaptopDAO laptop = new LaptopDAO(product.getproductname());
        Laptopview lap = new Laptopview();
        DeliveryDAO deli = new DeliveryDAO();
        Deliveryview view = new Deliveryview();
        PurchaseddetailsDAO purchase = new PurchaseddetailsDAO();
        ArrayList<Laptop> a = laptop.userdisplay();
        lap.display(a);
        int id = lap.orderid(),count=0;
        boolean found=false;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getid()==id)
            {
                found=true;
                Laptop iddetails = new Laptop();
                iddetails.setid(a.get(i).getid());
                iddetails.setbrand(a.get(i).getbrand());
                iddetails.setmodel(a.get(i).getmodel());
                iddetails.setprocessor(a.get(i).getprocessor());
                iddetails.setram(a.get(i).getram());
                iddetails.setstorage(a.get(i).getstorage());
                iddetails.setgeneration(a.get(i).getgeneration());
                iddetails.setwindows(a.get(i).getwindows());
                iddetails.setprice(a.get(i).getprice());
                iddetails.setcount(a.get(i).getcount());

                count=lapcount(a,id);
                
                Delivery d = deli.isdelivery(data.getid());
                if(d.getSno()==0){
                    Delivery details = view.newdelivery(data.getid());
                    deli.delivery(details);
                }
                else{
                    int choice=view.updelivery();
                    if(choice==1)
                    {
                        Delivery details = view.newdelivery(id);
                        deli.updatedelivery(details);
                    }
                }
                purchase p=lappurch(product, data, iddetails, id,count);
                purchase.purchase(p);
                
                laptop.reducecount(count,product,iddetails);
                System.out.println("                                      The ORDER was Completed SUCCESSFULLY!!!");
                int ch = lap.reorder();
                if(ch==1)
                {
                    productsinfo(data);
                }
                else if(ch==2){
                    return;
                }
            }
        }
        if(!found)
        {
            System.out.println("                                      Please See the Details Properly and Enter the Given Valid ID");
            Laptop(product, data);
        }
    }
    
    public int lapcount(ArrayList<Laptop> laptops, int id) {
        Laptopview lapView = new Laptopview();
        int availableStock = 0;
        
        for (Laptop laptop : laptops) {
            if (laptop.getid() == id) {
                availableStock = laptop.getcount();
                break;
            }
        }
        while (true) {
            int count = lapView.ordercount();
            if (count <= availableStock) {
                return count; 
            } else {
                System.out.println("                                         Sorry, we do not have enough stock. Available stock: " + availableStock);
            }
        }
    }
    
    public purchase lappurch(products product,user data,Laptop iddetails,int id,int count)
    {
        Purchasedetailsview purview = new Purchasedetailsview();
        int pay = purview.choice();
        String date = purview.date();
        purchase p=null;
        if(pay==1)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "UPI");

        }
        else if(pay==2)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Debit Card");
        }
        else if(pay==3)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Credit Card");
        }
        else{ 
            System.out.println("                                                Please Enter a Valid Number");
            lappurch(product, data, iddetails, id, count);
        }
        return p;
    }

    public void Mobiles(products product,user data){
        MobileDAO mobile = new MobileDAO(product.getproductname());
        Mobileview mob = new Mobileview();
        DeliveryDAO deli = new DeliveryDAO();
        Deliveryview view = new Deliveryview();
        PurchaseddetailsDAO purchase = new PurchaseddetailsDAO();
        ArrayList<Mobiles> a = mobile.userdisplay();
        mob.display(a);
        int id = mob.orderid(),count=0;
        boolean found=false;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getid()==id)
            {
                found=true;
                Mobiles iddetails = new Mobiles();
                iddetails.setid(a.get(i).getid());
                iddetails.setbrand(a.get(i).getbrand());
                iddetails.setmodel(a.get(i).getmodel());
                iddetails.setram(a.get(i).getram());
                iddetails.setstorage(a.get(i).getstorage());
                iddetails.setsimtype(a.get(i).getsimtype());
                iddetails.setcellulartechnology(a.get(i).getcellulartechnology());
                iddetails.setprice(a.get(i).getprice());
                iddetails.setcount(a.get(i).getcount());

                count=mobcount(a,id);
                
                Delivery d = deli.isdelivery(data.getid());
                if(d.getSno()==0){
                    Delivery details = view.newdelivery(data.getid());
                    deli.delivery(details);
                }
                else{
                    int choice=view.updelivery();
                    if(choice==1)
                    {
                        Delivery details = view.newdelivery(id);
                        deli.updatedelivery(details);
                    }
                }
                purchase p=mobpurch(product, data, iddetails, id,count);
                purchase.purchase(p);
                
                mobile.reducecount(count,product,iddetails);
                System.out.println("                                      The ORDER was Completed SUCCESSFULLY!!!");
                int ch = mob.reorder();
                if(ch==1)
                {
                    productsinfo(data);
                }
                else if(ch==2){
                    return;
                }
            }
        }
        if(!found)
        {
            System.out.println("                                       Please See the Details Properly and Enter the Given Valid ID");
            Mobiles(product, data);
        }
    }

    public purchase mobpurch(products product,user data,Mobiles iddetails,int id,int count)
    {
        Purchasedetailsview purview = new Purchasedetailsview();
        int pay = purview.choice();
        String date = purview.date();
        purchase p=null;
        if(pay==1)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "UPI");

        }
        else if(pay==2)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Debit Card");
        }
        else if(pay==3)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Credit Card");
        }
        else{ 
            System.out.println("                                                Please Enter a Valid Number");
            mobpurch(product, data, iddetails, id, count);
        }
        return p;
    }

    public int mobcount(ArrayList<Mobiles> mobiles, int id) {
        Mobileview mobView = new Mobileview();
        int availableStock = 0;
        
        for (Mobiles mobile : mobiles) {
            if (mobile.getid() == id) {
                availableStock = mobile.getcount();
                break;
            }
        }
        while (true) {
            int count = mobView.ordercount();
            if (count <= availableStock) {
                return count; 
            } else {
                System.out.println("                                          Sorry, we do not have enough stock. Available stock: " + availableStock);
            }
        }
    }

    public void Fridge(products product,user data){
        FridgeDAO fridge = new FridgeDAO(product.getproductname());
        Fridgeview fri = new Fridgeview();
        DeliveryDAO deli = new DeliveryDAO();
        Deliveryview view = new Deliveryview();
        PurchaseddetailsDAO purchase = new PurchaseddetailsDAO();
        ArrayList<Fridge> a = fridge.userdisplay();
        fri.display(a);
        int id = fri.orderid(),count=0;
        boolean found=false;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getid()==id)
            {
                found=true;
                Fridge iddetails = new Fridge();
                iddetails.setid(a.get(i).getid());
                iddetails.setbrand(a.get(i).getbrand());
                iddetails.setmodel(a.get(i).getmodel());
                iddetails.setcapacity(a.get(i).getcapacity());
                iddetails.setdoortype(a.get(i).getdoortype());
                iddetails.setprice(a.get(i).getprice());
                iddetails.setcount(a.get(i).getcount());

                count=fricount(a,id);
                
                Delivery d = deli.isdelivery(data.getid());
                if(d.getSno()==0){
                    Delivery details = view.newdelivery(data.getid());
                    deli.delivery(details);
                }
                else{
                    int choice=view.updelivery();
                    if(choice==1)
                    {
                        Delivery details = view.newdelivery(id);
                        deli.updatedelivery(details);
                    }
                }
                purchase p=fripurch(product, data, iddetails, id,count);
                purchase.purchase(p);
                
                fridge.reducecount(count,product,iddetails);
                System.out.println("                                      The ORDER was Completed SUCCESSFULLY!!!");
                int ch = fri.reorder();
                if(ch==1)
                {
                    productsinfo(data);
                }
                else if(ch==2){
                    return;
                }
            }
        }
        if(!found)
        {
            System.out.println("                                           Please See the Details Properly and Enter the Given Valid ID");
            Fridge(product, data);
        }
    }


    public int fricount(ArrayList<Fridge> fridge, int id) {
        Fridgeview friView = new Fridgeview();
        int availableStock = 0;
        
        for (Fridge fridg : fridge) {
            if (fridg.getid() == id) {
                availableStock = fridg.getcount();
                break;
            }
        }
        while (true) {
            int count = friView.ordercount();
            if (count <= availableStock) {
                return count; 
            } else {
                System.out.println("                                         Sorry, we do not have enough stock. Available stock: " + availableStock);
            }
        }
    }

    public purchase fripurch(products product,user data,Fridge iddetails,int id,int count)
    {
        Purchasedetailsview purview = new Purchasedetailsview();
        int pay = purview.choice();
        String date = purview.date();
        purchase p=null;
        if(pay==1)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "UPI");

        }
        else if(pay==2)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Debit Card");
        }
        else if(pay==3)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Credit Card");
        }
        else{ 
            System.out.println("                                                Please Enter a Valid Number");
            fripurch(product, data, iddetails, id, count);
        }
        return p;
    }

    public void WashingMachine(products product,user data){
        
        WashingDAO washing = new WashingDAO(product.getproductname());
        Washingview wash = new Washingview();
        DeliveryDAO deli = new DeliveryDAO();
        Deliveryview view = new Deliveryview();
        PurchaseddetailsDAO purchase = new PurchaseddetailsDAO();
        ArrayList<Washing> a = washing.userdisplay();
        wash.display(a);
        int id = wash.orderid(),count=0;
        boolean found=false;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getid()==id)
            {
                found=true;
                Washing iddetails = new Washing();
                iddetails.setid(a.get(i).getid());
                iddetails.setbrand(a.get(i).getbrand());
                iddetails.setmodel(a.get(i).getmodel());
                iddetails.setwashingcapacity(a.get(i).getwashingcapacity());
                iddetails.setprice(a.get(i).getprice());
                iddetails.setcount(a.get(i).getcount());

                count=washcount(a,id);
                
                Delivery d = deli.isdelivery(data.getid());
                if(d.getSno()==0){
                    Delivery details = view.newdelivery(data.getid());
                    deli.delivery(details);
                }
                else{
                    int choice=view.updelivery();
                    if(choice==1)
                    {
                        Delivery details = view.newdelivery(id);
                        deli.updatedelivery(details);
                    }
                }
                purchase p=washpurch(product, data, iddetails, id,count);
                purchase.purchase(p);
                
                washing.reducecount(count,product,iddetails);
                System.out.println("                                      The ORDER was Completed SUCCESSFULLY!!!");
                int ch = wash.reorder();
                if(ch==1)
                {
                    productsinfo(data);
                }
                else if(ch==2){
                    return;
                }
            }
        }
        if(!found)
        {
            System.out.println("                                                 Please See the Details Properly and Enter the Given Valid ID");
            WashingMachine(product, data);
        }
    }

    public int washcount(ArrayList<Washing> washing, int id) {
        Washingview washView = new Washingview();
        int availableStock = 0;
        
        for (Washing wash : washing) {
            if (wash.getid() == id) {
                availableStock = wash.getcount();
                break;
            }
        }
        while (true) {
            int count = washView.ordercount();
            if (count <= availableStock) {
                return count; 
            } else {
                System.out.println("                                        Sorry, we do not have enough stock. Available stock: " + availableStock);
            }
        }
    }

    public purchase washpurch(products product,user data,Washing iddetails,int id,int count)
    {
        Purchasedetailsview purview = new Purchasedetailsview();
        int pay = purview.choice();
        String date = purview.date();
        purchase p=null;
        if(pay==1)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "UPI");

        }
        else if(pay==2)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Debit Card");
        }
        else if(pay==3)
        {
            p = new purchase(data.getid(), product.getproductname(), iddetails.getbrand(), iddetails.getmodel(),iddetails.getprice()*count,date, count, "Yes", "Credit Card");
        }
        else{ 
            System.out.println("                                                Please Enter a Valid Number");
            washpurch(product, data, iddetails, id, count);
        }
        return p;
    }
}
