package xyz.cfsaisi.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Medicine {
	private String mid;
	private String picture;
	private String inprice;
	private String salprice;
	private String name;
	private Integer type;
	private String descs;
	private Integer qualitydate;
	private String description;
	private String produceFirm;
	private String readme;
	private String remark;
}
