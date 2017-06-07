package com.ssh.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.entity.User;
import com.ssh.model.PageBean;
import com.ssh.repository.BaseRepository;
import com.ssh.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private BaseRepository baseDao;

    @Override
    public PageBean<User> getUserPage(Map<String, String> param) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return baseDao.addEntity(user);
    }

    @Override
    public boolean updateUser(User user) {
        return baseDao.updateEntity(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return baseDao.removeEntity(user);
    }

    @Override
    public boolean checkUser(User user) {
        return false;
    }

}
