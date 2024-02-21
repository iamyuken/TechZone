package Resource;

public class Laptop {
    private String brand;
    private String model;
    private String processor;
    private String ram;
    private String storage;
    private String generation;
    private String windows;
    private int price;
    private int count;

    public Laptop(String brand, String model, String processor, String ram, String storage, String generation,String windows, int price, int count) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.generation = generation;
        this.windows = windows;
        this.price = price;
        this.count = count;
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
    public String getprocessor() {
        return processor;
    }
    public void setprocessor(String processor) {
        this.processor = processor;
    }
    public String getram() {
        return ram;
    }
    public void setram(String rAM) {
        this.ram = rAM;
    }
    public String getstorage() {
        return storage;
    }
    public void setstorage(String storage) {
        this.storage = storage;
    }
    public String getgeneration() {
        return generation;
    }
    public void setgeneration(String generation) {
        this.generation = generation;
    }
    public String getwindows() {
        return windows;
    }
    public void setwindows(String windows) {
        this.windows = windows;
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
