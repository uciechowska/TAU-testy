package pl.ula.restdemo.service;

// w oparciu o przyklad J Neumanna, przerobiony przez T Puzniakowskiego

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pl.ula.restdemo.domain.Employee;

public interface EmployeeManager {
	public Connection getConnection();
	public void setConnection(Connection connection) throws SQLException;
	public int addEmployee(Employee employee);
	public int deleteEmployee(Employee employee);
	public int updateEmployee(Employee employee) throws SQLException;
	public Employee getEmployee(long id) throws SQLException;
	public String introduceSelf();
	public int deleteAll();
	public List<Employee> getAllEmployees();
}
