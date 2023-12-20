package com.tap.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginDAOImpl implements LoginDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public LoginDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("SessionFactory is injected by iocContainer..");
	}

	@Override
	public RegisterEntity getRegisterEntityByEmail(String emailId) {
		
		System.out.println("Invoked getRegisterEntityByEmail()..");
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
	public boolean updateLoginAttempt(String emailId,int loginAttempt) {
		
		System.out.println("Invoked updateRegisterEntity()..");
		Session session=null;
		Transaction transaction=null;
		String hql="update RegisterEntity set loginAttempt=loginAttempt+1 where emailId='"+emailId+"'";
		int i=0;
		try {
			
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			i=query.executeUpdate();
			transaction.commit();
			if(i>0) {
				return true;
			}
		}catch(HibernateException hibernateException) {
			
			transaction.rollback();
			System.out.println("Transaction has been rollback.."+hibernateException.getMessage());
			
		}
		finally {
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
			
		}
		return false;
	}

}
