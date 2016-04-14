package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TLTIssueFlowsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_FLOWS.GEN_ID
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    private Long genId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_FLOWS.GEN_ID
     *
     * @return the value of TLT_ISSUE_FLOWS.GEN_ID
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public Long getGenId() {
        return genId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_FLOWS.GEN_ID
     *
     * @param genId the value for TLT_ISSUE_FLOWS.GEN_ID
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    public void setGenId(Long genId) {
        this.genId = genId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
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
        TLTIssueFlowsKey other = (TLTIssueFlowsKey) that;
        return (this.getGenId() == null ? other.getGenId() == null : this.getGenId().equals(other.getGenId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGenId() == null) ? 0 : getGenId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_FLOWS
     *
     * @mbggenerated Thu Apr 14 00:28:11 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", genId=").append(genId);
        sb.append("]");
        return sb.toString();
    }
}