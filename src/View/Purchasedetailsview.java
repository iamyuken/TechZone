package View;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Purchasedetailsview {
    
    public Scanner sc = scanner.scan();
    public int choice()
    {
        System.out.println("                                        Enter 1 to Pay by UPI");
        System.out.println("                                        Enter 2 to Pay by DebitCard");
        System.out.println("                                        Enter 3 to Pay by CreditCard");
        int k = 0;
        try{
            k=sc.nextInt();
        }
        catch(Exception e){
            System.out.print("Enter a Valid Number");
            choice();
        }
        return k;
    }

    public String date()
    {
        DateTimeFormatter dat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dat.format(now);
    }
}
