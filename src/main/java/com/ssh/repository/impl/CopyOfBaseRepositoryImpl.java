package com.ssh.repository.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ssh.page.PageBean;
import com.ssh.repository.BaseRepository;
import com.ssh.resolver.DynamicHibernateStatementBuilder;

@Repository
public class CopyOfBaseRepositoryImpl{

    private static final Logger LOGER = LoggerFactory
            .getLogger(CopyOfBaseRepositoryImpl.class);
    /**
     * 模板缓存
     */
    // protected Map<String, String> templateCache;
    @Autowired
    protected DynamicHibernateStatementBuilder dynamicStatementBuilder;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }


    /**
     * 按HQL查询对象列表.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> List<X> findByHQL(String hql, Object... values) {
        return createHQLQuery(hql, values).list();
    }

    /**
     * 按SQL查询对象列表,并将结果集转换成指定的对象列表
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> List<X> findBySQL(String sql, Object... values) {
        return createSQLQuery(sql, values).list();
    }

    /**
     * 按HQL查询对象列表.
     * 
     * @param values
     *            命名参数,按名称绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> List<X> findByHQL(String hql, Map<String, ?> values) {
        return createHQLQuery(hql, values).list();
    }

    /**
     * 按SQL查询对象列表.
     * 
     * @param sql
     *            SQL查询语句
     * @param values
     *            命名参数,按名称绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> List<X> findBySQL(String sql, Map<String, ?> values) {
        return createSQLQuery(sql, values).list();
    }

    /**
     * 按HQL查询唯一对象.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> X findUniqueByHQL(String hql, Object... values) {
        return (X) createHQLQuery(hql, values).uniqueResult();
    }

    /**
     * 按SQL查询唯一对象.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> X findUniqueBySQL(String sql, Object... values) {
        return (X) createSQLQuery(sql, values).uniqueResult();
    }

    /**
     * 按HQL查询唯一对象.
     * 
     * @param values
     *            命名参数,按名称绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> X findUniqueByHQL(String hql, Map<String, ?> values) {
        return (X) createHQLQuery(hql, values).uniqueResult();
    }

    /**
     * 按HQL查询唯一对象.
     * 
     * @param sql
     *            sql语句
     * @param values
     *            命名参数,按名称绑定.
     */
    @SuppressWarnings("unchecked")
    public <X> X findUniqueBySQL(String sql, Map<String, ?> values) {
        return (X) createSQLQuery(sql, values).uniqueResult();
    }

    /**
     * 执行HQL进行批量修改/删除操作.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     * @return 更新记录数.
     */
    public int batchExecuteHQL(String hql, Object... values) {
        return createHQLQuery(hql, values).executeUpdate();
    }

    /**
     * 执行SQL进行批量修改/删除操作.
     * 
     * @param sql
     *            sql语句
     * @param values
     *            数量可变的参数,按顺序绑定.
     * @return 更新记录数.
     */
    public int batchExecuteSQL(String sql, Object... values) {
        return createSQLQuery(sql, values).executeUpdate();
    }

    /**
     * 执行HQL进行批量修改/删除操作.
     * 
     * @param values
     *            命名参数,按名称绑定.
     * @return 更新记录数.
     */
    public int batchExecuteHQL(String hql, Map<String, ?> values) {
        return createHQLQuery(hql, values).executeUpdate();
    }

    /**
     * 执行SQL进行批量修改/删除操作.
     * 
     * @param values
     *            命名参数,按名称绑定.
     * @return 更新记录数.
     */
    public int batchExecuteSQL(String sql, Map<String, ?> values) {
        return createSQLQuery(sql, values).executeUpdate();
    }

    /**
     * 根据查询HQL与参数列表创建Query对象. 与find()函数可进行更加灵活的操作.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    public Query createHQLQuery(String queryString, Object... values) {
        Query query = this.getCurrentSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    /**
     * 根据查询SQL与参数列表创建Query对象. 与find()函数可进行更加灵活的操作.
     * 
     * @param sqlQueryString
     *            sql语句
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    public Query createSQLQuery(String sqlQueryString, Object... values) {
        Query query = this.getCurrentSession().createSQLQuery(sqlQueryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    /**
     * 根据查询HQL与参数列表创建Query对象. 与find()函数可进行更加灵活的操作.
     * 
     * @param values
     *            命名参数,按名称绑定.
     */
    public Query createHQLQuery(String queryString, Map<String, ?> values) {
        Query query = this.getCurrentSession().createQuery(queryString);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }

    /**
     * 根据查询SQL与参数列表创建Query对象. 与find()函数可进行更加灵活的操作.
     * 
     * @param queryString
     *            SQL语句
     * @param values
     *            命名参数,按名称绑定.
     */
    public Query createSQLQuery(String queryString, Map<String, ?> values) {
        Query query = this.getCurrentSession().createSQLQuery(queryString);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }
}
