package com.ahnstar.skeleton.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;

@Controller
public class MainController {
	
	protected final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MainService mainService;

	@RequestMapping(value= "/", method = RequestMethod.GET, produces="text/html")
	public String main(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		this.mainService.getNotice(params, request, response, model);
		
		return "main/index";
	}
	
	@RequestMapping(value= "/home", method = RequestMethod.GET, produces="text/html")
	public String home(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		//this.mainService.getNotice(params, request, response, model);
		
		return "home";
	}
}