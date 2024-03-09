package Resource;

public class Fridge {
    private int id;
    private String brandname;
    private String model;
    private String capacity;
    private String  doortype;
    private int price;
    private int count;


    public Fridge(int id,String brandname, String model, String capacity, String doortype, int price, int count) {
        this.id=id;
        this.brandname = brandname;
        this.model = model;
        this.capacity = capacity;
        this.doortype = doortype;
        this.price = price;
        this.count = count;
    }

    public Fridge(){

    }
    
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getbrand() {
        return brandname;
    }
    public void setbrand(String brandname) {
        this.brandname = brandname;
    }
    public String getmodel() {
        return model;
    }
    public void setmodel(String model) {
        this.model = model;
    }
    public String getcapacity() {
        return capacity;
    }
    public void setcapacity(String capacity) {
        this.capacity = capacity;
    }
    public String getdoortype() {
        return doortype;
    }
    public void setdoortype(String doortype) {
        this.doortype = doortype;
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
