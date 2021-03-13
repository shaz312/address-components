package test;

import java.util.*;
import testLibrary.AddressUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tauren on 3/21/15.
 */
public class Application {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
        List<String> test_address = new ArrayList<String>();
        String text_address=input.nextLine();
        
        test_address.add(new String(text_address));
       // test_address.add("No 40, Jalan Impian Setia 1 Saujana Impian 01000 Melaka");
       // test_address.add("NO 56, Jalan Nelayan 19/B, Seksyen 19, 40300 Shah Alam, Selangor");

        AddressUtility addressUtility = new AddressUtility();

        for (String addr : test_address) {
            System.out.println("New Address String:" + addr);
            AddressParser parser = new AddressParser(addr, addressUtility);
            parser.preParseAddress();
            System.out.println("\n");
        }
    }
}
