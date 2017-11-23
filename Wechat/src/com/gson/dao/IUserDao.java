package com.gson.dao;

import com.gson.entity.User;  

/** 
 * 用来继承接口，如果有个别自己的方法可以在此进行添加 
 *  
 * @author song 
 *  
 */  
public interface IUserDao extends IBaseDao<User> {  
    /** 
     * 根据openId查找user
     *  
     * @param id 
     * @return 
     */  
    public User getByOpenId(String openId);  
  
}  