package Resource;

public class products {
    
    private int id;
    private String productname;
    private int count;

    public products(int Id,String Productname,int Count){
        id=Id;
        productname=Productname;
        count=Count;
    }

    public products(){
            
    }

    public int getid(){
        return id;
    }

    public String getproductname(){
        return productname;
    }

    public int getcount(){
        return count;
    }

    public void setid(int Id){
        id=Id;
    }

    public void setproductname(String Name){
        productname = Name;
    }

    public void setcount(int Count){
        count=Count;
    }
}
