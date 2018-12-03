package CarRentals.CarRentals_project1.service;


import java.util.List;

import CarRentals.CarRentals_project1.Car;

public interface CarManager {

	public void create(Car car);
	public void update (Car car);
	public void delete (Car car); 
	public Car getCar (int id); 
	public int deleteAll();
	public List<Car> getAllCars();
	
}
