package pl.tau.restdemo.service;

// przyklad na podstawie przykladow J. Neumanna
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.ula.restdemo.domain.Employee;
import pl.ula.restdemo.service.EmployeeManager;
import pl.ula.restdemo.service.EmployeeManagerImpl;

public class EmployeeManagerTest {

	EmployeeManager employeeManager;

	private final static String NAME_1 = "Janek";
	private final static int YOB_1 = 1939;

	@Before
	public void setup() throws SQLException {
		employeeManager = new EmployeeManagerImpl();
	}

	@After
	public void cleanup() throws SQLException {
	}

	@Test
	public void checkConnection() {
		assertNotNull(employeeManager.getConnection());
	}

	@Test
	public void checkAdding() throws SQLException {
		Employee employee = new Employee();
		employee.setName(NAME_1);
		employee.setYob(YOB_1);

		employeeManager.deleteAll();
		assertEquals(1, employeeManager.addEmployee(employee));

		List<Employee> employees = employeeManager.getAllEmployees();
		Employee employeeRetrieved = employees.get(0);

		assertEquals(NAME_1, employeeRetrieved.getName());
		assertEquals(YOB_1, employeeRetrieved.getYob());
	}

}
