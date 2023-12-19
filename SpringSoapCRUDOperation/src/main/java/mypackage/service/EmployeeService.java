package mypackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Employee;
import mypackage.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmpService {
	
	 @Autowired
	 EmployeeRepository employeeRepository;


	@Override
	public Employee getEmployeeById(long employeeId) {

		Employee obj = employeeRepository.findByEmployeeId(employeeId);
		return obj;

	}

	@Override
	public void AddEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);

	}

}
 
