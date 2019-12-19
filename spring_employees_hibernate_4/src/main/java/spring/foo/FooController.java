package spring.foo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FooController {
    @RequestMapping(value = "/showForm", method= RequestMethod.GET)
    public String showForm(Model model) {
        Foo foo = new Foo();
        foo.setBar("bar");

        model.addAttribute("foo", foo);
        return "foo/foo";
    }

    @RequestMapping(value = "/processForm", method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="foo") Foo foo) {
        return "foo/foo";
    }
}
