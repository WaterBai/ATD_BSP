package com.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.entity.Person;
import com.ssh.repository.BaseDao;
import com.ssh.service.BaseService;

@Service
@Transactional
public class BaseServiceImpl implements BaseService{
    @Autowired
    private BaseDao baseDao;

    //@Transactional
    public boolean savePerson(){
        Person person = new Person();
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        return baseDao.addEntity(person);
    }

    @Override
    public <T> T load(Class<T> clazz, Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T get(Class<T> clazz, Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> boolean addEntity(T entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> boolean updateEntity(T entity) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> boolean removeEntity(T entity) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    /*@Override
    public <T> T getById(Class<T> clazz, int id) throws Exception {
        return baseDao.getById(clazz, id);
    }*/
    
    @Override
    public <T> T getById(Class<T> clazz, Serializable id){
        try {
            return baseDao.getById(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int executeSql(String sql) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T> List<T> executeSqlQuery(String sql) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
