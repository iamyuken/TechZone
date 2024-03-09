package Model;

import java.sql.*;
import java.util.ArrayList;

import Resource.products;

public class productsDAO {
    
    public ArrayList<ArrayList<String>> ar = new ArrayList<>();

    PreparedStatement pst;
    Statement st;
    public productsDAO()
    {
        try{
            st = DBConnection.getConnection().createStatement();
            pst=DBConnection.getConnection().prepareStatement("select * from products where ID = ?");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public ArrayList<products> product()
    {
        ArrayList<products> br = new ArrayList<products>();
        try{
            ResultSet rs = st.executeQuery("select * from products");
            while(rs.next())
            {
                br.add(new products(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return br;
    }

    public products selectproduct(int n){
        products product = new products();
        try{
            pst.setInt(1,n);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                product.setid(rs.getInt(1));
                product.setproductname(rs.getString(2));
                product.setcount(rs.getInt(3));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return product;
    }
}
