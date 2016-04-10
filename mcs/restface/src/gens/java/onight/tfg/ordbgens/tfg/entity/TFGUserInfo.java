package onight.tfg.ordbgens.tfg.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFG_USER_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class TFGUserInfo extends TFGUserInfoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.NICKNAME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.PARENT_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.RECOMMEND_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Long recommendId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.USER_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String userType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.SECURITY_EMAIL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String securityEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.REAL_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.ID_NO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String idNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.UPDATE_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.CREATE_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.QQ_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String qqId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.WECHAT_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String wechatId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.MOBILE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.EMAIL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.RENREN
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String renren;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.WEIBO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String weibo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.FACE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Integer face;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.FACE_URL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String faceUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.GENDER
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Integer gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.BIRTHDAY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.COUNTRY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.PROVINCE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.CITY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.HOME_ADDRESS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String homeAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.WORK_ADDRESS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String workAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.MOBILE1
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String mobile1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.MOBILE2
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String mobile2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.MOBILE3
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String mobile3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.MOBILEHIS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String mobilehis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.REMARK
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.REG_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private Date regTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_INFO.REG_IP
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    private String regIp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.NICKNAME
     *
     * @return the value of TFG_USER_INFO.NICKNAME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.NICKNAME
     *
     * @param nickname the value for TFG_USER_INFO.NICKNAME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.PARENT_ID
     *
     * @return the value of TFG_USER_INFO.PARENT_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.PARENT_ID
     *
     * @param parentId the value for TFG_USER_INFO.PARENT_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.RECOMMEND_ID
     *
     * @return the value of TFG_USER_INFO.RECOMMEND_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Long getRecommendId() {
        return recommendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.RECOMMEND_ID
     *
     * @param recommendId the value for TFG_USER_INFO.RECOMMEND_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.USER_TYPE
     *
     * @return the value of TFG_USER_INFO.USER_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.USER_TYPE
     *
     * @param userType the value for TFG_USER_INFO.USER_TYPE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.SECURITY_EMAIL
     *
     * @return the value of TFG_USER_INFO.SECURITY_EMAIL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getSecurityEmail() {
        return securityEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.SECURITY_EMAIL
     *
     * @param securityEmail the value for TFG_USER_INFO.SECURITY_EMAIL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setSecurityEmail(String securityEmail) {
        this.securityEmail = securityEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.REAL_NAME
     *
     * @return the value of TFG_USER_INFO.REAL_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.REAL_NAME
     *
     * @param realName the value for TFG_USER_INFO.REAL_NAME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.STATUS
     *
     * @return the value of TFG_USER_INFO.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.STATUS
     *
     * @param status the value for TFG_USER_INFO.STATUS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.ID_NO
     *
     * @return the value of TFG_USER_INFO.ID_NO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.ID_NO
     *
     * @param idNo the value for TFG_USER_INFO.ID_NO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.UPDATE_TIME
     *
     * @return the value of TFG_USER_INFO.UPDATE_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.UPDATE_TIME
     *
     * @param updateTime the value for TFG_USER_INFO.UPDATE_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.CREATE_TIME
     *
     * @return the value of TFG_USER_INFO.CREATE_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.CREATE_TIME
     *
     * @param createTime the value for TFG_USER_INFO.CREATE_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.QQ_ID
     *
     * @return the value of TFG_USER_INFO.QQ_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getQqId() {
        return qqId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.QQ_ID
     *
     * @param qqId the value for TFG_USER_INFO.QQ_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.WECHAT_ID
     *
     * @return the value of TFG_USER_INFO.WECHAT_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.WECHAT_ID
     *
     * @param wechatId the value for TFG_USER_INFO.WECHAT_ID
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.MOBILE
     *
     * @return the value of TFG_USER_INFO.MOBILE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.MOBILE
     *
     * @param mobile the value for TFG_USER_INFO.MOBILE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.EMAIL
     *
     * @return the value of TFG_USER_INFO.EMAIL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.EMAIL
     *
     * @param email the value for TFG_USER_INFO.EMAIL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.RENREN
     *
     * @return the value of TFG_USER_INFO.RENREN
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getRenren() {
        return renren;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.RENREN
     *
     * @param renren the value for TFG_USER_INFO.RENREN
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setRenren(String renren) {
        this.renren = renren;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.WEIBO
     *
     * @return the value of TFG_USER_INFO.WEIBO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getWeibo() {
        return weibo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.WEIBO
     *
     * @param weibo the value for TFG_USER_INFO.WEIBO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.FACE
     *
     * @return the value of TFG_USER_INFO.FACE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Integer getFace() {
        return face;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.FACE
     *
     * @param face the value for TFG_USER_INFO.FACE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setFace(Integer face) {
        this.face = face;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.FACE_URL
     *
     * @return the value of TFG_USER_INFO.FACE_URL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.FACE_URL
     *
     * @param faceUrl the value for TFG_USER_INFO.FACE_URL
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.GENDER
     *
     * @return the value of TFG_USER_INFO.GENDER
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.GENDER
     *
     * @param gender the value for TFG_USER_INFO.GENDER
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.BIRTHDAY
     *
     * @return the value of TFG_USER_INFO.BIRTHDAY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.BIRTHDAY
     *
     * @param birthday the value for TFG_USER_INFO.BIRTHDAY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.COUNTRY
     *
     * @return the value of TFG_USER_INFO.COUNTRY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.COUNTRY
     *
     * @param country the value for TFG_USER_INFO.COUNTRY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.PROVINCE
     *
     * @return the value of TFG_USER_INFO.PROVINCE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.PROVINCE
     *
     * @param province the value for TFG_USER_INFO.PROVINCE
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.CITY
     *
     * @return the value of TFG_USER_INFO.CITY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.CITY
     *
     * @param city the value for TFG_USER_INFO.CITY
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.HOME_ADDRESS
     *
     * @return the value of TFG_USER_INFO.HOME_ADDRESS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.HOME_ADDRESS
     *
     * @param homeAddress the value for TFG_USER_INFO.HOME_ADDRESS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.WORK_ADDRESS
     *
     * @return the value of TFG_USER_INFO.WORK_ADDRESS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getWorkAddress() {
        return workAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.WORK_ADDRESS
     *
     * @param workAddress the value for TFG_USER_INFO.WORK_ADDRESS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.MOBILE1
     *
     * @return the value of TFG_USER_INFO.MOBILE1
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getMobile1() {
        return mobile1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.MOBILE1
     *
     * @param mobile1 the value for TFG_USER_INFO.MOBILE1
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.MOBILE2
     *
     * @return the value of TFG_USER_INFO.MOBILE2
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getMobile2() {
        return mobile2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.MOBILE2
     *
     * @param mobile2 the value for TFG_USER_INFO.MOBILE2
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.MOBILE3
     *
     * @return the value of TFG_USER_INFO.MOBILE3
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getMobile3() {
        return mobile3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.MOBILE3
     *
     * @param mobile3 the value for TFG_USER_INFO.MOBILE3
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.MOBILEHIS
     *
     * @return the value of TFG_USER_INFO.MOBILEHIS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getMobilehis() {
        return mobilehis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.MOBILEHIS
     *
     * @param mobilehis the value for TFG_USER_INFO.MOBILEHIS
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setMobilehis(String mobilehis) {
        this.mobilehis = mobilehis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.REMARK
     *
     * @return the value of TFG_USER_INFO.REMARK
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.REMARK
     *
     * @param remark the value for TFG_USER_INFO.REMARK
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.REG_TIME
     *
     * @return the value of TFG_USER_INFO.REG_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.REG_TIME
     *
     * @param regTime the value for TFG_USER_INFO.REG_TIME
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_INFO.REG_IP
     *
     * @return the value of TFG_USER_INFO.REG_IP
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public String getRegIp() {
        return regIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_INFO.REG_IP
     *
     * @param regIp the value for TFG_USER_INFO.REG_IP
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
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
        TFGUserInfo other = (TFGUserInfo) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getRecommendId() == null ? other.getRecommendId() == null : this.getRecommendId().equals(other.getRecommendId()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getSecurityEmail() == null ? other.getSecurityEmail() == null : this.getSecurityEmail().equals(other.getSecurityEmail()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIdNo() == null ? other.getIdNo() == null : this.getIdNo().equals(other.getIdNo()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getQqId() == null ? other.getQqId() == null : this.getQqId().equals(other.getQqId()))
            && (this.getWechatId() == null ? other.getWechatId() == null : this.getWechatId().equals(other.getWechatId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getRenren() == null ? other.getRenren() == null : this.getRenren().equals(other.getRenren()))
            && (this.getWeibo() == null ? other.getWeibo() == null : this.getWeibo().equals(other.getWeibo()))
            && (this.getFace() == null ? other.getFace() == null : this.getFace().equals(other.getFace()))
            && (this.getFaceUrl() == null ? other.getFaceUrl() == null : this.getFaceUrl().equals(other.getFaceUrl()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getHomeAddress() == null ? other.getHomeAddress() == null : this.getHomeAddress().equals(other.getHomeAddress()))
            && (this.getWorkAddress() == null ? other.getWorkAddress() == null : this.getWorkAddress().equals(other.getWorkAddress()))
            && (this.getMobile1() == null ? other.getMobile1() == null : this.getMobile1().equals(other.getMobile1()))
            && (this.getMobile2() == null ? other.getMobile2() == null : this.getMobile2().equals(other.getMobile2()))
            && (this.getMobile3() == null ? other.getMobile3() == null : this.getMobile3().equals(other.getMobile3()))
            && (this.getMobilehis() == null ? other.getMobilehis() == null : this.getMobilehis().equals(other.getMobilehis()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getRegIp() == null ? other.getRegIp() == null : this.getRegIp().equals(other.getRegIp()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getRecommendId() == null) ? 0 : getRecommendId().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getSecurityEmail() == null) ? 0 : getSecurityEmail().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIdNo() == null) ? 0 : getIdNo().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getQqId() == null) ? 0 : getQqId().hashCode());
        result = prime * result + ((getWechatId() == null) ? 0 : getWechatId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getRenren() == null) ? 0 : getRenren().hashCode());
        result = prime * result + ((getWeibo() == null) ? 0 : getWeibo().hashCode());
        result = prime * result + ((getFace() == null) ? 0 : getFace().hashCode());
        result = prime * result + ((getFaceUrl() == null) ? 0 : getFaceUrl().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getHomeAddress() == null) ? 0 : getHomeAddress().hashCode());
        result = prime * result + ((getWorkAddress() == null) ? 0 : getWorkAddress().hashCode());
        result = prime * result + ((getMobile1() == null) ? 0 : getMobile1().hashCode());
        result = prime * result + ((getMobile2() == null) ? 0 : getMobile2().hashCode());
        result = prime * result + ((getMobile3() == null) ? 0 : getMobile3().hashCode());
        result = prime * result + ((getMobilehis() == null) ? 0 : getMobilehis().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getRegIp() == null) ? 0 : getRegIp().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_INFO
     *
     * @mbggenerated Sun Apr 10 12:52:27 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nickname=").append(nickname);
        sb.append(", parentId=").append(parentId);
        sb.append(", recommendId=").append(recommendId);
        sb.append(", userType=").append(userType);
        sb.append(", securityEmail=").append(securityEmail);
        sb.append(", realName=").append(realName);
        sb.append(", status=").append(status);
        sb.append(", idNo=").append(idNo);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", qqId=").append(qqId);
        sb.append(", wechatId=").append(wechatId);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", renren=").append(renren);
        sb.append(", weibo=").append(weibo);
        sb.append(", face=").append(face);
        sb.append(", faceUrl=").append(faceUrl);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", homeAddress=").append(homeAddress);
        sb.append(", workAddress=").append(workAddress);
        sb.append(", mobile1=").append(mobile1);
        sb.append(", mobile2=").append(mobile2);
        sb.append(", mobile3=").append(mobile3);
        sb.append(", mobilehis=").append(mobilehis);
        sb.append(", remark=").append(remark);
        sb.append(", regTime=").append(regTime);
        sb.append(", regIp=").append(regIp);
        sb.append("]");
        return sb.toString();
    }
}