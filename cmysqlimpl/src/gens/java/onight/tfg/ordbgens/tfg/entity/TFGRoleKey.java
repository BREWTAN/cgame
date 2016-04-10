package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFGRoleKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_ROLE.ROLE_ID
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    private String roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_ROLE.ROLE_ID
     *
     * @return the value of TFG_ROLE.ROLE_ID
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_ROLE.ROLE_ID
     *
     * @param roleId the value for TFG_ROLE.ROLE_ID
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
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
        TFGRoleKey other = (TFGRoleKey) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Sun Apr 10 12:52:13 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}