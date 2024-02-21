package Controller;

import java.util.*;
import Model.productsDAO;
import Resource.products;
import View.productsview;

public class usercontroller {
    
    public void productsinfo()
    {
        productsDAO  p = new productsDAO();
        productsview view = new productsview();
        ArrayList<products> a = p.product();
        view.display(a);
        selectproduct();
    }
    
    public void selectproduct(){
        productsDAO  p = new productsDAO();
        productsview view = new productsview();
        int n = view.selectproduct();
        if(n==1){
            products product = p.selectproduct(n);
            TV(product);
        }
        else if(n==2){
            products product = p.selectproduct(n);
            Laptop(product);
        }
        else if(n==3){
            products product = p.selectproduct(n);
            Mobiles(product);
        }
        else if(n==4){
            products product = p.selectproduct(n);
            Fridge(product);
        }
        else if(n==5){
            products product = p.selectproduct(n);
            WashingMachine(product);
        }
        else{
            System.out.println("                                              Please Enter the Proper Number");
            selectproduct();
        }
        
    }


    public void TV(products product)
    {
        
    }

    public void  Laptop(products product){

    }

    public void Mobiles(products product){

    }

    public void Fridge(products product){

    }

    public void WashingMachine(products product){

    }
}
