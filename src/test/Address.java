package test;

public class Address {
	  private String addressString;
	    private String number;
	    private String section;
	    private String street;
	    private String city;
	    private String state;
	    private String postcode;

	    public Address(String addressString) {
	        this.addressString = addressString;
	    }

	    public String getAddressString() {
	        return addressString;
	    }

	    public void setAddressString(String addressString) {
	        this.addressString = addressString;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }

	    public String getSection() {
	        return section;
	    }

	    public void setSection(String section) {
	        this.section = section;
	    }
	    
	    public String getStreet() {
	        return street;
	    }

	    public void setStreet(String street) {
	        this.street = street;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getPostCode() {
	        return postcode;
	    }

	    public void setPostCode(String postcode) {
	        this.postcode = postcode;
	    }
	}
