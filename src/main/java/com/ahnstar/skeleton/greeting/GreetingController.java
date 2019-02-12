package com.ahnstar.skeleton.greeting;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping(value= "/greeting", method = RequestMethod.GET, produces="text/html")
	public String greeting(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("name", "hello world");
		return "greeting/index";
	}
}