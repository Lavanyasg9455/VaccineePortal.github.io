package com.tap.vaccine.dao;

import java.io.Serializable;

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
public class RegisterDAOImpl implements RegisterDAO {
		
	    @Autowired
		private EmailService emailService;
		
		public RegisterDAOImpl(EmailService emailService) {
			
			System.out.println("Invoked EmailService()..");
			this.emailService = emailService;
		}

		private SessionFactory sessionFactory;
		
		@Autowired
		public RegisterDAOImpl(SessionFactory sessionFactory) {
			
			this.sessionFactory = sessionFactory;
			System.out.println("SessionFactory is injected by iocContainer..");
		}
		
		@Override
		public boolean saveRegisterEntity(RegisterEntity entity){
			System.out.println("Inkoved saveRegisterEntity()...");
			Session session=null;
			Transaction transaction=null;
			boolean isDataSaved=false;
			try
			{
				session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				Serializable save =session.save(entity);
				System.out.println("save"+save);
				emailService.sendEmail(entity);
				transaction.commit();
				isDataSaved=true;
				System.out.println("RegisterEntity has been saved..");
				
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
			return isDataSaved;
		}

		@Override
		public boolean emailCheck(String emailId) {
			System.out.println("Invoked emailCheck()..");
			Session session=null;
			String hql="SELECT COUNT(registerId) FROM RegisterEntity WHERE emailId='"+emailId+"'";
			boolean isEmailAvailable=false;
			try {
				session=sessionFactory.openSession();
				Query query=session.createQuery(hql);
				long count=(long) query.uniqueResult();
				if(count>0) {
					System.out.println("Email already exist..");
					isEmailAvailable=false;
				}else {
					System.out.println("Email is valid.. Continue for register");
					isEmailAvailable=true;
				}
			} finally {
				if(session!=null) {
					session.close();
					System.out.println("Session closed");
				}
			}
			return isEmailAvailable;
		}
		
		

}
	
	
