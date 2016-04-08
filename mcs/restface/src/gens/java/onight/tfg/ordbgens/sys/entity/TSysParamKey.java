package onight.tfg.ordbgens.sys.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TSysParamKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_PARAM.PARAM_ID
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    private String paramId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_PARAM.PARAM_ID
     *
     * @return the value of T_SYS_PARAM.PARAM_ID
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public String getParamId() {
        return paramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_PARAM.PARAM_ID
     *
     * @param paramId the value for T_SYS_PARAM.PARAM_ID
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
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
        TSysParamKey other = (TSysParamKey) that;
        return (this.getParamId() == null ? other.getParamId() == null : this.getParamId().equals(other.getParamId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getParamId() == null) ? 0 : getParamId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_PARAM
     *
     * @mbggenerated Thu Apr 07 21:43:52 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paramId=").append(paramId);
        sb.append("]");
        return sb.toString();
    }
}