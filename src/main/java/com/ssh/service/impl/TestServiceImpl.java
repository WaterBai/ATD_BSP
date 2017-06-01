package com.ssh.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.page.PageBean;
import com.ssh.repository.BaseRepository;
import com.ssh.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService{
    @Autowired
    private BaseRepository baseDao;

    @Override
    public <T> boolean addEntity(T entity) {
        return baseDao.addEntity(entity);
    }

    @Override
    public <T> boolean updateEntity(T entity){
        return baseDao.updateEntity(entity);
    }

    @Override
    public <T> boolean removeEntity(T entity) {
        return baseDao.removeEntity(entity);
    }
    
    @Override
    public <T> T getById(Class<T> clazz, Serializable id){
        return baseDao.getById(clazz, id);
    }

    @Override
    public int excuteBySql(String scriptId,Map<String,String> param){
        String sql = "insert into Person (address, created, phone, remark, username) values ('222', '222', '222', '2222', '2222')";
        return baseDao.excuteBySql(sql);
    }

    @Override
    public List<Map<String,Object>> queryBySql(String scriptId,Map<String,String> param) {
        String sql = "select * from person";
        return baseDao.queryBySql(sql);
    }

    @Override
    public <T> List<T> queryBySql(String scriptId,Map<String,String> param,Class<T> clazz){
        String sql = "select * from person";
        return baseDao.queryBySql(sql,clazz);
    }
    
    @Override
    public <T> PageBean<T> queryPageBySql(String scriptId,
            Map<String, String> param, int currentPage, int pageSize,Class<T> clazz) {
        String sql = "select * from person";
        return baseDao.queryPageBeanBySql(sql, 1, 5,clazz);
    }
    @Override
    public PageBean<Map<String, Object>> queryPageBySql(String scriptId,
            Map<String, String> param, int currentPage, int pageSize) {
        String sql = "select * from person";
        return baseDao.queryPageBeanBySql(sql, 1, 5);
    }

    @Override
    public List<Map<String, Object>> queryBySqlId(String sqlId,
            Map<String, String> param) {
        return baseDao.queryBySqlId(sqlId, param);
    }

    @Override
    public <T> List<T> queryBySqlId(String sqlId, Map<String, String> param,
            Class<T> clazz) {
        // TODO Auto-generated method stub
        return baseDao.queryBySqlId(sqlId, param, clazz);
    }
}
