package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TLTBetAutoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_BET_AUTO.AUTOBET_NO
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    private String autobetNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_BET_AUTO.AUTOBET_NO
     *
     * @return the value of TLT_BET_AUTO.AUTOBET_NO
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public String getAutobetNo() {
        return autobetNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_BET_AUTO.AUTOBET_NO
     *
     * @param autobetNo the value for TLT_BET_AUTO.AUTOBET_NO
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    public void setAutobetNo(String autobetNo) {
        this.autobetNo = autobetNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
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
        TLTBetAutoKey other = (TLTBetAutoKey) that;
        return (this.getAutobetNo() == null ? other.getAutobetNo() == null : this.getAutobetNo().equals(other.getAutobetNo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAutobetNo() == null) ? 0 : getAutobetNo().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_BET_AUTO
     *
     * @mbggenerated Sun Apr 10 20:07:01 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", autobetNo=").append(autobetNo);
        sb.append("]");
        return sb.toString();
    }
}