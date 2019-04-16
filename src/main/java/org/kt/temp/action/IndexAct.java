package org.kt.temp.action;

import java.util.List;

import org.kt.temp.pojo.User;
import org.kt.temp.service.UserService;
import org.kt.temp.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexAct {
	
	@Autowired
	private UserService userSerivce;
	
	@RequestMapping("/hello")
	public R index() {
		System.out.println("Hello,Jack!");
		return R.ok("返回json字符串");
	}
	
	@RequestMapping("/user")
	public Object user() {
		List<User> list = userSerivce.findAll();
		return list;
	}
}
