package com.xxmodd.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
/**
 * 类名: HibernateDBUtil
 * 描述: DB封装类
 * @author xxmodd
 * @data 2016-12-27 t下午5:05:22
 */
public class HibernateDBUtil {
	
	private SessionFactory sessionFactory;
	
	public HibernateDBUtil(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 添加对象
	public boolean add(Object obj) {
		Session session;
		Transaction tr = null;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			session.save(obj);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return false;
			}
			return false;
		} 
	}

	// 修改对象,对象信息必须完整
	public boolean update(Object obj) {
		Session session;
		Transaction tr = null;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			session.update(obj);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return false;
			}
			return false;
		}
	}
	
	// 删除对象，对象只需要传入主键信息
	public boolean delete(Object obj) {
		Session session;
		Transaction tr = null;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			session.delete(obj);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return false;
			}
			return false;
		} 
	}

	// hql查询对象
	@SuppressWarnings("rawtypes")
	public List hqlQuery(String hql,Object ...parms) {
		Session session;
		List list;
		Transaction tr = null;
		Query query;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			query = session.createQuery(hql);
			for(int i=0;i<parms.length;i++){
				query.setParameter(i ,parms[i] );
			}
			list = query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
		}
		return list;
	}

	
	// sql查询对象 ，并包装成hibernate关联对象
	@SuppressWarnings("rawtypes")
	public List sqlHbEntityQuery(String sql,Class obj,Object ...parms) {
		Session session;
		List list;
		Transaction tr = null;
		Query query;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			query = session.createSQLQuery(sql).addEntity(obj);
			for(int i=0;i<parms.length;i++){
				query.setParameter(i ,parms[i] );
			}
			list = query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
		} 
		return list;
	}
	
	// sql查询对象 ，并包装成不受Hibernate管理的实体。
	@SuppressWarnings("rawtypes")
	public List sqlEntityQuery(String sql, Class obj, Object... parms) {
		Session session;
		List list;
		Transaction tr = null;
		Query query;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			query = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(obj));
			for (int i = 0; i < parms.length; i++) {
				query.setParameter(i, parms[i]);
			}
			list = query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
		}
		return list;
	}
	
	// sql查询对象 ，返回List<Object[]>
	@SuppressWarnings("rawtypes")
	public List sqlObjectQuery(String sql, Object... parms) {
		Session session;
		List list;
		Transaction tr = null;
		Query query;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			query = session.createSQLQuery(sql);
			for (int i = 0; i < parms.length; i++) {
				query.setParameter(i, parms[i]);
			}
			list = query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
		}
		return list;
	}
	
	// sql执行更新或删除
	public boolean sqlExecute(String sql,Object ...parms) {
		Session session;
		int result;
		Transaction tr = null;
		SQLQuery  query;
		try {
			session = sessionFactory.getCurrentSession();
			tr = session.beginTransaction();
			query = session.createSQLQuery(sql);
			for(int i=0;i<parms.length;i++){
				query.setParameter(i ,parms[i] );
			}
			result = query.executeUpdate();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				tr.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
				return false;
			}
			return false;
		} 
		if(result!=1){
			return false;
		}
		return true;
	}
}
