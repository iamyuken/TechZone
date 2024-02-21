package View;

import java.util.*;
public class scanner {

    private static Scanner sc=null;

    public static Scanner scan()
    {
        if(sc==null)
        sc=new Scanner(System.in);
        return sc;
    }
}
