package CarRentals.CarRentals_project1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import CarRentals.CarRentals_project1.Car;

public class CarManagerImpl implements CarManager {

	public Collection<Car> cars = new ArrayList<Car>();

	
	public void create(Car car) {
	
		cars.add(car);
		
	}

	public void update(Car car) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Car car) {
		// TODO Auto-generated method stub
		
	}

	public Car getCar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return new ArrayList<Car>(cars);
	}
	
	

}
