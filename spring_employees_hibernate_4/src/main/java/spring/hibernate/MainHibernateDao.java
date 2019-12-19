package spring.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainHibernateDao {
    public static void main(String[] args) {
        HibernateDao hibernateDao = new HibernateDao();

        Employees employee = new Employees("Test", "Test", "Test", "Test", 1000, 18 , new Date(), 1);
        List<Employees> employeesList = hibernateDao.get(Employees.class);

        hibernateDao.save(employee);

        Cars cars = new Cars();
        cars.setEmployees(employee);
        cars.setModel("Fiat");
        cars.setName("Duży");

        cars.setRegistrationDate(new Date());
        Set<Cars> carsSet = new HashSet<>();
        carsSet.add(cars);

        employee.setCars(carsSet);

        hibernateDao.save(cars);

  /*      for (Employees one : employeesList) {
            if(one.getId() == 50){
                hibernateDao.delete(one);
            }
        }*/

        Employees employeeToUpdate = employeesList.get(0);
        employeeToUpdate.setSalary(9999);

        hibernateDao.update(employeeToUpdate);

        Phones phones = new Phones();
        phones.setModel("Xperia 10");
        phones.setName("Sony");
        phones.setEmployees(employee);

        Phones phones1 = new Phones(employee,"Xperia 10","Sony");


        hibernateDao.save(phones);

    }
}
