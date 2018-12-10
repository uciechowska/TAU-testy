package pl.ula.dbunit.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.ula.dbunit.domain.Car;

@Component
@Transactional

public class CarManagerImpl implements CarManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(Car car) {
		car.setId(null);
		sessionFactory.getCurrentSession().saveOrUpdate(car);
		sessionFactory.getCurrentSession().flush();
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
		
		return sessionFactory.getCurrentSession().createQuery("FROM Car", Car.class).list();
		
	}

	@Override
	public List<Car> findCarByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
