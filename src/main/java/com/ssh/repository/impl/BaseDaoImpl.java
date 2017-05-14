package com.ssh.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.repository.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T load(Class<T> clazz, Serializable id) {
        return (T) this.getCurrentSession().load(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Class<T> clazz, Serializable id) {
        return (T) this.getCurrentSession().get(clazz, id);
    }

    @Override
    public <T> boolean addEntity(T entity) {
        boolean bool = false;
        try {
            Serializable ser = (Serializable) this.getCurrentSession().save(entity);
            if (ser != null) {
                bool = true;
            }
        } catch (Exception e) {
            bool = false;
            e.printStackTrace();
        }
        return bool;
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

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getById(Class<T> clazz, Serializable id) throws Exception {
        T t = null;
        try {
            t = (T) this.getCurrentSession().get(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
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
