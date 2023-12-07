package mypackage.services;
import mypackage.model.*;
import java.util.*;
import mypackage.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	StateRepository staterepo;
	@Autowired
	CityRepository cityrepo;
	@Autowired
	QualificationRepository qualrepo;
	@Autowired
	SpecializationRepository sperepo;
	@Autowired
	DesignationRepository desrepo;
	@Autowired
	EmployeeRepository emprepo;
	
	
	public List<State>GetStates(){
    List<State>lst=new ArrayList<State>();
    for(State s:staterepo.findAll()){
    	State st=new State(s.getState_id(), s.getState_name(), null);
    	lst.add(st);
    }
    return lst;
	}
	
	public List<City>GetCities(int state_id){
		List<City>lst=new ArrayList<City>();
		for(City c:cityrepo.findAll()) {
			if(c.getState().getState_id()==state_id) {
				State st=new State(c.getState().getState_id(), c.getState().getState_name(), null);
				City ct=new City(c.getCity_id(), c.getCity_name(), st);
				lst.add(ct);
			}
		}
		return lst;
	}
	public List<Qualification>GetQualifications(){
	    List<Qualification>lst=new ArrayList<Qualification>();
	    for(Qualification s:qualrepo.findAll()){
	    	Qualification st=new Qualification(s.getQualification_id(), s.getQualification_name(), null);
	    	lst.add(st);
	    }
	    return lst;
		}
	
	public List<Specialization>GetSpecializations(int qualification_id){
		List<Specialization>lst=new ArrayList<Specialization>();
		for(Specialization c:sperepo.findAll()) {
			if(c.getQualification().getQualification_id()==qualification_id) {
				Qualification q=new Qualification(c.getQualification().getQualification_id(), c.getQualification().getQualification_name(), null);
				Specialization sp=new Specialization(c.getSpecialization_id(), c.getSpecialization_name(), q, null);
				lst.add(sp);
			}
		}
		return lst;
	}
	
	public List<Designation>GetDesignations(){
	    List<Designation>lst=new ArrayList<Designation>();
	    for(Designation s:desrepo.findAll()){
	    	Designation st=new Designation(s.getDesignation_id(), s.getDesignation_name(), null);
	    	lst.add(st);
	    }
	    return lst;
		}
	
	public Employee AddEmployee(Employee e) {
//		Employee e=new Employee(e.getEmployee_id(), e.getEmployee_name(), city, specialization, e.getEmail_address(), e.getMobile_number(), designation, e.getSalary());
		emprepo.save(e);
		return e;
	}
	
	public List<Employee>GetEmployees(){
		List<Employee>lst=new ArrayList<Employee>();
		for(Employee e:emprepo.findAll()) {
			City ct=new City(e.getCity().getCity_id(), e.getCity().getCity_name(), null);
			Specialization sp=new Specialization(e.getSpecialization().getSpecialization_id(), e.getSpecialization().getSpecialization_name(), null, null);
		    Designation ds=new Designation(e.getDesignation().getDesignation_id(), e.getDesignation().getDesignation_name(), null);
		    Employee emp=new Employee(e.getEmployee_id(), e.getEmployee_name(), ct, sp, e.getEmail_address(), e.getMobile_number(), ds, e.getSalary());
		    lst.add(emp);
		}
		return lst;
	}
}
