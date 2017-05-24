package com.ssh.repository.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ssh.entity.SqlType;
import com.ssh.entity.StatementTemplate;
import com.ssh.page.PageBean;
import com.ssh.repository.BaseRepository;
import com.ssh.resolver.DynamicHibernateStatementBuilder;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Repository
public class BaseRepositoryImpl implements BaseRepository,InitializingBean {

    private static final Logger LOGER = LoggerFactory
            .getLogger(BaseRepositoryImpl.class);
    /**
     * 模板缓存
     */
    protected Map<String, StatementTemplate> templateCache;
    
    @Autowired
    protected DynamicHibernateStatementBuilder dynamicStatementBuilder;

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
    public <T> List<T> queryBySql(String sql, Class<T> clazz) {
        try {
            Query query = this.getCurrentSession().createSQLQuery(sql)
                    .addEntity(clazz);
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
            Query query = this.getCurrentSession().createSQLQuery(sql)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            List<Map<String, Object>> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> PageBean<T> queryPageBySql(String sql, int currentPage,
            int pageSize, Class<T> clazz) {
        long l = System.currentTimeMillis();
        int totalCount = 0;
        List<T> results = null;
        String countSql = (new StringBuilder())
                .append("SELECT COUNT(1) FROM (").append(sql).append(") T")
                .toString();
        Query query = this.getCurrentSession().createSQLQuery(countSql);
        List<BigInteger> list = query.list();
        totalCount = list.get(0).intValue();
        System.out
                .println((new StringBuilder()).append("查询时间:")
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
        System.out
                .println((new StringBuilder()).append("查询时间:")
                        .append(System.currentTimeMillis() - l).append("ms")
                        .toString());
        PageBean<T> page = new PageBean<T>(currentPage, pageSize, totalCount,
                results);
        return page;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PageBean<Map<String, Object>> queryPageBySql(String sql,
            int currentPage, int pageSize) {
        long l = System.currentTimeMillis();
        int totalCount = 0;
        List<Map<String, Object>> results = null;
        String countSql = (new StringBuilder())
                .append("SELECT COUNT(1) FROM (").append(sql).append(") T")
                .toString();
        Query query = this.getCurrentSession().createSQLQuery(countSql);
        List<BigInteger> list = query.list();
        totalCount = list.get(0).intValue();
        System.out
                .println((new StringBuilder()).append("查询时间:")
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
        System.out
                .println((new StringBuilder()).append("查询时间:")
                        .append(System.currentTimeMillis() - l).append("ms")
                        .toString());
        PageBean<Map<String, Object>> page = new PageBean<Map<String, Object>>(
                currentPage, pageSize, totalCount, results);
        return page;
    }

    @Override
    public List<Map<String, Object>> queryBySql(String scriptId, Map<String, ?> parameters) {
        //String statement = processTemplate(scriptId,parameters);  
        StatementTemplate statementTemplate = templateCache.get(scriptId);  
        String statement = processTemplate(statementTemplate,parameters);  
        if(SqlType.SQL.equals(statementTemplate.getType())){  
            return this.queryBySql(statement);   
        }else{  
            return null;  
        }  
    }

    @Override
    public <T> List<T> queryBySql(String scriptId, Map<String, ?> parameters,
            Class<T> clazz) {
        StatementTemplate statementTemplate = templateCache.get(scriptId);  
        String statement = processTemplate(statementTemplate,parameters);  
        if(SqlType.SQL.equals(statementTemplate.getType())){  
            return this.queryBySql(statement,clazz);   
        }else{  
            return null;  
        }  
    }

    @Override
    public <T> PageBean<T> queryPageBySql(String sqlId, Map<String, ?> values,
            int currentPage, int pageSize, Class<T> clazz) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PageBean<Map<String, Object>> queryPageBySql(String sqlId,
            Map<String, ?> values, int currentPage, int pageSize) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        templateCache = new HashMap<String, StatementTemplate>();  
        if(this.dynamicStatementBuilder == null){  
            throw new RuntimeException("dynamicStatementBuilder is null !!");  
        }  
        dynamicStatementBuilder.init();  
        Map<String,String> namedHQLQueries = dynamicStatementBuilder.getNamedHQLQueries();  
        Map<String,String> namedSQLQueries = dynamicStatementBuilder.getNamedSQLQueries();  
        Configuration configuration = new Configuration();  
        configuration.setNumberFormat("#");  
        StringTemplateLoader stringLoader = new StringTemplateLoader();  
        for(Entry<String, String> entry : namedHQLQueries.entrySet()){  
            stringLoader.putTemplate(entry.getKey(), entry.getValue());  
            templateCache.put(entry.getKey(), new StatementTemplate(SqlType.HQL,new Template(entry.getKey(),new StringReader(entry.getValue()),configuration)));  
        }  
        for(Entry<String, String> entry : namedSQLQueries.entrySet()){  
            stringLoader.putTemplate(entry.getKey(), entry.getValue());  
            templateCache.put(entry.getKey(), new StatementTemplate(SqlType.SQL,new Template(entry.getKey(),new StringReader(entry.getValue()),configuration)));  
        }  
        configuration.setTemplateLoader(stringLoader);  
    }
    protected String processTemplate(StatementTemplate statementTemplate,Map<String, ?> parameters){  
        StringWriter stringWriter = new StringWriter();  
        try {  
            statementTemplate.getTemplate().process(parameters, stringWriter);  
        } catch (Exception e) {  
            LOGER.error("处理DAO查询参数模板时发生错误：{}",e.toString());  
            e.printStackTrace();
        }  
        return stringWriter.toString();  
    }  
}
