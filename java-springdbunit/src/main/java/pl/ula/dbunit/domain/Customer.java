package pl.ula.dbunit.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.IndexColumn;



@Entity
public class Customer {
	
	private int id;
	private String name; 
	private String surname;
	private List<Car> cars; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public void setSurname(String surname) {
	        this.surname = surname;
	    }
	    
	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "CustomerId")
	    @OrderColumn(name = "CustomerIndex")
		public List<Car> getCars() {
			return cars;
		}
		public void setCars(List<Car> cars) {
			this.cars = cars;
		}
	

}
