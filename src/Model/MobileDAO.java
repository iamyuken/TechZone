package Model;

import java.sql.*;
import java.util.*;

import Resource.Mobiles;
import Resource.products;

public class MobileDAO {
    
    Statement st;
    PreparedStatement pst,ps,p,uppst,upst,newpst,dele;
    public MobileDAO(String tablename){
        try{
            st = DBConnection.getConnection().createStatement();
            pst = DBConnection.getConnection().prepareStatement("select * from mobiles where ID = ?");
            ps = DBConnection.getConnection().prepareStatement("update products set Count = ? where Product_Name=?");
            p = DBConnection.getConnection().prepareStatement("update "+tablename+" set Count = ? where ID = ?");
            uppst = DBConnection.getConnection().prepareStatement("update products set count = ? where product_name=?");
            upst = DBConnection.getConnection().prepareStatement("Update mobiles set Count = ? where Brand_Name = ? and Model = ?");
            newpst = DBConnection.getConnection().prepareStatement("Insert into mobiles (Brand_name,Model,RAM,Storage,sim_type,Cellular_technology,Price,Count) Values(?,?,?,?,?,?,?,?)");
            dele = DBConnection.getConnection().prepareStatement("Delete from mobiles where Brand_name = ? and Model = ?");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Mobiles> userdisplay()
    {
        ArrayList<Mobiles> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from mobiles where Count>0");
            while(rs.next()){
                a.add(new Mobiles(rs.getInt(9),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void reducecount(int count,products product,Mobiles details)
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

    public ArrayList<Mobiles> admindisplay()
    {
        ArrayList<Mobiles> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from Mobiles");
            while(rs.next()){
                a.add(new Mobiles(rs.getInt(9),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void adminupdate(Mobiles up,products product,int totcount){
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

    public void adminupdatenew(Mobiles up,products product,int count){
        try{
            uppst.setInt(1,product.getcount()+count);
            uppst.setString(2,product.getproductname());
            uppst.executeUpdate();

            product.setcount(product.getcount()+count);
            
            newpst.setString(1,up.getbrand());
            newpst.setString(2, up.getmodel());
            newpst.setString(3,up.getram());
            newpst.setString(4,up.getstorage());
            newpst.setString(5,up.getsimtype());
            newpst.setString(6,up.getcellulartechnology());
            newpst.setInt(7,up.getprice());
            newpst.setInt(8,up.getcount());
            newpst.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletecount(Mobiles del,products product)
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

    public void delete(Mobiles del,products product)
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
