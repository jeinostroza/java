package Primary_Classes;

public class Client {
	private int ID_CLIENT;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String STREET;
	private String CITY;
	private int ZIP_CODE;
	private String STATE;
	private String USERNAME;
	private String PASSWORD;
	
	public Client() {}
	
	public Client(int ID_CLIENT, String FIRST_NAME, String LAST_NAME, String STREET, String CITY, int ZIP_CODE, String STATE, String USERNAME, String PASSWORD) {
		this.ID_CLIENT = ID_CLIENT;
		this.FIRST_NAME = FIRST_NAME;
		this.LAST_NAME = LAST_NAME;
		this.STREET = STREET;
		this.CITY = CITY;
		this.ZIP_CODE=ZIP_CODE;
		this.STATE=STATE;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
	}
	
	public Client(int ID_CLIENT, String FIRST_NAME, String LAST_NAME, String USERNAME, String PASSWORD) {
		this.ID_CLIENT = ID_CLIENT;
		this.FIRST_NAME = FIRST_NAME;
		this.LAST_NAME = LAST_NAME;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
	}

	public int getID_CLIENT() {
		return ID_CLIENT;
	}

	public void setID_CLIENT(int ID_CLIENT) {
		this.ID_CLIENT = ID_CLIENT;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String FIRST_NAME) {
		this.FIRST_NAME = FIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String LAST_NAME) {
		this.LAST_NAME = LAST_NAME;
	}

	public String getSTREET() {
		return STREET;
	}

	public void setSTREET(String STREET) {
		this.STREET = STREET;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String CITY) {
		this.CITY = CITY;
	}

	public int getZIP_CODE() {
		return ZIP_CODE;
	}

	public void setZIP_CODE(int ZIP_CODE) {
		this.ZIP_CODE = ZIP_CODE;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String STATE) {
		this.STATE = STATE;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}
	
	
}
