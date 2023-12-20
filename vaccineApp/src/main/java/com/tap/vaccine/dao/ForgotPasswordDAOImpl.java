package com.tap.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.EmailService;

@Component
public class ForgotPasswordDAOImpl implements ForgotPasswordDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public ForgotPasswordDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("SessionFactory is injected by iocContainer..");
	}

	@Override
	public RegisterEntity getRegisterEntityByEmail(String emailId) {
		
		System.out.println("Invoked loginDetailsCheck()..");
		Session session=null;
		String hql="from RegisterEntity where emailId='"+emailId+"'";
		RegisterEntity entity=null;
		try {
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			entity=(RegisterEntity) query.uniqueResult();
			if(entity!=null) {
				System.out.println("Entity Found");
				return entity;
			}		
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("Session closed");
			}
		}
		return entity;
		
		
	}

	@Override
	public boolean updateNewPasswordByEmail(String emailId,String newPassword) {
		
		System.out.println("Invoked updateNewPasswordByEmail()..");
		Session session=null;
		Transaction transaction=null;
		String hql="update RegisterEntity set password='"+newPassword+"',loginAttempt=0 where emailId='"+emailId+"'";
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			int i=query.executeUpdate();
			transaction.commit();
			if(i==1) {
				System.out.println("Updated Successfully..");
				return true;
			}
		}catch(HibernateException hibernateException) {
			
			transaction.rollback();
			System.out.println("Transaction has been rollback.."+hibernateException.getMessage());
			
		}
		finally {
			if(session!=null){
				session.close();
				System.out.println("session is closed");
			}
			
		}
		return false;
	}

	

}