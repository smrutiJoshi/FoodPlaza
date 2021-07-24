package in.sqaud.foodplaza.pojo;

public class Customer {
	private int id;
	
	private String custname,custemail,custadd,custcontact,custpassword;

	
	
	
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custname=" + custname + ", custemail=" + custemail + ", custadd=" + custadd
				+ ", custcontact=" + custcontact + ", custpassword=" + custpassword + "]";
	}


	//Getters And Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	public String getCustadd() {
		return custadd;
	}
	public void setCustadd(String custadd) {
		this.custadd = custadd;
	}
	public String getCustcontact() {
		return custcontact;
	}
	public void setCustcontact(String custcontact) {
		this.custcontact = custcontact;
	}
	public String getCustpassword() {
		return custpassword;
	}
	public void setCustpassword(String custpassword) {
		this.custpassword = custpassword;
	}
	
	
	
		

}
