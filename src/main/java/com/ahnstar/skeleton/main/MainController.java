package com.ahnstar.skeleton.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahnstar.skeleton.utils.mail.MailProperties;
import com.ahnstar.skeleton.utils.mail.MailUtil;

@Controller
public class MainController {
	
	@Autowired
	private MailProperties mailProperties;

	@RequestMapping(value= "/", method = RequestMethod.GET, produces="text/html")
	public String main(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		System.out.println(mailProperties);
		
		MailUtil mailUtil = new MailUtil();
		mailUtil.sendMail(this.mailProperties, "mail test", "mail content");
		
		
		
		return "main/index";
	}
}