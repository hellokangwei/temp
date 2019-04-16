package org.kt.temp.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String clientName; // 客户端名称
	private String password; // 密码
	private String scope; // 权限范围，可选值包括read,write,trust
	private String authorizedGrantTypes; // 客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials
	private String authorities;  // 客户端所拥有的Spring Security的权限值
	private String remark; // 备注

	private Integer limit;
	private Integer page;

}
