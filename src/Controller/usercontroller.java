package Controller;

import java.util.*;
import Model.productsDAO;
import View.productsview;

public class usercontroller {
    
    public void productsinfo()
    {
        productsDAO  p = new productsDAO();
        productsview view = new productsview();
        ArrayList<ArrayList<String>> a = p.product();
        view.display(a);
        int n = view.selectproduct();
        if(n==1){

        }
    }

    public void TV()
    {

    }

    public void 

}
