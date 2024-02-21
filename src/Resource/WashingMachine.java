package Resource;

public class WashingMachine {
    private String brandname;
    private String model;
    private String washingcapacity;
    private int price;
    private int count;

    
    public WashingMachine(String brandname, String model, String washingcapacity, int price, int count) {
        this.brandname = brandname;
        this.model = model;
        this.washingcapacity = washingcapacity;
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


    public String getWashingcapacity() {
        return washingcapacity;
    }


    public void setWashingcapacity(String washingcapacity) {
        this.washingcapacity = washingcapacity;
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
