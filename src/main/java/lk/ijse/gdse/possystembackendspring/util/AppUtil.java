package lk.ijse.gdse.possystembackendspring.util;

import java.util.UUID;

public class AppUtil {
    public static String CreateCustomerId(){
        return "CUSTOMER : " + UUID.randomUUID();
    }
    public static String CreateItemCode(){
        return "ITEM : " + UUID.randomUUID();
    }
}
