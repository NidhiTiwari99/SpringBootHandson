package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Specializations")
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int specialization_id;
	private String specialization_name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="qualification_id")
	private Qualification qualification;
	
	@OneToMany(mappedBy = "specialization",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("specialization")
	private Set<Employee>employees;

	public Specialization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialization(int specialization_id, String specialization_name, Qualification qualification,
			Set<Employee> employees) {
		super();
		this.specialization_id = specialization_id;
		this.specialization_name = specialization_name;
		this.qualification = qualification;
		this.employees = employees;
	}

	public int getSpecialization_id() {
		return specialization_id;
	}

	public void setSpecialization_id(int specialization_id) {
		this.specialization_id = specialization_id;
	}

	public String getSpecialization_name() {
		return specialization_name;
	}

	public void setSpecialization_name(String specialization_name) {
		this.specialization_name = specialization_name;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
