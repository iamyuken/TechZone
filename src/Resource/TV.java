package Resource;

public class TV {
    
    private String brand;
    private String model;
    private String displaysize;
    private int price;
    private int count;


    public TV(String Brand,String Model,String Displaysize,int Price,int Count){
        brand=Brand;
        model=Model;
        displaysize=Displaysize;
        price=Price;
        count=Count;
    }

    public String getbrand(){
        return brand;
    }

    public String getmodel(){
        return model;
    }

    public String getdisplaysize(){
        return displaysize;
    }

    public int getprice(){
        return price;
    }

    public int getcount(){
        return count;
    }

    public void setbrand(String Brand){
        brand = Brand;
    }

    public void setmodel(String Model){
        model = Model;
    }

    public void setdisplaysize(String Displaysize){
        displaysize = Displaysize;
    }

    public void setprice(int Price){
        price = Price;
    }

    public void setcount(int Count){
        count = Count;
    }
}
