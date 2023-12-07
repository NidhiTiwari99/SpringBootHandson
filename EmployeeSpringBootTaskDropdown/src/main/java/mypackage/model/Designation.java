package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Designations")
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int designation_id;
	private String designation_name;
	
	@OneToMany(mappedBy = "designation",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("designation")
	private Set<Employee>employees;

	public Designation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Designation(int designation_id, String designation_name, Set<Employee> employees) {
		super();
		this.designation_id = designation_id;
		this.designation_name = designation_name;
		this.employees = employees;
	}

	public int getDesignation_id() {
		return designation_id;
	}

	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}

	public String getDesignation_name() {
		return designation_name;
	}

	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
