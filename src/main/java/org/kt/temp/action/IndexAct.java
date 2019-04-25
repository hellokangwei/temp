package org.kt.temp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kt.temp.annotation.IgnoreAuth;
import org.kt.temp.pojo.User;
import org.kt.temp.service.UserService;
import org.kt.temp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexAct {
	
	@Autowired
	private UserService userSerivce;

	@Autowired
	private TokenHelper tokenHelper;

	@RequestMapping("/hello")
	public R index(HttpServletRequest request) {
		System.out.println("Hello,Jack!");
		return R.ok("返回json字符串");
	}
	
	@RequestMapping("/user")
	public Object user() {
		List<User> list = userSerivce.findAll();
		return list;
	}

	@IgnoreAuth // 忽略认证
	@RequestMapping("/testLogin")
	public ResultData testLogin(){
		User user = getUserInfo();
		String token = tokenHelper.createToken(user);
		Map map = new HashMap();
		map.put("token",token);
		return ResultData.success("登录成功",map);
	}

	@RequestMapping("/testToken")
	public ResultData testToken(HttpServletRequest request){
		User user = (User)request.getAttribute("user");
		System.out.println(user);
		System.out.println("hello...");
		return ResultData.success(user);
	}

	public User getUserInfo(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setAddress("珠海市");
		user.setAge(23);
		user.setSex("男");
		return user;
	}

}
