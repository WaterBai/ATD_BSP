package com.ssh.service.impl;

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
public class AttendServiceImpl implements AttendService {
    @Autowired
    private BaseRepository baseDao;

    @Override
    public PageBean<Attend> getAttendPage(Map<String, String> param) {
        int currentPage = Integer.parseInt(param.get("currentPage"));
        int pageSize = Integer.parseInt(param.get("pageSize"));
        return baseDao.queryPageBeanBySqlId("atd.getAttend", param, currentPage,
                pageSize, Attend.class);
    }

    @Override
    public PageBean<Map<String, Object>> getAttendPageMap(
            Map<String, String> param) {
        int currentPage = Integer.parseInt(param.get("currentPage"));
        int pageSize = Integer.parseInt(param.get("pageSize"));
        return baseDao.queryPageBeanBySqlId("atd.getAttend", param, currentPage,
                pageSize);
    }
    
    @Override
    public boolean addAttend(Map<String, String> param) {
        Attend atd = new Attend();
        atd.setProject("22222222");
        atd.setUsername("zh");
        atd.setWork("2222222233333333333");
        return baseDao.addEntity(atd);
    }


}
