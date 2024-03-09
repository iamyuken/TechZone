package Model;

import java.sql.*;
import java.util.*;

import Resource.*;

public class LaptopDAO {
    
    Statement st;
    PreparedStatement pst,ps,p,uppst,upst,newpst,dele;
    public LaptopDAO(String tablename){
        try{
            st = DBConnection.getConnection().createStatement();
            pst = DBConnection.getConnection().prepareStatement("select * from laptop where ID = ?");
            ps = DBConnection.getConnection().prepareStatement("update products set Count = ? where Product_Name=?");
            p = DBConnection.getConnection().prepareStatement("update "+tablename+" set Count = ? where ID = ?");
            uppst = DBConnection.getConnection().prepareStatement("update products set count = ? where product_name=?");
            upst = DBConnection.getConnection().prepareStatement("Update laptop set Count = ? where Brand_Name = ? and Model = ?");
            newpst = DBConnection.getConnection().prepareStatement("Insert into laptop (Brand_name,Model,Processor,RAM,Storage,Generation,Windows,Price,Count) Values(?,?,?,?,?,?,?,?,?)");
            dele = DBConnection.getConnection().prepareStatement("Delete from Laptop where Brand_name = ? and Model = ?");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Laptop> userdisplay()
    {
        ArrayList<Laptop> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from laptop where Count>0");
            while(rs.next()){
                a.add(new Laptop(rs.getInt(10),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void reducecount(int count,products product,Laptop details)
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

    public ArrayList<Laptop> admindisplay()
    {
        ArrayList<Laptop> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from Laptop");
            while(rs.next()){
                a.add(new Laptop(rs.getInt(10),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void adminupdate(Laptop up,products product,int totcount){
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


    public void adminupdatenew(Laptop up,products product,int count){
        try{
            uppst.setInt(1,product.getcount()+count);
            uppst.setString(2,product.getproductname());
            uppst.executeUpdate();

            product.setcount(product.getcount()+count);
            
            newpst.setString(1,up.getbrand());
            newpst.setString(2, up.getmodel());
            newpst.setString(3,up.getprocessor());
            newpst.setString(4,up.getram());
            newpst.setString(5,up.getstorage());
            newpst.setString(6,up.getgeneration());
            newpst.setString(7,up.getwindows());
            newpst.setInt(8,up.getprice());
            newpst.setInt(9,up.getcount());
            newpst.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deletecount(Laptop del,products product)
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

    public void delete(Laptop del,products product)
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
