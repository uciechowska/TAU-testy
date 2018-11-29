package pl.ula.restdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pl.ula.restdemo.domain.Employee;
import pl.ula.restdemo.service.EmployeeManager;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple web api demo -- try implementning post method
 * 
 * Created by tp on 24.04.17.
 */
@RestController
public class EmployeeApi {

    @Autowired
    EmployeeManager employeeManager;

    @RequestMapping("/")
    public String index() {
        return "This is non rest, just checking if everything works.";
    }

    @RequestMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") Long id) throws SQLException {
        return employeeManager.getEmployee(id);
    }

    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employee> getEmployees(@RequestParam(value = "filter", required = false) String f) throws SQLException {
        List<Employee> employees = new LinkedList<Employee>();
        for (Employee p : employeeManager.getAllEmployees()) {
            if (f == null) {
                employees.add(p);
            } else if (p.getName().contains(f)) {
                employees.add(p);
            }
        }
        return employees;
    }

    @RequestMapping(value = "/employee",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestBody Employee p) {
        if (employeeManager.addEmployee(p) < 1) return null;
        return p;
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Long deleteEmployee(@PathVariable("id") Long id) throws SQLException {
        return new Long(employeeManager.deleteEmployee(employeeManager.getEmployee(id)));
    }

}
