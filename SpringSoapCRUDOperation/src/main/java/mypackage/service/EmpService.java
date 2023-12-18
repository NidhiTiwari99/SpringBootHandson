package mypackage.service;

import mypackage.model.Employee;

public interface EmpService {
	

	void AddEmployee(Employee employee);

	Employee getEmployeeById(long employeeId);

    void updateEmployee(Employee employee);

    void deleteEmployee(long employeeId);


}
