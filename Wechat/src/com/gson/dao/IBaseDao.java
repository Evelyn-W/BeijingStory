package com.gson.dao;
import java.util.List;  

/** 
 * 将常用的数据库增删改查进行封装 
 *  
 * @author song
 *  
 * @param <T> 
 */  
public interface IBaseDao<T> {  
    /** 
     * 保存对象 
     *  
     * @param t 
     * @return 
     */  
    public void insert(T t);  
  
    /** 
     * 删除对象 
     *  
     * @param t 
     * @return 
     */  
    public void delete(T t);  
  
    /** 
     * 更新对象 
     *  
     * @param t 
     * @return 
     */  
    public void update(T t);  
  
    /** 
     * 根据Id查找单个对象 
     *  
     * @param id 
     * @return 
     */  
    public T getById(int id);  
  
    /** 
     * 查询对象集合 
     *  
     * @return 
     */  
    public List<T> getAll();  
}  