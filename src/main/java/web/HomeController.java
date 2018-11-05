package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "/home", "homepage"})
public class HomeController {

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(method = GET)
    public String home() {
        return "home";
    }
}
