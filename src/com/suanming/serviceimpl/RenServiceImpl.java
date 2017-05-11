package com.suanming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suanming.dao.RenDao;
import com.suanming.entity.Ren_info;
import com.suanming.service.RenService;

@Service
public class RenServiceImpl implements RenService{
	@Autowired
	private RenDao renDao;
	private Ren_info ren_info;
	
	@Override
	public Boolean addRen(String ren_xing, String ren_ming, String ren_date, String ren_time, String ren_lunar,
			String ren_shengchen, String ren_shengxiao, String ren_guzhong) {
		// TODO Auto-generated method stub
		return renDao.addRen(ren_xing, ren_ming, ren_date, ren_time, ren_lunar, ren_shengchen, ren_shengxiao,
				ren_guzhong);

	}

	@Override
	public Ren_info findByNo(int ren_id) {
		// TODO Auto-generated method stub
		return renDao.findByNo(ren_id);
	}

}
