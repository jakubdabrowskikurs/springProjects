package spring.hibernate;

import java.util.Date;
import java.util.List;

public class MainHibernate {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employees employee = new Employees("Test", "Test", "Test", "Test", 1000, 18 , new Date(), 1);
        employeeDao.saveEmployee(employee);
        List<Employees> employeesList = employeeDao.getEmployees();

        Employees employeeToUpdate = employeesList.get(0);
        employeeToUpdate.setSalary(9999);

        employeeDao.updateEmployees(employeeToUpdate);
        employeesList.forEach(System.out::println);
    }
}
