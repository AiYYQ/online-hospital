package xyz.cfsaisi.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
	private String rid;
	private String name;
	private String idcard;
	private String sinumber;
	private String registermoney;
	private String phone;
	private String ispay;
	private String sex;
	private String age;
	private String consultation;
	private String department;
	private String did;
	private String status;
	private Date registerdate;
	private String remark;
	private Doctor doctor;
}
