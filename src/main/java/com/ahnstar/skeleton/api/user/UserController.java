package com.ahnstar.skeleton.api.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "api/{version}/user", method = RequestMethod.GET, produces="application/json")
	public Object list(@PathVariable("version") String version, @RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		return this.userService.list(params, request, response);
	}
	
	@RequestMapping(value= "api/{version}/user/{id}", method = RequestMethod.GET, produces="application/json")
	public Object read(@PathVariable("version") String version, @RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id){
		return this.userService.read(params, request, response, id);
	}
	
	@RequestMapping(value= "api/{version}/user", method = RequestMethod.POST, produces="application/json")
	public Object add(@PathVariable("version") String version, @RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response){
		return this.userService.add(params, request, response);
	}
	
	@RequestMapping(value= "api/{version}/user", method = RequestMethod.PUT, produces="application/json")
	public Object update(@PathVariable("version") String version, @RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response){
		return this.userService.update(params, request, response);
	}
	
	@RequestMapping(value= "api/{version}/user", method = RequestMethod.DELETE, produces="application/json")
	public Object delete(@PathVariable("version") String version, @RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response){
		return this.userService.delete(params, request, response);
	}
}