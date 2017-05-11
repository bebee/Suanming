package com.suanming.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suanming.dao.RenDao;
import com.suanming.entity.Gu_info;
import com.suanming.entity.Ren_info;

@Repository
public class RenDaoImpl implements RenDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Ren_info ren_info;

	@Override
	@Transactional
	public Boolean addRen(String ren_xing, String ren_ming, String ren_date, String ren_time, String ren_lunar,
			String ren_shengchen, String ren_shengxiao, String ren_guzhong) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			ren_info = new Ren_info(ren_xing, ren_ming, ren_date, ren_time, ren_lunar, ren_shengchen, ren_shengxiao,
					ren_guzhong);
			session.save(ren_info);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public Ren_info findByNo(int ren_id) {
		// TODO Auto-generated method stub
		return (Ren_info) sessionFactory.getCurrentSession()
				.createQuery("from Ren_info ren_info where ren_info.ren_id = :ren_id")
				.setParameter("ren_id", ren_id).uniqueResult();
	}
}
