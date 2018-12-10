package pl.ula.dbunit.service;


import java.util.List;

import pl.ula.dbunit.domain.Car;



public interface CarManager {

	public void create(Car car);
	public Car getCar (int id); 
	public void update (Car car);
	public void delete (Car car); 
	
	public int deleteAll();
	public List<Car> getAllCars();
	
	public List<Car> findCarByBrand(String brand);
}
