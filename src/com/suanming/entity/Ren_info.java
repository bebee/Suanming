package com.suanming.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ren_info")
public class Ren_info {
	
	@Id
	private int ren_id;// 人id
	private String ren_xing;//姓
	private String ren_ming;//名
	private String ren_date;//阳历生日
	private String ren_time;//出生时间
	private String ren_lunar;//农历生日
	private String ren_shengchen;//生辰八字
	private String ren_shengxiao;//生肖
	private String ren_guzhong;//骨重
	
	public Ren_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ren_info(String ren_xing, String ren_ming, String ren_date, String ren_time, String ren_lunar,
			String ren_shengchen, String ren_shengxiao, String ren_guzhong) {
		super();
		this.ren_xing = ren_xing;
		this.ren_ming = ren_ming;
		this.ren_date = ren_date;
		this.ren_time = ren_time;
		this.ren_lunar = ren_lunar;
		this.ren_shengchen = ren_shengchen;
		this.ren_shengxiao = ren_shengxiao;
		this.ren_guzhong = ren_guzhong;
	}

	
	public int getRen_id() {
		return ren_id;
	}

	public void setRen_id(int ren_id) {
		this.ren_id = ren_id;
	}

	public String getRen_xing() {
		return ren_xing;
	}
	public void setRen_xing(String ren_xing) {
		this.ren_xing = ren_xing;
	}
	public String getRen_ming() {
		return ren_ming;
	}
	public void setRen_ming(String ren_ming) {
		this.ren_ming = ren_ming;
	}
	public String getRen_date() {
		return ren_date;
	}
	public void setRen_date(String ren_date) {
		this.ren_date = ren_date;
	}
	public String getRen_time() {
		return ren_time;
	}
	public void setRen_time(String ren_time) {
		this.ren_time = ren_time;
	}
	public String getRen_lunar() {
		return ren_lunar;
	}
	public void setRen_lunar(String ren_lunar) {
		this.ren_lunar = ren_lunar;
	}
	public String getRen_shengchen() {
		return ren_shengchen;
	}
	public void setRen_shengchen(String ren_shengchen) {
		this.ren_shengchen = ren_shengchen;
	}
	public String getRen_shengxiao() {
		return ren_shengxiao;
	}
	public void setRen_shengxiao(String ren_shengxiao) {
		this.ren_shengxiao = ren_shengxiao;
	}
	public String getRen_guzhong() {
		return ren_guzhong;
	}
	public void setRen_guzhong(String ren_guzhong) {
		this.ren_guzhong = ren_guzhong;
	}
	
}
