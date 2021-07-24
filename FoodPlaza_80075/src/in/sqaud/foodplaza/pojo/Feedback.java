package in.sqaud.foodplaza.pojo;

public class Feedback {
	private int fid;
	private String custEmail;
	private String message;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getCustomerEmail() {
		return custEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.custEmail = customerEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", customerEmail=" + custEmail + ", message=" + message + "]";
	}
	

}
