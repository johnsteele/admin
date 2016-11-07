package uk.me.eastmans.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by markeastman on 26/09/2016.
 */
@Controller
public class ProcessesController extends BaseController{

    @GetMapping("/processes")
    public String index(Model model) {
        return "processes";
    }
}
