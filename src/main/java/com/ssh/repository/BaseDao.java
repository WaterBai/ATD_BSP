package com.ssh.repository;

import java.io.Serializable;
import java.util.List;

public interface BaseDao{
    
    /**
     * 按id加载数据
     * @param clazz
     * @param id
     * @return
     */
    public <T> T load(Class<T> clazz,Serializable id);

    /**
     * 按id加载数据
     * @param clazz
     * @param id
     * @return
     */
    public <T> T get(Class<T> clazz,Serializable id);
    
    /** 
     * 增加一个entity对象，返回是否添加成功 
     * @param T 对象类型 
     * @param entity 实体类 
     * @return boolean true/false 
     * @throws Exception 
     * */  
    public <T> boolean addEntity(T entity);  

   
    /**  
     * 修改实体的数据，返回boolean结果 
     * @param entity 
     * @return boolean 
     * @throws Exception 
     * */  
    public <T> boolean updateEntity(T entity) throws Exception;  
   
    /**  
     * 传入要删除的实体，返回boolean结果 
     * @param entity 
     * @return boolean 
     * @throws Exception 
     * */  
    public <T> boolean removeEntity(T entity) throws Exception;
 
    /**  
     * 传入要实体类的class和Serializable主键，返回具体实体 
     * @param clazz 
     * @param id 
     * @return T 
     * @throws Exception 
     * */  
    public <T> T getById(Class<T> clazz,Serializable id) throws Exception;  

    /** 
     * 执行sql语句，实行增，删，改 
     * @author ending 
     * @param sql 
     * @return Integer 
     * @throws Exception 
     * */  
    public int executeSql(String sql) throws Exception;  
    
    /**  
     * 执行sql查询语句，获取list集合 
     * @param sql 
     * @return List 
     * @throws Exception 
     * */  
    public <T> List<T> executeSqlQuery(String sql) throws Exception; 
 
}
