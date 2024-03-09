package project.bank.model;

public class Customer {
	private long id;
	private String name;
	private String email;
	private String password;
	private String aadharNumber;
	private String panNumber;
	
	public Customer() {
		
	}
	
	public Customer (long id) {
		this.id=id;
	}
	
	public Customer(String name, String email, String password, String aadharNumber, String panNumber) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}

	public Customer(long id, String name, String email, String password, String aadharNumber, String panNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
}