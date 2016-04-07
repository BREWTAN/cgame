package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TLTLtypeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_LTYPE.LTYPE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    private String ltype;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_LTYPE.LTYPE
     *
     * @return the value of TLT_LTYPE.LTYPE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_LTYPE.LTYPE
     *
     * @param ltype the value for TLT_LTYPE.LTYPE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
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
        TLTLtypeKey other = (TLTLtypeKey) that;
        return (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
     *
     * @mbggenerated Thu Apr 07 13:37:31 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_LTYPE
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
        sb.append("]");
        return sb.toString();
    }
}