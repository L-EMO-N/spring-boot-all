package com.profession.commons.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "user")
@Entity
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String nickname;

    private Boolean sex;

    private Date birthday;

    private Boolean identity;

    @Column(name = "head_portrait")
    private String headPortrait;

    private String phone;

    private String mail;

    private String qq;

    private String wechat;

    @Column(name = "platform_id")
    private String platformId;

    @Column(name = "platform_type")
    private String platformType;

    private String unionid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    public User withUserId(Integer userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    public User withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    public User withNickname(String nickname) {
        this.setNickname(nickname);
        return this;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * @return sex
     */
    public Boolean getSex() {
        return sex;
    }

    public User withSex(Boolean sex) {
        this.setSex(sex);
        return this;
    }

    /**
     * @param sex
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    public User withBirthday(Date birthday) {
        this.setBirthday(birthday);
        return this;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return identity
     */
    public Boolean getIdentity() {
        return identity;
    }

    public User withIdentity(Boolean identity) {
        this.setIdentity(identity);
        return this;
    }

    /**
     * @param identity
     */
    public void setIdentity(Boolean identity) {
        this.identity = identity;
    }

    /**
     * @return head_portrait
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    public User withHeadPortrait(String headPortrait) {
        this.setHeadPortrait(headPortrait);
        return this;
    }

    /**
     * @param headPortrait
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    public User withPhone(String phone) {
        this.setPhone(phone);
        return this;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    public User withMail(String mail) {
        this.setMail(mail);
        return this;
    }

    /**
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    public User withQq(String qq) {
        this.setQq(qq);
        return this;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * @return wechat
     */
    public String getWechat() {
        return wechat;
    }

    public User withWechat(String wechat) {
        this.setWechat(wechat);
        return this;
    }

    /**
     * @param wechat
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * @return platform_id
     */
    public String getPlatformId() {
        return platformId;
    }

    public User withPlatformId(String platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    /**
     * @param platformId
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    /**
     * @return platform_type
     */
    public String getPlatformType() {
        return platformType;
    }

    public User withPlatformType(String platformType) {
        this.setPlatformType(platformType);
        return this;
    }

    /**
     * @param platformType
     */
    public void setPlatformType(String platformType) {
        this.platformType = platformType == null ? null : platformType.trim();
    }

    /**
     * @return unionid
     */
    public String getUnionid() {
        return unionid;
    }

    public User withUnionid(String unionid) {
        this.setUnionid(unionid);
        return this;
    }

    /**
     * @param unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    public User withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public User withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", identity=").append(identity);
        sb.append(", headPortrait=").append(headPortrait);
        sb.append(", phone=").append(phone);
        sb.append(", mail=").append(mail);
        sb.append(", qq=").append(qq);
        sb.append(", wechat=").append(wechat);
        sb.append(", platformId=").append(platformId);
        sb.append(", platformType=").append(platformType);
        sb.append(", unionid=").append(unionid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getHeadPortrait() == null ? other.getHeadPortrait() == null : this.getHeadPortrait().equals(other.getHeadPortrait()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getMail() == null ? other.getMail() == null : this.getMail().equals(other.getMail()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWechat() == null ? other.getWechat() == null : this.getWechat().equals(other.getWechat()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getPlatformType() == null ? other.getPlatformType() == null : this.getPlatformType().equals(other.getPlatformType()))
            && (this.getUnionid() == null ? other.getUnionid() == null : this.getUnionid().equals(other.getUnionid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getHeadPortrait() == null) ? 0 : getHeadPortrait().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getMail() == null) ? 0 : getMail().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWechat() == null) ? 0 : getWechat().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getPlatformType() == null) ? 0 : getPlatformType().hashCode());
        result = prime * result + ((getUnionid() == null) ? 0 : getUnionid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}