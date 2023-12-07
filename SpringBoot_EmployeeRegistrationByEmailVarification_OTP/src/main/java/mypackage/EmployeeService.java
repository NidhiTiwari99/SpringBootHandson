package mypackage;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;
	
	@Autowired
	EmailService emailservice;
	
	static String otp="";
	
	public EmailModel SendEmail(Employee e) {
		 otp=GenerateOTP(6);
		//Employee emp=emprepo.save(e);
		EmailModel em=new EmailModel(e.getEmail_address(), "Employee Email Varification", "Dear"+e.getEmployee_name()+", Your Email Varification otp is" +otp+ ".");
	emailservice.SendEmail(em);
	return em;
	}
	
	public Employee AddEmployee(Employee e, String userotp) {
		String pass=GeneratePassword(10);
		e.setPassword(pass);
		if(userotp.equals(otp)) {
			Employee emp =emprepo.save(e);
			EmailModel em=new EmailModel(e.getEmail_address(), "Employee Registration Confirmation", "Dear" +e.getEmployee_name()+ "Your Account Has Been Created Successfully. You Can Login with your Employee Code="+e.getEmployee_code()+" and Below mentioned="+e.getPassword());
			emailservice.SendEmail(em);
			return emp;
		}
		else 
		{
			return null;
		}
	}
	
	
		public static String GenerateOTP(int size) {
			String data="0123456789";
			String otp="";
			Random r=new Random();
			for(int i=1; i<=size; i++) {
				//otp+=data.charAt(r.nextInt(0, data.length()-1));
				otp+=data.charAt(r.nextInt(data.length()-1));
				
			}
		
			return otp;

	}
		public static String GeneratePassword(int size) {
			String data="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$";
			String pass="";
			Random r=new Random();
		
			for(int i=1; i<=size; i++) {
				//password+=data.charAt(r.nextInt(0, data.length()-1));
				pass+=data.charAt(r.nextInt(data.length()-1));
				
			}
		
			return pass;
		}
}
