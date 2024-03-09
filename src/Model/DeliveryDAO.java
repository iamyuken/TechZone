package Model;

import java.sql.*;

import Resource.Delivery;

public class DeliveryDAO {
    
    public PreparedStatement pst,ps,p;
    public DeliveryDAO()
    {
        try{
            pst = DBConnection.getConnection().prepareStatement("select * from delivery_details where User_ID = ?");
            ps  = DBConnection.getConnection().prepareStatement("Insert into delivery_details(User_ID,Mobile_Number,Address,City) Values(?,?,?,?)");
            p = DBConnection.getConnection().prepareStatement("Update delivery_details set Mobile_Number = ?,Address=?,City=? where User_ID=?");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Delivery isdelivery(int id)
    {
        Delivery d = new Delivery();
        try{
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                d.setSno(rs.getInt(1));
                d.setUserid(id);
                d.setMobilenumber(rs.getString(3));
                d.setAddress(rs.getString(4));
                d.setCity(rs.getString(5));
            }
            else
            {
                d.setSno(0);
                d.setUserid(id);
                d.setMobilenumber(null);
                d.setAddress(null);
                d.setCity(null);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return d;
    }

    public void delivery(Delivery details)
    {
        try{
            ps.setInt(1,details.getUserid());
            ps.setString(2,details.getMobilenumber());
            ps.setString(3,details.getAddress());
            ps.setString(4,details.getCity());
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updatedelivery(Delivery details)
    {
        try{
            p.setString(1,details.getMobilenumber());
            p.setString(2,details.getAddress());
            p.setString(3,details.getCity());
            p.setInt(4,details.getUserid());
            p.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
