package com.wechat.test;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.gson.dao.UserDao;
import com.gson.entity.User;
import com.gson.util.HibernateUtil;

public class HibernateEntityTest {
	
	@Test  
    /** 
     * 测试2，用来测试创建表数据 
     */
	/*
    public void testCreate() {  
        User u1 = new User("song");  
        Session session = HibernateUtil.getSession();  
        session.beginTransaction();  
        session.save(u1);  
        session.getTransaction().commit();  
        HibernateUtil.closeSession(session);  
    }
    */
	public void testUserDao(){
		UserDao userDao = new UserDao();
		User u=userDao.getByOpenId("song");
		assertEquals(1, u.getId());
		
	}
	
}
