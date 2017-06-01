package com.ssh.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "attend")
@DynamicUpdate(true)
public class Attend {

    @Id
    @GeneratedValue
    @Column(name = "ATD_ID")
    private Long id;
    
    @Column(name = "ATD_USERNAME")
    private String username;
    
    @Column(name = "ATD_TYPE")
    private String type;
    
    @Column(name = "ATD_PROJECT")
    private String project;
    
    @Column(name = "ATD_WORK")
    private String work;
    
    @Column(name = "START_TIME")
    private String startTime;
    
    @Column(name = "END_TIME")
    private String endTime;
    
    @Column(name = "REMARK")
    private String remark;
    
}