package onight.tfg.ordbgens.sys.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_SYS_RSP_CODE")
@AllArgsConstructor
@NoArgsConstructor
public class TSysRspCode extends TSysRspCodeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_RSP_CODE.PROD_ID
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    private String prodId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_RSP_CODE.OUT_RSP_CODE
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    private String outRspCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_RSP_CODE.IN_RSP_CODE2
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    private String inRspCode2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_RSP_CODE.RSP_DESC
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    private String rspDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_RSP_CODE.PROD_ID
     *
     * @return the value of T_SYS_RSP_CODE.PROD_ID
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public String getProdId() {
        return prodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_RSP_CODE.PROD_ID
     *
     * @param prodId the value for T_SYS_RSP_CODE.PROD_ID
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_RSP_CODE.OUT_RSP_CODE
     *
     * @return the value of T_SYS_RSP_CODE.OUT_RSP_CODE
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public String getOutRspCode() {
        return outRspCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_RSP_CODE.OUT_RSP_CODE
     *
     * @param outRspCode the value for T_SYS_RSP_CODE.OUT_RSP_CODE
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public void setOutRspCode(String outRspCode) {
        this.outRspCode = outRspCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_RSP_CODE.IN_RSP_CODE2
     *
     * @return the value of T_SYS_RSP_CODE.IN_RSP_CODE2
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public String getInRspCode2() {
        return inRspCode2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_RSP_CODE.IN_RSP_CODE2
     *
     * @param inRspCode2 the value for T_SYS_RSP_CODE.IN_RSP_CODE2
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public void setInRspCode2(String inRspCode2) {
        this.inRspCode2 = inRspCode2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_RSP_CODE.RSP_DESC
     *
     * @return the value of T_SYS_RSP_CODE.RSP_DESC
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public String getRspDesc() {
        return rspDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_RSP_CODE.RSP_DESC
     *
     * @param rspDesc the value for T_SYS_RSP_CODE.RSP_DESC
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    public void setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
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
        TSysRspCode other = (TSysRspCode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
            && (this.getOutRspCode() == null ? other.getOutRspCode() == null : this.getOutRspCode().equals(other.getOutRspCode()))
            && (this.getInRspCode2() == null ? other.getInRspCode2() == null : this.getInRspCode2().equals(other.getInRspCode2()))
            && (this.getRspDesc() == null ? other.getRspDesc() == null : this.getRspDesc().equals(other.getRspDesc()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getOutRspCode() == null) ? 0 : getOutRspCode().hashCode());
        result = prime * result + ((getInRspCode2() == null) ? 0 : getInRspCode2().hashCode());
        result = prime * result + ((getRspDesc() == null) ? 0 : getRspDesc().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_RSP_CODE
     *
     * @mbggenerated Thu Apr 07 13:40:52 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prodId=").append(prodId);
        sb.append(", outRspCode=").append(outRspCode);
        sb.append(", inRspCode2=").append(inRspCode2);
        sb.append(", rspDesc=").append(rspDesc);
        sb.append("]");
        return sb.toString();
    }
}