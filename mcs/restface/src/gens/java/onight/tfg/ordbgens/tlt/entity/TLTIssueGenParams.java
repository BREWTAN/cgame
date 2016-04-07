package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TLT_ISSUE_GEN_PARAMS")
@AllArgsConstructor
@NoArgsConstructor
public class TLTIssueGenParams extends TLTIssueGenParamsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.LTYPE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.SALE_STIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private String saleStime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.SALE_ETIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private String saleEtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.SALE_FI_ETIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private String saleFiEtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.SALE_CYCLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private Integer saleCycle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.WAIT_RL_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private Integer waitRlDur;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.CANCEL_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private Integer cancelDur;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.INPUT_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private Integer inputDur;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.SORT
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private Byte sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_GEN_PARAMS.ENABLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private Boolean enable;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.LTYPE
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.LTYPE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.LTYPE
     *
     * @param ltype the value for TLT_ISSUE_GEN_PARAMS.LTYPE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_STIME
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.SALE_STIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public String getSaleStime() {
        return saleStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_STIME
     *
     * @param saleStime the value for TLT_ISSUE_GEN_PARAMS.SALE_STIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setSaleStime(String saleStime) {
        this.saleStime = saleStime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_ETIME
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.SALE_ETIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public String getSaleEtime() {
        return saleEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_ETIME
     *
     * @param saleEtime the value for TLT_ISSUE_GEN_PARAMS.SALE_ETIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setSaleEtime(String saleEtime) {
        this.saleEtime = saleEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_FI_ETIME
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.SALE_FI_ETIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public String getSaleFiEtime() {
        return saleFiEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_FI_ETIME
     *
     * @param saleFiEtime the value for TLT_ISSUE_GEN_PARAMS.SALE_FI_ETIME
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setSaleFiEtime(String saleFiEtime) {
        this.saleFiEtime = saleFiEtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_CYCLE
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.SALE_CYCLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public Integer getSaleCycle() {
        return saleCycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.SALE_CYCLE
     *
     * @param saleCycle the value for TLT_ISSUE_GEN_PARAMS.SALE_CYCLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setSaleCycle(Integer saleCycle) {
        this.saleCycle = saleCycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.WAIT_RL_DUR
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.WAIT_RL_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public Integer getWaitRlDur() {
        return waitRlDur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.WAIT_RL_DUR
     *
     * @param waitRlDur the value for TLT_ISSUE_GEN_PARAMS.WAIT_RL_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setWaitRlDur(Integer waitRlDur) {
        this.waitRlDur = waitRlDur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.CANCEL_DUR
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.CANCEL_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public Integer getCancelDur() {
        return cancelDur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.CANCEL_DUR
     *
     * @param cancelDur the value for TLT_ISSUE_GEN_PARAMS.CANCEL_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setCancelDur(Integer cancelDur) {
        this.cancelDur = cancelDur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.INPUT_DUR
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.INPUT_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public Integer getInputDur() {
        return inputDur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.INPUT_DUR
     *
     * @param inputDur the value for TLT_ISSUE_GEN_PARAMS.INPUT_DUR
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setInputDur(Integer inputDur) {
        this.inputDur = inputDur;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.SORT
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.SORT
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.SORT
     *
     * @param sort the value for TLT_ISSUE_GEN_PARAMS.SORT
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_GEN_PARAMS.ENABLE
     *
     * @return the value of TLT_ISSUE_GEN_PARAMS.ENABLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_GEN_PARAMS.ENABLE
     *
     * @param enable the value for TLT_ISSUE_GEN_PARAMS.ENABLE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
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
        TLTIssueGenParams other = (TLTIssueGenParams) that;
        return (this.getGenId() == null ? other.getGenId() == null : this.getGenId().equals(other.getGenId()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getSaleStime() == null ? other.getSaleStime() == null : this.getSaleStime().equals(other.getSaleStime()))
            && (this.getSaleEtime() == null ? other.getSaleEtime() == null : this.getSaleEtime().equals(other.getSaleEtime()))
            && (this.getSaleFiEtime() == null ? other.getSaleFiEtime() == null : this.getSaleFiEtime().equals(other.getSaleFiEtime()))
            && (this.getSaleCycle() == null ? other.getSaleCycle() == null : this.getSaleCycle().equals(other.getSaleCycle()))
            && (this.getWaitRlDur() == null ? other.getWaitRlDur() == null : this.getWaitRlDur().equals(other.getWaitRlDur()))
            && (this.getCancelDur() == null ? other.getCancelDur() == null : this.getCancelDur().equals(other.getCancelDur()))
            && (this.getInputDur() == null ? other.getInputDur() == null : this.getInputDur().equals(other.getInputDur()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGenId() == null) ? 0 : getGenId().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getSaleStime() == null) ? 0 : getSaleStime().hashCode());
        result = prime * result + ((getSaleEtime() == null) ? 0 : getSaleEtime().hashCode());
        result = prime * result + ((getSaleFiEtime() == null) ? 0 : getSaleFiEtime().hashCode());
        result = prime * result + ((getSaleCycle() == null) ? 0 : getSaleCycle().hashCode());
        result = prime * result + ((getWaitRlDur() == null) ? 0 : getWaitRlDur().hashCode());
        result = prime * result + ((getCancelDur() == null) ? 0 : getCancelDur().hashCode());
        result = prime * result + ((getInputDur() == null) ? 0 : getInputDur().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_GEN_PARAMS
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ltype=").append(ltype);
        sb.append(", saleStime=").append(saleStime);
        sb.append(", saleEtime=").append(saleEtime);
        sb.append(", saleFiEtime=").append(saleFiEtime);
        sb.append(", saleCycle=").append(saleCycle);
        sb.append(", waitRlDur=").append(waitRlDur);
        sb.append(", cancelDur=").append(cancelDur);
        sb.append(", inputDur=").append(inputDur);
        sb.append(", sort=").append(sort);
        sb.append(", enable=").append(enable);
        sb.append("]");
        return sb.toString();
    }
}