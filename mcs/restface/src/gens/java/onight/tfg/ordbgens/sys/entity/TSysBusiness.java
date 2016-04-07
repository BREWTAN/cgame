package onight.tfg.ordbgens.sys.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_SYS_BUSINESS")
@AllArgsConstructor
@NoArgsConstructor
public class TSysBusiness extends TSysBusinessKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.BUSINESS_NAME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private String businessName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.BUSINESS_DESC
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private String businessDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.BUSINESS_MANAGER
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private String businessManager;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.BUSINESS_MOBILE
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private String businessMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.BUSINESS_SEQ
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private Integer businessSeq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.BEGIN_TIME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private Date beginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.END_TIME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.STATUS
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_BUSINESS.BUSINESS_DATA_PERMISSION
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    private Integer businessDataPermission;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.BUSINESS_NAME
     *
     * @return the value of T_SYS_BUSINESS.BUSINESS_NAME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.BUSINESS_NAME
     *
     * @param businessName the value for T_SYS_BUSINESS.BUSINESS_NAME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.BUSINESS_DESC
     *
     * @return the value of T_SYS_BUSINESS.BUSINESS_DESC
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public String getBusinessDesc() {
        return businessDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.BUSINESS_DESC
     *
     * @param businessDesc the value for T_SYS_BUSINESS.BUSINESS_DESC
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.BUSINESS_MANAGER
     *
     * @return the value of T_SYS_BUSINESS.BUSINESS_MANAGER
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public String getBusinessManager() {
        return businessManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.BUSINESS_MANAGER
     *
     * @param businessManager the value for T_SYS_BUSINESS.BUSINESS_MANAGER
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setBusinessManager(String businessManager) {
        this.businessManager = businessManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.BUSINESS_MOBILE
     *
     * @return the value of T_SYS_BUSINESS.BUSINESS_MOBILE
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public String getBusinessMobile() {
        return businessMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.BUSINESS_MOBILE
     *
     * @param businessMobile the value for T_SYS_BUSINESS.BUSINESS_MOBILE
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setBusinessMobile(String businessMobile) {
        this.businessMobile = businessMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.BUSINESS_SEQ
     *
     * @return the value of T_SYS_BUSINESS.BUSINESS_SEQ
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public Integer getBusinessSeq() {
        return businessSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.BUSINESS_SEQ
     *
     * @param businessSeq the value for T_SYS_BUSINESS.BUSINESS_SEQ
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setBusinessSeq(Integer businessSeq) {
        this.businessSeq = businessSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.BEGIN_TIME
     *
     * @return the value of T_SYS_BUSINESS.BEGIN_TIME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.BEGIN_TIME
     *
     * @param beginTime the value for T_SYS_BUSINESS.BEGIN_TIME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.END_TIME
     *
     * @return the value of T_SYS_BUSINESS.END_TIME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.END_TIME
     *
     * @param endTime the value for T_SYS_BUSINESS.END_TIME
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.STATUS
     *
     * @return the value of T_SYS_BUSINESS.STATUS
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.STATUS
     *
     * @param status the value for T_SYS_BUSINESS.STATUS
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_BUSINESS.BUSINESS_DATA_PERMISSION
     *
     * @return the value of T_SYS_BUSINESS.BUSINESS_DATA_PERMISSION
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public Integer getBusinessDataPermission() {
        return businessDataPermission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_BUSINESS.BUSINESS_DATA_PERMISSION
     *
     * @param businessDataPermission the value for T_SYS_BUSINESS.BUSINESS_DATA_PERMISSION
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    public void setBusinessDataPermission(Integer businessDataPermission) {
        this.businessDataPermission = businessDataPermission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
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
        TSysBusiness other = (TSysBusiness) that;
        return (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getBusinessName() == null ? other.getBusinessName() == null : this.getBusinessName().equals(other.getBusinessName()))
            && (this.getBusinessDesc() == null ? other.getBusinessDesc() == null : this.getBusinessDesc().equals(other.getBusinessDesc()))
            && (this.getBusinessManager() == null ? other.getBusinessManager() == null : this.getBusinessManager().equals(other.getBusinessManager()))
            && (this.getBusinessMobile() == null ? other.getBusinessMobile() == null : this.getBusinessMobile().equals(other.getBusinessMobile()))
            && (this.getBusinessSeq() == null ? other.getBusinessSeq() == null : this.getBusinessSeq().equals(other.getBusinessSeq()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBusinessDataPermission() == null ? other.getBusinessDataPermission() == null : this.getBusinessDataPermission().equals(other.getBusinessDataPermission()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getBusinessName() == null) ? 0 : getBusinessName().hashCode());
        result = prime * result + ((getBusinessDesc() == null) ? 0 : getBusinessDesc().hashCode());
        result = prime * result + ((getBusinessManager() == null) ? 0 : getBusinessManager().hashCode());
        result = prime * result + ((getBusinessMobile() == null) ? 0 : getBusinessMobile().hashCode());
        result = prime * result + ((getBusinessSeq() == null) ? 0 : getBusinessSeq().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBusinessDataPermission() == null) ? 0 : getBusinessDataPermission().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_BUSINESS
     *
     * @mbggenerated Thu Apr 07 10:12:35 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", businessName=").append(businessName);
        sb.append(", businessDesc=").append(businessDesc);
        sb.append(", businessManager=").append(businessManager);
        sb.append(", businessMobile=").append(businessMobile);
        sb.append(", businessSeq=").append(businessSeq);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", businessDataPermission=").append(businessDataPermission);
        sb.append("]");
        return sb.toString();
    }
}