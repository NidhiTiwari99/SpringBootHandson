package mypackage.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@Entity
@Table(name="state_details")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int state_id;
	private String state_name;
	
	@OneToMany(mappedBy = "state",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("state")
	private Set<City>cities;
	
	public State(int state_id, String state_name, Set<City> cities) {
		super();
		this.state_id = state_id;
		this.state_name = state_name;
		this.cities = cities;
	}
	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
}
