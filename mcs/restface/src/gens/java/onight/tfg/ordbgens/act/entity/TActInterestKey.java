package onight.tfg.ordbgens.act.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TActInterestKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ACT_INTEREST.INST_LOGID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    private String instLogid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ACT_INTEREST.INST_LOGID
     *
     * @return the value of T_ACT_INTEREST.INST_LOGID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String getInstLogid() {
        return instLogid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ACT_INTEREST.INST_LOGID
     *
     * @param instLogid the value for T_ACT_INTEREST.INST_LOGID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public void setInstLogid(String instLogid) {
        this.instLogid = instLogid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
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
        TActInterestKey other = (TActInterestKey) that;
        return (this.getInstLogid() == null ? other.getInstLogid() == null : this.getInstLogid().equals(other.getInstLogid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInstLogid() == null) ? 0 : getInstLogid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_INTEREST
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", instLogid=").append(instLogid);
        sb.append("]");
        return sb.toString();
    }
}