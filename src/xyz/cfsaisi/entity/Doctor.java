package xyz.cfsaisi.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	private Integer did;
	private String name;
	private String cardno;
	private String phone;
	private Integer sex;
	private Integer age;
	private Date birthday;
	private String email;
	private Integer department;
	private Integer education;
	private String remark;
}
