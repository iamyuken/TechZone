package Resource;

public class Delivery {
    private int sno;
    private int userid;
    private String mobilenumber;
    private String address;
    private String city;


    

    public Delivery(int sno, int userid, String mobilenumber, String address, String city) {
        this.sno = sno;
        this.userid = userid;
        this.mobilenumber = mobilenumber;
        this.address = address;
        this.city = city;
    }
    
    public Delivery(int userid, String mobilenumber, String address, String city) {
        this.userid = userid;
        this.mobilenumber = mobilenumber;
        this.address = address;
        this.city = city;
    }

    public Delivery()
    {

    }
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
}
