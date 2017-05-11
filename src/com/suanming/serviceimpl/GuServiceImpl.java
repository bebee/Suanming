package com.suanming.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suanming.dao.GuDao;
import com.suanming.entity.Gu_info;
import com.suanming.service.GuService;

@Service
public class GuServiceImpl implements GuService{
	
	@Autowired
	private GuDao gudao;
	private Gu_info gu_info;
	@Override
	public Gu_info findByNo(int gu_number) {
		// TODO Auto-generated method stub
		return gudao.findByNo(gu_number);
	}
	
}
