package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/Shopping";
    private static String name = "root";
    private static String password = "#Yukendran@2004&09";
    private static Connection con=null;
    public static Connection getConnection() 
    {
        if(con==null){
            try{
                con = DriverManager.getConnection(url,name,password);
            }
            catch(Exception e){
                System.out.print("      OOPS!!!   Connection ERROR");
                e.printStackTrace();
            }
        }
        return con;
    } 
}
