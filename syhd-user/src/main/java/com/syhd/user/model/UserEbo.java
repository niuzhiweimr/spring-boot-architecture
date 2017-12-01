package com.syhd.user.model;

import java.io.Serializable;
import java.util.Date;

public class UserEbo implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2486915169211614223L;
	private String id;
	private String name;
	private String nickname;
	private String pwd;
	private String headimageUrl;
	private Integer registerType;
	private Date registerTime;
	private Date updateTime;
	private Date lastLoginTime;
	private Integer status;
	private Integer sex;
	private Integer score;
	private String province;
	private String city;
	private String ip;
	private String tel;
	private Integer platform;
	private String description;
	private String syhdUserGroupId;
	private String syhdUserLevelId;

    public UserEbo() {
    }

    public UserEbo(String id, String name, String nickname, String pwd, String headimageUrl, Integer registerType, Date registerTime, Date updateTime, Date lastLoginTime, Integer status, Integer sex, Integer score, String province, String city, String ip, String tel, Integer platform, String description, String syhdUserGroupId, String syhdUserLevelId) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.pwd = pwd;
        this.headimageUrl = headimageUrl;
        this.registerType = registerType;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
        this.sex = sex;
        this.score = score;
        this.province = province;
        this.city = city;
        this.ip = ip;
        this.tel = tel;
        this.platform = platform;
        this.description = description;
        this.syhdUserGroupId = syhdUserGroupId;
        this.syhdUserLevelId = syhdUserLevelId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadimageUrl() {
        return headimageUrl;
    }

    public void setHeadimageUrl(String headimageUrl) {
        this.headimageUrl = headimageUrl;
    }

    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSyhdUserGroupId() {
        return syhdUserGroupId;
    }

    public void setSyhdUserGroupId(String syhdUserGroupId) {
        this.syhdUserGroupId = syhdUserGroupId;
    }

    public String getSyhdUserLevelId() {
        return syhdUserLevelId;
    }

    public void setSyhdUserLevelId(String syhdUserLevelId) {
        this.syhdUserLevelId = syhdUserLevelId;
    }

    @Override
    public String toString() {
        return "UserEbo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headimageUrl='" + headimageUrl + '\'' +
                ", registerType=" + registerType +
                ", registerTime=" + registerTime +
                ", updateTime=" + updateTime +
                ", lastLoginTime=" + lastLoginTime +
                ", status=" + status +
                ", sex=" + sex +
                ", score=" + score +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", ip='" + ip + '\'' +
                ", tel='" + tel + '\'' +
                ", platform=" + platform +
                ", description='" + description + '\'' +
                ", syhdUserGroupId='" + syhdUserGroupId + '\'' +
                ", syhdUserLevelId='" + syhdUserLevelId + '\'' +
                '}';
    }
}
