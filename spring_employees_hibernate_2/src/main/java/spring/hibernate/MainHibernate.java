package spring.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        System.out.println(employeesList.get(0).getCars());

        CarsDao carsDao = new CarsDao();

        Cars cars = new Cars();
        cars.setName("Audi");
        cars.setModel("Q5");
        cars.setEmployees(employee);

        Set<Cars> carSet = new HashSet<>();
        carSet.add(cars);

        carsDao.saveCars(cars);

        employee.setCars(carSet);

        employeeDao.updateEmployees(employee);

    }
}
