package com.suanming.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gu_info")
public class Gu_info {
	@Id
	private String gu_id;// 骨重id
	private int gu_number;// 骨重数量
	private String gu_content;// 骨重命运
	
	

	public Gu_info() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gu_info(String gu_id, int gu_number, String gu_content) {
		super();
		this.gu_id = gu_id;
		this.gu_number = gu_number;
		this.gu_content = gu_content;
	}

	public String getGu_id() {
		return gu_id;
	}

	public void setGu_id(String gu_id) {
		this.gu_id = gu_id;
	}

	public int getGu_number() {
		return gu_number;
	}

	public void setGu_number(int gu_number) {
		this.gu_number = gu_number;
	}

	public String getGu_content() {
		return gu_content;
	}

	public void setGu_content(String gu_content) {
		this.gu_content = gu_content;
	}
}
