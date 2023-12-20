package com.tap.vaccine.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class MemberDAOImpl implements MemberDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public MemberDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("SessionFactory is injected by iocContainer..");
	}
	
	@Override
	public boolean saveMemberEntity(MemberEntity entity) {
		
		System.out.println("Inkoved saveMemberEntity()..");
		Session session=null;
		Transaction transaction=null;
		boolean isDataSaved=false;
		try
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Serializable save =session.save(entity);
			System.out.println("save"+save);
			transaction.commit();
			isDataSaved=true;
			System.out.println("MemberEntity has been saved..");
			
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
	public boolean idProofNoCheck(String idProofNo) {
		System.out.println("Invoked idProofNoCheck()..");
		Session session=null;
		String hql="SELECT COUNT(memberId) FROM MemberEntity WHERE idProofNo='"+idProofNo+"'";
		boolean isidProofNoAvailable=false;
		try {
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			long count=(long) query.uniqueResult();
			if(count>0) {
				System.out.println("ID Proof Number already exist!");
				isidProofNoAvailable=false;
			}else {
				System.out.println("ID Proof Number is valid.. Continue for Add The Member");
				isidProofNoAvailable=true;
			}
		} finally {
			if(session!=null) {
				session.close();
				System.out.println("Session closed");
			}
		}
		return isidProofNoAvailable;
	}
	
	@Override
	public List<MemberEntity> viewAllMembers(String userEmail) {
		Session session = null;
		List<MemberEntity> resultList;
		Query query = null;
		String GETALL_QUERY ="from MemberEntity where userEmail='"+userEmail+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(GETALL_QUERY);
			resultList = query.getResultList();
			return resultList;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public int updateMemberCount(String userEmail, int memberCount) {
		Session session = null;
		Transaction transaction  = null;
		Query query = null;
		int increaseCount = ++memberCount;
		String UPDATE_COUNT= "UPDATE RegisterEntity set memberCount="+increaseCount+" WHERE emailId='"+userEmail+"'";
		int count = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery(UPDATE_COUNT);
			count = query.executeUpdate();
			transaction.commit();
		}
		catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			System.out.println("transaction rolled back");
		}
		finally {
			if(session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return count;
	}

	@Override
	public int getMemberCount(String userEmail) {
		Session session  = null;
		Query query = null;
		RegisterEntity entity = null;
		String getCount = "from RegisterEntity where emailId='"+userEmail+"'";
		int count = 0;
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(getCount);
			entity = (RegisterEntity)query.uniqueResult();
			count = entity.getMemberCount();
			System.out.println(count);
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public MemberEntity getMemberEntityByID(int memberId) {
		
		System.out.println("Invoked getMemberEntityByID()..");
		Session session=null;
		MemberEntity entity=null;
		
		try
		{
			session=sessionFactory.openSession();
			entity=session.get(MemberEntity.class,memberId);
			if(entity!=null)
			{
				System.out.println("MemberEntity found..");
				return entity;
			}
			
		}
		finally {
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
			
		}
		return entity;
		
	}

	@Override
	public boolean deleteMemberEntityByIdProofNo(String idProofNo) {
		
		System.out.println("Invoked deleteMemberEntityByIdProofNo()..");
		Session session=null;
		MemberEntity entity=null;
		Transaction transaction  = null;
		Query query=null;
		boolean isDataDeleted = false;
		String hql="delete from MemberEntity where idProofNo='"+idProofNo+"'";
		try
		{
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("MemberEntity deleted..");
			transaction.commit();
			isDataDeleted = true;
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
		return isDataDeleted;
	
	}
	
	@Override
	public boolean updateMemberEntity(MemberEntity entity) {
		System.out.println("Invoked updateMemberEntity()..");
		Session session=null;
		Transaction transaction=null;
		boolean isDataSaved = false;
		
		try
		{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			System.out.println("Entity has been updated");
			isDataSaved = true;
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
	public MemberEntity getMemberEntityByIdProofNo(String idProofNo) {
		
		System.out.println("Invoked getMemberEntityByIdProofNo()..");
		Session session=null;
		MemberEntity entity=null;
		String hql="from MemberEntity where idProofNo='"+idProofNo+"'";
		try
		{
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			entity=(MemberEntity) query.uniqueResult();
			if(entity!=null)
			{
				System.out.println("MemberEntity found..");
				return entity;
			}
			
		}
		finally {
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
			
		}
		return entity;
	}

	@Override
	public int decreaseMemberCount(String userEmail, int memberCount) {
		Session session = null;
		Query query = null;
		Transaction transaction = null;
		int increaseCount = --memberCount;
		int count=0;
		String hql= "UPDATE RegisterEntity set memberCount="+increaseCount+" WHERE emailId='"+userEmail+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			transaction = session.beginTransaction();
			count = query.executeUpdate();
			transaction.commit();
		}catch(HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("Transaction has been rolled back "+ hibernateException.getMessage());
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return count;
	}
	

}
