package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TLTIssueStepsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_ISSUE_STEPS.ISSUE_STEP_ID
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    private String issueStepId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_ISSUE_STEPS.ISSUE_STEP_ID
     *
     * @return the value of TLT_ISSUE_STEPS.ISSUE_STEP_ID
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    public String getIssueStepId() {
        return issueStepId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_ISSUE_STEPS.ISSUE_STEP_ID
     *
     * @param issueStepId the value for TLT_ISSUE_STEPS.ISSUE_STEP_ID
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    public void setIssueStepId(String issueStepId) {
        this.issueStepId = issueStepId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
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
        TLTIssueStepsKey other = (TLTIssueStepsKey) that;
        return (this.getIssueStepId() == null ? other.getIssueStepId() == null : this.getIssueStepId().equals(other.getIssueStepId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIssueStepId() == null) ? 0 : getIssueStepId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_ISSUE_STEPS
     *
     * @mbggenerated Sun Apr 10 15:45:38 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", issueStepId=").append(issueStepId);
        sb.append("]");
        return sb.toString();
    }
}