package com.ssh.entity;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @author Administrator
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    public final static int DELETE_FLAG_YES = 1;
    public final static int DELETE_FLAG_NO = 0;

    /**
     * 主键标示
     */
    @Id
    @GeneratedValue(generator = "_increment")
    @GenericGenerator(name = "_increment", strategy = "increment")
    @Column(length = 32)
    private Integer pid;

    /**
     * 删除标志  1已经删除，0 正常
     */
    @Column(precision = 1, name = "delete_flag")
    private Integer deleteFlag = DELETE_FLAG_NO;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDate createTime = LocalDate.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")

    private LocalDate lastModifiedDate = LocalDate.now();

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}