package com.ssh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.entity.Attend;
import com.ssh.page.PageBean;
import com.ssh.repository.BaseRepository;
import com.ssh.service.AttendService;

@Service
@Transactional
public abstract class AttendServiceImpl implements AttendService {
    @Autowired
    private BaseRepository baseDao;

    @Override
    public PageBean<Attend> getAtdPage(String sqlId, Map<String, String> param) {
        // baseDao.queryPageBeanBySqlId(sqlId, param, currentPage, pageSize)
        int currentPage = Integer.parseInt(param.get("currentPage"),1);
        int pageSize = Integer.parseInt(param.get("pageSize"),10);
        return baseDao.queryPageBeanBySqlId(sqlId, param, currentPage,
                pageSize, Attend.class);
    }

}
