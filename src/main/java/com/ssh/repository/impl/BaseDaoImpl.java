package com.ssh.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ssh.repository.BaseDao;

public  class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	@Override
	public <T> boolean addentity(T entity) throws Exception {
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

	@Override
	public <T> T getById(Class<T> clazz, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getById(Class<T> clazz, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getById(Class<T> clazz, Serializable id) throws Exception {
		// TODO Auto-generated method stub
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
