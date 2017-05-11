package com.suanming.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suanming.dao.GuDao;
import com.suanming.entity.Gu_info;

@Repository
public class GuDaoImpl implements GuDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Gu_info findByNo(int gu_number) {
		// TODO Auto-generated method stub
		return (Gu_info) sessionFactory.getCurrentSession()
				.createQuery("from Gu_info gu_info where gu_info.gu_number = :gu_number")
				.setParameter("gu_number", gu_number).uniqueResult();
	}
}
