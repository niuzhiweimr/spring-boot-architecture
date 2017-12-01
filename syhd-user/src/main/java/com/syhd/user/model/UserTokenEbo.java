package com.syhd.user.model;

import java.io.Serializable;
import java.sql.Timestamp;
public class UserTokenEbo implements Serializable{

    private static final long serialVersionUID = 6515564869866330659L;
    private String id;
    private String token;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp expireTime;
    private Integer status;
    private String syhdUserId;

    public UserTokenEbo() {
    }

    public UserTokenEbo(String id, String token, Timestamp createTime, Timestamp updateTime, Timestamp expireTime, Integer status, String syhdUserId) {
        this.id = id;
        this.token = token;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expireTime = expireTime;
        this.status = status;
        this.syhdUserId = syhdUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSyhdUserId() {
        return syhdUserId;
    }

    public void setSyhdUserId(String syhdUserId) {
        this.syhdUserId = syhdUserId;
    }

    @Override
    public String toString() {
        return "UserTokenEbo{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", expireTime=" + expireTime +
                ", status=" + status +
                ", syhdUserId='" + syhdUserId + '\'' +
                '}';
    }

}
