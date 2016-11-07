package uk.me.eastmans.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by markeastman on 26/09/2016.
 */
@Controller
public class HomeController extends BaseController {

    @GetMapping("/home")
    public String index() {
        return "home";
    }

}
