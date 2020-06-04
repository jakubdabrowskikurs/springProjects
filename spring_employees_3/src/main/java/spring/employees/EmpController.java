package spring.employees;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpController {

    private List<EmpLombok> list;



    public EmpController() {
        list = new ArrayList<>();
        list.add(new EmpLombok(1, "Janek", 120000, "Radom"));
        list.add(new EmpLombok(2, "Zosia", 9000, "Makowiec"));
        list.add(new EmpLombok(3, "Marek", 10000, "Warszawa"));
        list.add(new EmpLombok(4, "Krysytna", 13000, "Ryzowice"));
    }

    @RequestMapping("/")
    public String indexGet() {
        return "emp/index";
    }

    @RequestMapping(value = "/empform", method = RequestMethod.GET)
    public String showform(Model model) {
        model.addAttribute("emp", new EmpLombok());
        return "emp/empform";
    }

    @RequestMapping(value = "/save_emp")
    public ModelAndView save(@ModelAttribute(value = "emp") EmpLombok emp) {
        if (emp.getId() == 0) {
            System.out.println("Adding a new emp");
            emp.setId(list.size() + 1);
            list.add(emp);
        } else {
            EmpLombok empTemp = getEmployeesById(emp.getId());
            empTemp.setName(emp.getName());
            empTemp.setSalary(emp.getSalary());
            empTemp.setDesignation(emp.getDesignation());
        }
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value = "/delete_emp", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "emp_id") int emp_id) {
        list.remove(getEmployeesById(emp_id));
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value = "/edit_emp", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam(value = "emp_id") int emp_id) {
        EmpLombok emp = getEmployeesById(emp_id);
        return new ModelAndView("emp/empform", "emp", emp);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ModelAndView test() {
        System.out.println("Test");
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping("/viewemp")
    public ModelAndView viewemp(Model model) {
        return new ModelAndView("emp/viewemp", "list", list);
    }

    private EmpLombok getEmployeesById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}