package com.mkyong.common.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/movie")
public class MovieController {

	static Logger logger = Logger
            .getLogger(MovieController.class);
	

	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
		
		BasicConfigurator.configure();
		logger.info("Entering conroller class.");
		
		model.addAttribute("movie", name);
		return "list";

	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultMovie(ModelMap model) {
		BasicConfigurator.configure();
		logger.debug("Entering conroller class.default movie");
		model.addAttribute("movie", "Default Movie");
        return "list";

	}
}