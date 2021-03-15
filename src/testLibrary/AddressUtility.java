package testLibrary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;


public class AddressUtility {

    // Regex
	//regular expression 01000-98859
    private Pattern zipRegex = Pattern.compile("(0[123456789][0-9]{3})|[1-8][0-9]{4}|(9[0-8][0-8][0-5][0-9])");
    //regular expression No/no12345
    private Pattern numRegex = Pattern.compile("([nN][Oo]\\s(\\d+))|([nN][Oo](\\d+))");
    //regular expression street only Jalan 
    private Pattern streetRegex = Pattern.compile("([jJ][aA][lL][aA][nN]\\s(\\w+))");
    //
    private Pattern cityRegex = Pattern.compile("\\s(\\w+)$");
    
    private Pattern stateRegex;

    //access by index of string
    private HashMap state_map;

    /**
     * Load in data from files/static input.
     */
    public AddressUtility() {
        DataLoader addressData = new DataLoader();
        this.stateRegex = Pattern.compile(addressData.getSTATE_REGEX());
        this.state_map = addressData.getSTATE_MAP();
    }

    public Pattern getZipRegex() {
        return zipRegex;
    }

    public Pattern getNumRegex() {
        return numRegex;
    }
    
    public Pattern getStreetRegex() {
        return streetRegex;
    }

    public Pattern getCityRegex() {
        return cityRegex;
    }

    public Pattern getStateRegex() {
        return stateRegex;
    }

    public HashMap getState_map() {
        return state_map;
    }


}
