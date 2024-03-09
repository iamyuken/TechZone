package Resource;

public class Washing {
    private int id;
    private String brand;
    private String model;
    private String washingcapacity;
    private int price;
    private int count;

    
    public Washing(int id,String brand, String model, String washingcapacity, int price, int count) {
        this.id=id;
        this.brand = brand;
        this.model = model;
        this.washingcapacity = washingcapacity;
        this.price = price;
        this.count = count;
    }

    public Washing(){
        
    }
    
    public int getid() {
        return id;
    }


    public void setid(int id) {
        this.id = id;
    }

    public String getbrand() {
        return brand;
    }


    public void setbrand(String brandname) {
        this.brand = brandname;
    }


    public String getmodel() {
        return model;
    }


    public void setmodel(String model) {
        this.model = model;
    }


    public String getwashingcapacity() {
        return washingcapacity;
    }


    public void setwashingcapacity(String washingcapacity) {
        this.washingcapacity = washingcapacity;
    }


    public int getprice() {
        return price;
    }


    public void setprice(int price) {
        this.price = price;
    }

    public int getcount() {
        return count;
    }


    public void setcount(int count) {
        this.count = count;
    }

}
