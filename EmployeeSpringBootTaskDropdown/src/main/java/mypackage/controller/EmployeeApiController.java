package mypackage.controller;
import mypackage.model.*;
import mypackage.services.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
public class EmployeeApiController {
	
	@Autowired
	EmployeeService empservice;
	
	@GetMapping("api/state")
	public List<State>getStates(){
		return empservice.GetStates();
	}
	
	@GetMapping("api/city/{id}")
	public List<City>getCities(@PathVariable("id") int id){
		return empservice.GetCities(id);
	}
	
	@GetMapping("api/qualification")
	public List<Qualification>getQualificationss(){
		return empservice.GetQualifications();
	}
	
	@GetMapping("api/specialization/{id}")
	public List<Specialization>getSpecializations(@PathVariable("id") int id){
		return empservice.GetSpecializations(id);
	}
	
	@GetMapping("api/designation")
	public List<Designation>getDesignations(){
		return empservice.GetDesignations();
	}

	@PostMapping("api/employee")
	public Employee AddEmployee(@RequestBody Employee e) {
		return empservice.AddEmployee(e);
	}
	
	@GetMapping("api/employee")
	public List<Employee>getEmployees(){
		return empservice.GetEmployees();
	}
	
}
