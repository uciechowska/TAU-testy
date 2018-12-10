package pl.ula.dbunit.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;


import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import pl.ula.dbunit.domain.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
//@Rollback
@Commit
@Transactional(transactionManager = "txManager")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
                         DirtiesContextTestExecutionListener.class,
                         TransactionalTestExecutionListener.class,
                         DbUnitTestExecutionListener.class})
public class CarManagerDBUnitTest {

  @Autowired CarManager carManager;

  @Test
  @DatabaseSetup("/carDatabaseDump.xml")
  @ExpectedDatabase(value = "/carDatabaseAfterTest.xml",
                    assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void
  getClientCheck() throws ParseException {
    int initialDBSize = 1;
	assertEquals(initialDBSize, carManager.getAllCars().size());
  
    //Car car = new Car(); 
   // car.setCarBrand("Mercedes");
    Car car1 = new Car();
    car1.setCarBrand("Fiat");
    Car car2 = new Car();
    car2.setCarBrand("Ford");
    
    
    
    List<Car> addedCars =  Arrays.asList(car1, car2);
      
    for (Car addedcar : addedCars) {
    	
    	carManager.create(addedcar);
    	
    }

    assertEquals(initialDBSize+addedCars.size(), carManager.getAllCars().size());
    
  }
}
