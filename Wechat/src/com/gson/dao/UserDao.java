package com.gson.dao;

import java.util.List;  

import org.hibernate.Query;  
import org.hibernate.Session;  
  
import com.gson.dao.IUserDao;  
import com.gson.entity.User;  
import com.gson.util.HibernateUtil;  
  
/** 
 * 主要对方法进行编写，在这里主要实现了增加和查询所有的方法，其他的没有实现，在整合Spring过程中会进行再次的封装，到时候会编写所有的方法 
 *  
 * @author song 
 *  
 */  
  
public class UserDao implements IUserDao {  
  
    public void delete(User t) {  
        // TODO Auto-generated method stub  
  
    }  
  
    @SuppressWarnings("unchecked")  
    public List<User> getAll() {  
        Session sesson = HibernateUtil.getSession();  
        // 由于Hibernate4已经没有了HibernateSupport和HibernateTemplate这两个辅助类，可以通过以下实现，  
        Query query = sesson.createQuery("from User");  
        return (List<User>) query.list();  
    }  
  
    public User getById(int id) {  
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    public User getByOpenId(String openId) {  
        Session sesson = HibernateUtil.getSession();
        
        String hql="from User as u where u.openId = '"+openId+"'";
        
        Query query = sesson.createQuery(hql);  
        return (User)query.list().get(0);  
    }  
    
    public void insert(User t) {  
        Session session = HibernateUtil.getSession();  
        session.beginTransaction();  
        session.save(t);  
        session.getTransaction().commit();  
        HibernateUtil.closeSession(session);  
    }  
  
    public void update(User t) {  
        // TODO Auto-generated method stub  
  
    }  
    

  
}  