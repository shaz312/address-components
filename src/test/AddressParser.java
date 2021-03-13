package test;

import testLibrary.AddressUtility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * AddressParser
 * extract number, state and postcode.

 */
public class AddressParser {

    private Address address;
    private AddressUtility addressUtilities;

    /**
     * Set standardsLibrary [only load it once, during startup as file IO is involved]
     * @param addrString
     */
    public AddressParser(String addrString, AddressUtility addressUtilities) {
        this.address = new Address(addrString);
        this.addressUtilities = addressUtilities;
    }

    /**
     * The number, state and postcode.
     * Other address elements [city and street] are a bit
     * more difficult to do with regex...
     */
    public void preParseAddress() {

        this.cleanseString(address.getAddressString());
        System.out.println("Cleansed: " + address.getAddressString());

        String addr = this.address.getAddressString();
        addr = extractPostCode(addr);
      
        addr = extractNumber(addr);

        addr = extractState(addr);
        
        addr = extractCity(addr);
        
        addr = extractStreet(addr);

    }

    /**
     * Convert string to uppercase,
     * Strip out commas, periods,
     * hyphens in between words.
     * and remove excess white space
     */
    public void cleanseString(String addressString) {
        String s = addressString.replaceAll("[,.]", "");
        s = s.toUpperCase();
        s = s.replaceAll(" - ", "-");
        s = s.replaceAll("\\s+", " ");
        this.address.setAddressString(s);
    }

    /**
     * Use postcode regex to find postcode in address string.
     * if found, remove postcode from the string and continue
     * @param addressString
     * @return
     */
    public String extractPostCode(String addressString) {

        Matcher m = addressUtilities.getZipRegex().matcher(addressString);

        if (m.find( )) {
            System.out.println("\tZip Match: <" + m.group(0) +">" );
            this.address.setPostCode(m.group(0).trim());
            addressString = addressString.replace(m.group(0), "");
        } else {
            System.out.println("\tZip Match: NO MATCH");
        }
        return addressString.trim();
    }

    /**
     * Use number regex to find number in address string.
     * If found, remove number from string,
     * set number in Address. and return new string without number.
     * @param addressString
     * @return
     */
    public String extractNumber(String addressString) {
        Matcher m = addressUtilities.getNumRegex().matcher(addressString);
        if (m.find( )) {
            System.out.println("\tNumber Match: <" + m.group(0) + ">");
            this.address.setNumber(m.group(0).trim());
            addressString = addressString.replace(m.group(0), "");
        } else {
            System.out.println("\tNumber Match: NO MATCH");
        }
        return addressString.trim();
    }

    public String extractState(String addressString) {
        Matcher m = addressUtilities.getStateRegex().matcher(addressString);
        if (m.find( )) {
            System.out.println("\tStates Match: <" + m.group(0) + ">");
            this.address.setState(m.group(0).trim());
            addressString = addressString.replace(m.group(0), "");
        } else {
            System.out.println("\tStates Match: NO MATCH");
        }
        return addressString.trim();
    }
    
    public String extractCity(String addressString) {
        Matcher m = addressUtilities.getCityRegex().matcher(addressString);
        if (m.find( )) {
            System.out.println("\tCity Match: <" + m.group(0) + ">");
            this.address.setCity(m.group(0).trim());
            addressString = addressString.replace(m.group(0), "");
        } else {
            System.out.println("\tCity Match: NO MATCH");
        }
        return addressString.trim();
    }
    
    /**
     * Use street regex to find street in address string.
     * If found, remove street from string,
     * set street in Address. and return new string without street.
     * @param addressString
     * @return
     */
    public String extractStreet(String addressString) {
        Matcher m = addressUtilities.getStreetRegex().matcher(addressString);
        if (m.find( )) {
            System.out.println("\tStreet Match: <" + m.group(0) + ">");
            this.address.setStreet(m.group(0).trim());
            addressString = addressString.replace(m.group(0), "");
        } else {
            System.out.println("\tStreet Match: NO MATCH");
        }
        return addressString.trim();
    }
}
