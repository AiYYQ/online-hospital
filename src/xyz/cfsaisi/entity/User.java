package xyz.cfsaisi.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private Integer uid;
	private String name;
	private String email;
	private Integer status;
	private String username;
	private String password;
	private Date modifytime;
}
