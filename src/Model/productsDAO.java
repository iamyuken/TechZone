package Model;

import java.sql.*;
import java.util.ArrayList;

public class productsDAO {
    
    public ArrayList<ArrayList<String>> ar = new ArrayList<>();

    PreparedStatement pst;
    Statement st;
    public productsDAO()
    {
        try{
            st = DBConnection.getConnection().createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public ArrayList<ArrayList<String>> product()
    {
        try{
            ResultSet rs = st.executeQuery("select * from products");
            while(rs.next())
            {
                ArrayList<String> br = new ArrayList<String>();
                br.add(String.valueOf(rs.getInt(1)));
                br.add(rs.getString(2));
                br.add(String.valueOf(rs.getInt(3)));
                ar.add(br);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ar;
    }
}
