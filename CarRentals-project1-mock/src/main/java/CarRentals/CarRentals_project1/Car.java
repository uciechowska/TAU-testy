package CarRentals.CarRentals_project1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Car extends HasTime {
	
	private int id;
	private String CarBrand; 
	private int yearOfRent;
	private boolean availability; 
	//private LocalDateTime createTime;
	private LocalDateTime lastRentalTime;
	//private LocalDateTime updateTime;
	

	public int getId() {return id; }
	public void setId(int id) {this.id = id; }
	
	public String getCarBrand() {return CarBrand; }
	public void setCarBrand(String CarBrand) {this.CarBrand = CarBrand; }
	
	public int getYearOfRent() { return yearOfRent; }
	public void setYearOfRent (int yearOfRent) { this.yearOfRent = yearOfRent;}
	
	public boolean isAvailability() {return availability; }
	public void setAvailability(boolean availability) {this.availability = availability;}
	
    //public LocalDateTime getCreateTime() { return createTime;}
    //public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime;}
	
   // public LocalDateTime getUpdateTime() { return updateTime;}
    //public void setUpdateTime(LocalDateTime updateTime) {this.updateTime = updateTime;}

    public LocalDateTime lastRentalTime() { return lastRentalTime;}
    public void setlastRentalTime(LocalDateTime lastRentalTime) {this.lastRentalTime = lastRentalTime;}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    
}
