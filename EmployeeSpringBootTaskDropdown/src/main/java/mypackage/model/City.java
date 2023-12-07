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
@Table(name="City_details")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int city_id;
	private String city_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="state_id")
	private State state;
	
	public City(int city_id, String city_name, State state) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.state = state;
	}
	@OneToMany(mappedBy = "city",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("city")
	private Set<Employee>employees;
	
public City(int city_id, String city_name, State state, Set<Employee> employees) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.state = state;
		this.employees = employees;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
}
