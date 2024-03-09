package Resource;

public class Mobiles {
    private int id;
    private String brand;
    private String model;
    private String ram;
    private String storage;
    private String simtype;
    private String cellulartechnology;
    private int price;
    private int count;


    public Mobiles(int id,String brand, String model, String ram, String storage, String simtype, String cellulartechnology,int price, int count) {
        this.id=id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.simtype = simtype;
        this.cellulartechnology = cellulartechnology;
        this.price = price;
        this.count = count;
    }

    public Mobiles(){
        
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
    public void setbrand(String brand) {
        this.brand = brand;
    }
    public String getmodel() {
        return model;
    }
    public void setmodel(String model) {
        this.model = model;
    }
    public String getram() {
        return ram;
    }
    public void setram(String ram) {
        this.ram = ram;
    }
    public String getstorage() {
        return storage;
    }
    public void setstorage(String storage) {
        this.storage = storage;
    }
    public String getsimtype() {
        return simtype;
    }
    public void setsimtype(String simtype) {
        this.simtype = simtype;
    }
    public String getcellulartechnology() {
        return cellulartechnology;
    }
    public void setcellulartechnology(String cellulartechnology) {
        this.cellulartechnology = cellulartechnology;
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
