package Model;
import java.sql.*;
import Resource.*;

public class PurchaseddetailsDAO {
    
    PreparedStatement pst;

    public PurchaseddetailsDAO(){
        try{
            pst = DBConnection.getConnection().prepareStatement("Insert into purchased_details Values(?,?,?,?,?,?,?,?,?)");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void purchase(purchase p)
    {
        try{
            pst.setInt(1, p.getUserid());
            pst.setString(2, p.getProductname());
            pst.setString(3, p.getBrand());
            pst.setString(4, p.getModel());
            pst.setInt(5, p.getPrice());
            pst.setString(6, p.getDate());
            pst.setInt(7, p.getCount());
            pst.setString(8, p.getPayment());
            pst.setString(9, p.getPaymenttype());
            pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
