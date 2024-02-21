package Resource;

public class Mobiles {
    private String brand;
    private String model;
    private String ram;
    private String storage;
    private String simtype;
    private String cellulartechnology;
    private int price;
    private int count;


    public Mobiles(String brand, String model, String ram, String storage, String simtype, String cellulartechnology,int price, int count) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.simtype = simtype;
        this.cellulartechnology = cellulartechnology;
        this.price = price;
        this.count = count;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getRam() {
        return ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }
    public String getStorage() {
        return storage;
    }
    public void setStorage(String storage) {
        this.storage = storage;
    }
    public String getSimtype() {
        return simtype;
    }
    public void setSimtype(String simtype) {
        this.simtype = simtype;
    }
    public String getCellulartechnology() {
        return cellulartechnology;
    }
    public void setCellulartechnology(String cellulartechnology) {
        this.cellulartechnology = cellulartechnology;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    
}
