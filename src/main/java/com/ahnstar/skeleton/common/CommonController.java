package com.ahnstar.skeleton.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@RequestMapping(value= "/", method = RequestMethod.GET)
	public Object main(@RequestParam Map<String, String> param, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("data","Hello World");
		return model;
	}
}