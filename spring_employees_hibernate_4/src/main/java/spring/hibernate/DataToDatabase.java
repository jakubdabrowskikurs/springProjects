package spring.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DataToDatabase {

	public static void main(String[] args) {
		supplyDatabase();
	}
	
	public static void supplyDatabase(){
		HibernateDao hibernateDao = new HibernateDao();

		Employees employees = new Employees();
		employees.setFirstName("Jan");
		employees.setLastName("Nowak");
		employees.setAge(19);
		employees.setBenefit(1);
		employees.setCity("Warszawa");
		employees.setSalary(9000);
		employees.setAddress("Złota");
		employees.setStartJobDate(new Date());
		employees.setEmail("crimson.kuba@gmail.com");

		hibernateDao.save(employees);

		Cars cars = new Cars();
		cars.setEmployees(employees);
		cars.setModel("126p");
		cars.setName("Fiat");

		hibernateDao.save(cars);

		Set<Cars> carsSet = new HashSet<>();
		carsSet.add(cars);

		employees.setCars(carsSet);

		Printer printer = new Printer();
		printer.setEmployees(employees);
		printer.setProducer("HP");
		printer.setModel("100");
		printer.setEmployees(employees);

		Set<Printer> printerSet = new HashSet<>();
		printerSet.add(printer);

		employees.setPrinters(printerSet);

		hibernateDao.update(employees);
	}
}