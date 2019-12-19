package spring.hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeesController {

    private List<Employees> list;

    private EmployeeDao employeeDao;

    public EmployeesController() {
        employeeDao = new EmployeeDao();
        try {
            list = employeeDao.getEmployees();
        } catch (NullPointerException ex) {
            System.out.println("Brak połączenia z bazą danych");
            ex.getMessage();
            list = new ArrayList<>();
        }
    }

    @RequestMapping("/employees")
    public String indexGet() {
        return "employees/index_employees";
    }

    @RequestMapping(value = "/employees_form", method = RequestMethod.GET)
    public String showForm(Model model) {
        Employees employees = new Employees();
        employees.setStartJobDate(new Date());
        model.addAttribute("emp", employees);
        return "employees/employees_form";
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(@ModelAttribute(value = "emp") Employees employees) {
        if (employees.getId() < 0) {
            System.out.println("Adding a new emp");
            employees.setId(list.size() + 1);
            list.add(employees);
            addEmployeeInDB(employees);
        } else {
            updateEmployeeInList(employees);
            updateEmployeeInDB(employees);
        }
        return new ModelAndView("redirect:/employees_list");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "emp_id") String emp_id) {
        Employees employeesTemp = getEmployeesById(Integer.parseInt(emp_id));
        list.remove(employeesTemp);
        deleteEmployeeInDB(employeesTemp);
        return new ModelAndView("redirect:/employees_list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam(value = "emp_id") String emp_id) {
        Employees employeesTemp = getEmployeesById(Integer.parseInt(emp_id));
        updateEmployeeInDB(employeesTemp);
        return new ModelAndView("employees/employees_form", "emp", employeesTemp);
    }

    @RequestMapping("/employees_list")
    public ModelAndView showEmployeesList(Model model) {
        return new ModelAndView("employees/employees_list", "list", list);
    }

    private Employees getEmployeesById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    private void updateEmployeeInList(Employees employees){
        Employees employeesTemp = getEmployeesById(employees.getId());
        employeesTemp.setFirstName(employees.getFirstName());
        employeesTemp.setLastName(employees.getLastName());
        employeesTemp.setAddress(employees.getAddress());
        employeesTemp.setCity(employees.getCity());
        employeesTemp.setSalary(employees.getSalary());
        employeesTemp.setAge(employees.getAge());
        employeesTemp.setStartJobDate(employees.getStartJobDate());
        employeesTemp.setBenefit(employees.getBenefit());
        employeesTemp.setCars(employees.getCars());
    }

    private void updateEmployeeInDB(Employees employees){
        employeeDao.updateEmployees(employees);
    }

    private void addEmployeeInDB(Employees employees){
        employeeDao.saveEmployee(employees);
    }

    private void deleteEmployeeInDB(Employees employees){
        employeeDao.deleteEmployees(employees);
    }
}