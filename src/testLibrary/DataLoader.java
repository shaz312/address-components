package testLibrary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;


public class DataLoader {

    private HashMap STATE_MAP;
    private String STATE_REGEX;


    public DataLoader() {
        STATE_MAP = new HashMap();
        this.import_states_data();
    }

    /**
     * Read in state file and create:
     * 1. State Abrv Hashmap for quick state lookup
     * 2. State Regex for searching for states.
     */
    private void import_states_data() {
        System.out.println(System.getProperty("java.class.path"));
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            DataLoader.class.getResourceAsStream("state_address.txt")
                    ));

            String line;
            String[] lineItems;
            while((line = reader.readLine()) != null) {
                lineItems = line.split(":");
                if (lineItems[0].length() == 3) {
                    this.STATE_MAP.put(lineItems[0], lineItems[0]);
                    STATE_MAP.put(lineItems[1], lineItems[0]);
                }
            }

            StringBuilder sb = new StringBuilder();
            Iterator it = STATE_MAP.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                sb.append(pair.getKey());
                if (it.hasNext()) {sb.append("|");}
                it.remove();
            }

            this.STATE_REGEX = "(" + sb.toString() + ")";


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public HashMap getSTATE_MAP() {
        return STATE_MAP;
    }

    public String getSTATE_REGEX() {
        return STATE_REGEX;
    }
}