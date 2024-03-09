package Resource;

public class purchase {
    private int userid;
    private String productname;
    private String brand;
    private String model;
    private int price;
    private String date;
    private int count;
    private String payment;
    private String paymenttype;


    public purchase(int userid, String productname, String brand, String model, int price, String date, int count,String payment, String paymenttype) {
        this.userid = userid;
        this.productname = productname;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.date = date;
        this.count = count;
        this.payment = payment;
        this.paymenttype = paymenttype;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    
}
