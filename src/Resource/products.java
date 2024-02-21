package Resource;

public class products {
    
    private static int id;
    private static String productname;
    private static int count;

    products(int Id,String Productname,int Count){
        id=Id;
        productname=Productname;
        count=Count;
    }

    public static int getid(){
        return id;
    }

    public static String getproductname(){
        return productname;
    }

    public static int getcount(){
        return count;
    }

    public static void setid(int Id){
        id=Id;
    }

    public static void setproductname(String Name){
        productname = Name;
    }

    public static void setcount(int Count){
        count=Count;
    }
}
