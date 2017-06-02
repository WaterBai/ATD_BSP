package com.ssh.service;

import java.util.Map;

import com.ssh.entity.Attend;
import com.ssh.page.PageBean;

public interface AttendService {

    public PageBean<Attend> getAttendPage(Map<String, String> param);
    
    public PageBean<Map<String, Object>> getAttendPageMap(Map<String, String> param);

    public boolean addAttend(Map<String, String> param);

}
