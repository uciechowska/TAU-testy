package CarRentals.CarRentals_project1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CarRentals.CarRentals_project1.service.CarManager;
import CarRentals.CarRentals_project1.service.CarManagerImpl;


import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
 

public class CarManagerTest2 {
	
  
	@Test
		
	public void testGetCar() {
		
		Date mockDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		CarManager db = spy(CarManagerImpl.class);
		when(((CarManagerImpl) db).getCurrentDate()).thenReturn(mockDate);
		Assert.assertEquals("Wyzsza matematyka", 4, 2+2);
		Car car = new Car(); 
		final int id = 1;
		car.setId(id);
		car.setCarBrand("Mercedes");
		car.setAvailability(true);
		
		
		db.create(car);
		//db.getAllCars();
		Car car2 = db.getCar(id);
		Assert.assertNotNull("data odczytu rekordu jest ustawiona", car2.getReadTime());
		verify(db, times(1)).setReadTime(mockDate, car2);
		}
	
	
}
