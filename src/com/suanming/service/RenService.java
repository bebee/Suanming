package com.suanming.service;

import com.suanming.entity.Ren_info;

public interface RenService {
	public Boolean addRen(String ren_xing, String ren_ming, String ren_date, String ren_time, String ren_lunar,
			String ren_shengchen, String ren_shengxiao, String ren_guzhong);
	public Ren_info findByNo(int ren_id);
}
