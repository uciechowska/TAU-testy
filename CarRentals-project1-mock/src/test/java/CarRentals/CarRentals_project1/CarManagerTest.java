package CarRentals.CarRentals_project1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CarRentals.CarRentals_project1.service.CarManager;
import CarRentals.CarRentals_project1.service.CarManagerImpl;


 

public class CarManagerTest {
	
  
	@Test
	public void testGetCar() {
		
		Assert.assertEquals("Wyzsza matematyka", 4, 2+2);
		Car car = new Car(); 
		car.setId(1);
		car.setCarBrand("Mercedes");
		car.setAvailability(true);
		
		CarManager db = new CarManagerImpl();
		
		db.create(car);
		db.getAllCars();
		Assert.assertEquals("Liczba  aut", 1 , db.getAllCars().size());
	
	} 
	
	

}
