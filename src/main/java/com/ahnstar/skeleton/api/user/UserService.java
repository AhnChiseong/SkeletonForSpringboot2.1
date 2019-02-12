package com.ahnstar.skeleton.api.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	public Map<String, Object> list(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Iterable<User> list = this.userRepository.findAll();
		map.put("list", list);
		map.put("result", 1);
		return map;
	}
	
	@Transactional
	public Map<String, Object> add(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setName((String)params.get("name"));
		user.setEmail((String)params.get("email"));
		userRepository.save(user);
		
		map.put("user", user);
		return map;
	}
	

	public Map<String, Object> read(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response, int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = null;
		if(this.userRepository.existsById(id)) {
			Optional<User> optUser = this.userRepository.findById(id);
			if(optUser.isPresent()) {
				user = optUser.get();
			}
		}
		
		map.put("user", user);
		return map;
	}
	
	@Transactional
	public Map<String, Object> update(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("params : " + params.toString());
		User user = null;
		int id = Integer.parseInt((String)params.get("id"));
		if(this.userRepository.existsById(id)) {
			Optional<User> optUser = this.userRepository.findById(id);
			if(optUser.isPresent()) {
				user = optUser.get();
				user.setName((String)params.get("name"));
				user.setEmail((String)params.get("email"));
				this.userRepository.save(user);
			}
		}
		
		map.put("user", user);
		return map;
	}
	
	@Transactional
	public Map<String, Object> delete(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("params : " + params.toString());
		
		int id = Integer.parseInt((String)params.get("id"));
		if(this.userRepository.existsById(id)) {
			this.userRepository.deleteById(id);
		}
		
		return map;
	}
}
