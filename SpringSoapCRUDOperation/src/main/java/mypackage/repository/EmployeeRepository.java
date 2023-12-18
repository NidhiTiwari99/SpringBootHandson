package mypackage.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mypackage.model.*;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeId(long employeeId);
	
}


