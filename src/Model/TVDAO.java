package Model;

import java.sql.*;
import java.util.*;

import Resource.*;
public class TVDAO {
    
    Statement st;
    PreparedStatement pst,ps,p,upst,uppst,newpst,dele;
    public TVDAO(String tablename){
        try{
            st = DBConnection.getConnection().createStatement();
            pst = DBConnection.getConnection().prepareStatement("select * from TV where ID = ?");
            ps = DBConnection.getConnection().prepareStatement("update products set Count = ? where Product_Name=?");
            p = DBConnection.getConnection().prepareStatement("update "+tablename+" set Count = ? where ID = ?");
            uppst = DBConnection.getConnection().prepareStatement("update products set count = ? where product_name=?");
            upst = DBConnection.getConnection().prepareStatement("Update TV set Count = ? where Brand_Name = ? and Model = ?");
            newpst = DBConnection.getConnection().prepareStatement("Insert into TV (Brand_name,Model,Display_size,Price,Count) Values(?,?,?,?,?)");
            dele = DBConnection.getConnection().prepareStatement("Delete from TV where Brand_name = ? and Model = ?");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<TV> userdisplay()
    {
        ArrayList<TV> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from TV where Count>0");
            while(rs.next()){
                a.add(new TV(rs.getInt(6),rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }


    public void reducecount(int count,products product,TV details)
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

    public ArrayList<TV> admindisplay()
    {
        ArrayList<TV> a = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("select * from TV");
            while(rs.next()){
                a.add(new TV(rs.getInt(6),rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
    public void adminupdate(TV up,products product,int totcount){
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

    public void adminupdatenew(TV up,products product,int count){
        try{
            uppst.setInt(1,product.getcount()+count);
            uppst.setString(2,product.getproductname());
            uppst.executeUpdate();

            product.setcount(product.getcount()+count);
            
            newpst.setString(1,up.getbrand());
            newpst.setString(2, up.getmodel());
            newpst.setString(3,up.getdisplaysize());
            newpst.setInt(4,up.getprice());
            newpst.setInt(5,up.getcount());
            newpst.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletecount(TV del,products product)
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
    
    public void delete(TV del,products product)
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
