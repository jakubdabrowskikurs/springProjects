package spring.employees;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpController {

    @RequestMapping("/")
    public String indexGet() {
        return "emp/index";
    }

    @RequestMapping(value = "/empform", method = RequestMethod.GET)
    public ModelAndView showform(Model model) {
        return new ModelAndView("emp/empform", "emp", new Emp());
    }

    @RequestMapping(value = "/save_emp")
    public ModelAndView save(@ModelAttribute(value = "emp") Emp emp) {
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping("/viewemp")
    public ModelAndView viewemp(Model model) {
        List<Emp> list = new ArrayList<>();
        list.add(new Emp(1, "Janek", 120000, "Radom"));
        list.add(new Emp(2, "Zosia", 9000, "Makowiec"));
        list.add(new Emp(3, "Marek", 10000, "Warszawa"));
        list.add(new Emp(4, "Krysytna", 13000, "Ryzowice"));
        return new ModelAndView("emp/viewemp", "list", list);
    }
}