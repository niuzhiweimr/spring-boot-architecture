package com.syhd.user.eto;

import com.syhd.user.annotation.Validation;
import com.syhd.user.constant.Constant;
import com.syhd.user.util.DateUtil;

import java.sql.Timestamp;

public class UserTokenEto {

    @Validation
    private String id;
    @Validation
    private String token;
    private Timestamp createTime = DateUtil.currTimeStamp();//创建时间默认为添加时间
    private Timestamp updateTime = DateUtil.currTimeStamp();//更新时间的值默认为添加时间
    private Timestamp expireTime = DateUtil.currTimeStamp((long) Constant.TOKEN_EXPIRATION_TIME);//过期时间等于 创建时间 加延时时间
    private Integer status = Constant.TOKEN_YES;//默认为有效
    @Validation
    private String syhdUserId;

    public UserTokenEto() {
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

}
