package com.ssh.service;

import java.util.List;
import java.util.Map;

import com.ssh.entity.Attend;
import com.ssh.page.PageBean;

public interface AttendService {
    
    public  PageBean<Attend> getAtdPage(String sqlId,Map<String,String> param);
    public  PageBean<Attend> addAtdPage(String sqlId,Map<String,String> param);
    
    

}
