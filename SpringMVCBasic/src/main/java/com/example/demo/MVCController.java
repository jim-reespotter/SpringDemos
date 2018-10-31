package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MVCController {

	@RequestMapping(value="/thing1", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
		// pass some stuff to JSP:
		model.addAttribute("details", "thing1 passed to JSP");
        return "thing1";
    }
}
