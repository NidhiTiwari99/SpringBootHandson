package mypackage;

public class OtpModel {

	private String otp;
	private Employee employee;
	public OtpModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OtpModel(String otp, Employee employee) {
		super();
		this.otp = otp;
		this.employee = employee;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
