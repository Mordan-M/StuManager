package com.xxmodd.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
/**
 * 类名: HibernateDBUtil
 * 描述: DB封装类
 * @author xxmodd
 * @data 2016-12-27 t下午5:05:22
 */
public class HibernateDBUtil {
	private static Session session;
	
	public HibernateDBUtil(Session session) {
		HibernateDBUtil.session = session;
	}
	
	// 添加对象
	public boolean add(Object obj) {
		Transaction tr = null;
		try {
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
		Transaction tr = null;
		try {
//			session = HibernateSessionFactory.getCurrentSession();
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
		Transaction tr = null;
		try {
//			session = HibernateSessionFactory.getCurrentSession();
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
		/* 
		  finally {
			try {
				close();
			} catch (Exception e2) {
				return false;
			}
		}
		 */
	}

	// hql查询对象
	@SuppressWarnings("rawtypes")
	public List hqlQuery(String hql,Object ...parms) {
		List list;
		Transaction tr = null;
		Query query;
		try {
			tr = session.beginTransaction();
			query = session.createQuery(hql);
			//String 类型 ， int 类型 ，其他。
			for(int i=0;i<parms.length;i++){
				/*String classname = parms[i].getClass().getName();
				if(classname.equals("java.lang.String")){
					query.setString(i,(String)parms[i]);
				}else if(classname.equals("java.lang.Integer")){
					query.setInteger(i,(Integer)parms[i]);
				}else {
					query.setTimestamp(i,(Timestamp)parms[i]);
				}*/
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
	/**
	 * @param sql
	 * @param obj
	 * @param parms
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List sqlHbEntityQuery(String sql,Class obj,Object ...parms) {
		List list;
		Transaction tr = null;
		Query query;
		try {
			tr = session.beginTransaction();
			query = session.createSQLQuery(sql).addEntity(obj);
			for(int i=0;i<parms.length;i++){
				/*String classname = parms[i].getClass().getName();
				if(classname.equals("java.lang.String")){
					query.setString(i,(String)parms[i]);
				}else{
					query.setInteger(i,(Integer)parms[i]);
				}*/
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
		List list;
		Transaction tr = null;
		Query query;
		try {
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
	
	// sql查询对象 ，返回Object数组
	@SuppressWarnings("rawtypes")
	public List sqlObjectQuery(String sql, Object... parms) {
		List<Object[]> list;
		Transaction tr = null;
		Query query;
		try {
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
//		return list.size()==0? null : (Object)list.get(0);
		return list;
	}
	
	// sql执行更新或删除
	public boolean sqlExecute(String sql,Object ...parms) {
		int result;
		Transaction tr = null;
		SQLQuery  query;
		try {
			tr = session.beginTransaction();
			query = session.createSQLQuery(sql);
			for(int i=0;i<parms.length;i++){
				/*String classname = parms[i].getClass().getName();
				if(classname.equals("java.lang.String")){
					query.setString(i,(String)parms[i]);
				}else{
					query.setInteger(i,(Integer)parms[i]);
				}*/
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
	
	// 关闭session
	private static void close() {
//		HibernateSessionFactory.closeCurrentSession();
		session.close();
	}
}
