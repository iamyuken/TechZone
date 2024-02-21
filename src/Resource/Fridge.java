package Resource;

public class Fridge {
    private String brandname;
    private String model;
    private String capacity;
    private String  doortype;
    private int price;
    private int count;


    public Fridge(String brandname, String model, String capacity, String doortype, int price, int count) {
        this.brandname = brandname;
        this.model = model;
        this.capacity = capacity;
        this.doortype = doortype;
        this.price = price;
        this.count = count;
    }

    
    public String getBrandname() {
        return brandname;
    }
    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public String getDoortype() {
        return doortype;
    }
    public void setDoortype(String doortype) {
        this.doortype = doortype;
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
