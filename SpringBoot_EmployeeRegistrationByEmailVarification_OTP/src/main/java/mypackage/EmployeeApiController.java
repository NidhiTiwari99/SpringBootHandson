package mypackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
public class EmployeeApiController {
	
	@Autowired
	EmployeeService emailservice;

	@PostMapping("addemployee")
	
	public EmailModel SendEmail(@RequestBody Employee e) {
		return emailservice.SendEmail(e);
		//System.out.println(e.getEmail_address());
		//return null; //(e)
	}
	
@PostMapping("saveemployee")
	
	public Employee SaveEmployee(@RequestBody OtpModel e) {
		System.out.println(e.getEmployee().getEmail_address()+" "+e.getOtp());
	//return null;
	return emailservice.AddEmployee(e.getEmployee(), e.getOtp());
		
	}
}
