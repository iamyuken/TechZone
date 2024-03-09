package Model;

import java.sql.*;
import java.util.*;

import Resource.Fridge;
import Resource.products;

public class FridgeDAO {
    
    Statement st;
    PreparedStatement pst,ps,p,uppst,upst,newpst,dele;
    public FridgeDAO(String tablename){
        try{
            st = DBConnection.getConnection().createStatement();
            pst = DBConnection.getConnection().prepareStatement("select * from fridge where ID = ?");
            ps = DBConnection.getConnection().prepareStatement("update products set Count = ? where Product_Name=?");
            p = DBConnection.getConnection().prepareStatement("update "+tablename+" set Count = ? where ID = ?");
            uppst = DBConnection.getConnection().prepareStatement("update products set count = ? where product_name=?");
            upst = DBConnection.getConnection().prepareStatement("Update fridge set Count = ? where Brand_Name = ? and Model = ?");
            newpst = DBConnection.getConnection().prepareStatement("Insert into fridge (Brand_name,Model,Capacity,Door_type,Price,Count) Values(?,?,?,?,?,?)");
            dele = DBConnection.getConnection().prepareStatement("Delete from fridge where Brand_name = ? and Model = ?");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Fridge> userdisplay()
    {
        ArrayList<Fridge> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from fridge where Count>0");
            while(rs.next()){
                a.add(new Fridge(rs.getInt(7),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void reducecount(int count,products product,Fridge details)
    {
        try{
            ps.setInt(1,product.getcount()-count);
            ps.setString(2, product.getproductname());
            ps.executeUpdate();

            p.setInt(1,details.getcount()-count);
            p.setInt(2,details.getid());
            p.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Fridge> admindisplay()
    {
        ArrayList<Fridge> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from Fridge");
            while(rs.next()){
                a.add(new Fridge(rs.getInt(7),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void adminupdate(Fridge up,products product,int totcount){
        try{
            uppst.setInt(1,product.getcount()+up.getcount());
            uppst.setString(2,product.getproductname());
            uppst.executeUpdate();
            
            upst.setInt(1,totcount+up.getcount());
            upst.setString(2, up.getbrand());
            upst.setString(3, up.getmodel());
            upst.executeUpdate();

            up.setcount(totcount+up.getcount());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void adminupdatenew(Fridge up,products product,int count){
        try{
            uppst.setInt(1,product.getcount()+count);
            uppst.setString(2,product.getproductname());
            uppst.executeUpdate();

            product.setcount(product.getcount()+count);
            
            newpst.setString(1,up.getbrand());
            newpst.setString(2, up.getmodel());
            newpst.setString(3,up.getcapacity());
            newpst.setString(4,up.getdoortype());
            newpst.setInt(5,up.getprice());
            newpst.setInt(6,up.getcount());
            newpst.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletecount(Fridge del,products product)
    {
        try{
            uppst.setInt(1,product.getcount());
            uppst.setString(2,product.getproductname());
            uppst.executeUpdate();

            upst.setInt(1,del.getcount());
            upst.setString(2,del.getbrand());
            upst.setString(3,del.getmodel());
            upst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Fridge del,products product)
    {
        try{
            uppst.setInt(1,product.getcount());
            uppst.setString(2,product.getproductname());
            uppst.executeUpdate();
    
            dele.setString(1,del.getbrand());
            dele.setString(2, del.getmodel());
            dele.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
