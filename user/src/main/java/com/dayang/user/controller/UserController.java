package com.dayang.user.controller;


import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayang.user.mapper.db.User;


@RestController
@RequestMapping("/user")
public class UserController {
	private final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/userService")
	public String user() throws Exception {
		ServiceInstance instance =client.getLocalServiceInstance();
		//线程等待模拟服务延迟
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime :"+sleepTime);
		Thread.sleep(sleepTime);
		logger.info("/userService,host:"+instance.getHost()+", service_id:"+instance.getServiceId());
		User user = new User("cx", 25, 2358l);
		return user.toString();
	}
	
	//rest api
	@GetMapping("/get/users/{id}")
	public String getUserById(@PathVariable(value="id") Long id) {
		logger.info("get success: "+id);
		User user = new User("wjx", 18, id);
		return user.toString();
	}
	
	@PostMapping("/post/user")
	public String postUser() {
		logger.info("post success");
		return "post success";
	}
	
	@PutMapping("/put/user/{id}")
	public String updateUser(@PathVariable(value="id") Long id) {
		logger.info("put success: "+id);
		return "put success :"+id;
	}
	
	@DeleteMapping("/delete/user/{id}")
	public String deleteUser(@PathVariable(value="id") Long id) {
		logger.info("delete success: "+id);
		return "delete success :"+id;
	}
	@PatchMapping("/patch/user/{id}")
	public String patchUser(@PathVariable(value="id") Long id) {
		logger.info("patch success: "+id);
		return "patch success: "+id;
	}
}
