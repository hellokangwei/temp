package org.kt.temp.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
	private String username;
	@JsonIgnore
	private String password;
	private String address;
	private String sex;
	private int age;
}
