package com.ssh.repository.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.entity.PageResults;
import com.ssh.repository.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public <T> boolean addEntity(T entity) {
        boolean bool = false;
        try {
            Serializable ser = (Serializable) this.getCurrentSession().save(
                    entity);
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
    public <T> boolean updateEntity(T entity) {
        try {
            this.getCurrentSession().update(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> boolean saveOrUpdateEntity(T entity) {
        try {
            this.getCurrentSession().saveOrUpdate(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> boolean removeEntity(T entity) {
        try {
            this.getCurrentSession().delete(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getById(Class<T> clazz, Serializable id) {
        T t = null;
        try {
            t = (T) this.getCurrentSession().get(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T loadById(Class<T> clazz, Serializable id) {
        T t = null;
        try {
            t = (T) this.getCurrentSession().load(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public int excuteBySql(String sql) {
        int result = -1;
        try {
            SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
            result = query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> queryBySql(String sql,Class<T> clazz) {
        try {
            Query query = this.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
            List<T> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> queryBySql(String sql) {
        try {
            Query query = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            List<Map<String, Object>> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> PageResults<T> queryPageBySql(String sql, int currentPage, int pageSize, Class<T> clazz) {
        long l = System.currentTimeMillis();
        int totalCount = 0;
        List<T> results = null;
        String countSql = (new StringBuilder())
                .append("SELECT COUNT(1) FROM (").append(sql).append(") T")
                .toString();
        Query query = this.sessionFactory.getCurrentSession().createSQLQuery(
                countSql);
        List<BigInteger> list = query.list();
        totalCount = list.get(0).intValue();
        System.out.println((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms")
                .toString());
        l = System.currentTimeMillis();
        if (totalCount > 0) {
            if (currentPage < 1)
                currentPage = 1;
            int min = (currentPage - 1) * pageSize + 1;
            int max = currentPage * pageSize;
            if (totalCount < min) {
                currentPage = 1;
                min = 1;
                max = pageSize;
            }
            String limitSql = (new StringBuilder()).append("SELECT * FROM (")
                    .append(sql).append(") T_T LIMIT ").append(min - 1)
                    .append(",").append((max - min) + 1).toString();
            results = this.queryBySql(limitSql, clazz);
        }
        System.out.println((new StringBuilder()).append("查询时间:")
                .append(System.currentTimeMillis() - l).append("ms")
                .toString());
        PageResults<T> page = new PageResults<T>(currentPage, pageSize,
                totalCount, results);
        return page;
    }
    @SuppressWarnings("unchecked")
    @Override
    public PageResults<Map<String, Object>> queryPageBySql(String sql, int currentPage,
            int pageSize) {
        long l = System.currentTimeMillis();
        int totalCount = 0;
        List<Map<String, Object>> results = null;
        String countSql = (new StringBuilder())
                .append("SELECT COUNT(1) FROM (").append(sql).append(") T")
                .toString();
        Query query = this.sessionFactory.getCurrentSession().createSQLQuery(
                countSql);
        List<BigInteger> list = query.list();
        totalCount = list.get(0).intValue();
        System.out.println((new StringBuilder()).append("查询时间:")
                        .append(System.currentTimeMillis() - l).append("ms")
                        .toString());
        l = System.currentTimeMillis();
        if (totalCount > 0) {
            if (currentPage < 1)
                currentPage = 1;
            int min = (currentPage - 1) * pageSize + 1;
            int max = currentPage * pageSize;
            if (totalCount < min) {
                currentPage = 1;
                min = 1;
                max = pageSize;
            }
            String limitSql = (new StringBuilder()).append("SELECT * FROM (")
                    .append(sql).append(") T_T LIMIT ").append(min - 1)
                    .append(",").append((max - min) + 1).toString();
            results = this.queryBySql(limitSql);
        }
        System.out.println((new StringBuilder()).append("查询时间:")
                        .append(System.currentTimeMillis() - l).append("ms")
                        .toString());
        PageResults<Map<String, Object>> page = new PageResults<Map<String, Object>>(currentPage, pageSize,
                totalCount, results);
        return page;
    }
}
