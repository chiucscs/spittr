package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spittle;
import spittr.data.SpittleRespository;

import java.util.List;


@Controller
@RequestMapping({"/spittles", "/Spittles"})
public class SpittleController {
    private SpittleRespository spittleRespository;

    @Autowired
    public SpittleController(SpittleRespository spittleRespository) {
        this.spittleRespository = spittleRespository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(
                spittleRespository.findSpittles(Long.MAX_VALUE, 20)
        );
        return "spittles";
    }
    /*
     */
}
