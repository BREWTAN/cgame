package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFG_ROLE")
@AllArgsConstructor
@NoArgsConstructor
public class TFGRole extends TFGRoleKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_ROLE.PARENT_ROLE_ID
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    private String parentRoleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_ROLE.ROLE_NAME
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_ROLE.ROLE_DESC
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    private String roleDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_ROLE.STATUS
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_ROLE.PARENT_ROLE_ID
     *
     * @return the value of TFG_ROLE.PARENT_ROLE_ID
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public String getParentRoleId() {
        return parentRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_ROLE.PARENT_ROLE_ID
     *
     * @param parentRoleId the value for TFG_ROLE.PARENT_ROLE_ID
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public void setParentRoleId(String parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_ROLE.ROLE_NAME
     *
     * @return the value of TFG_ROLE.ROLE_NAME
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_ROLE.ROLE_NAME
     *
     * @param roleName the value for TFG_ROLE.ROLE_NAME
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_ROLE.ROLE_DESC
     *
     * @return the value of TFG_ROLE.ROLE_DESC
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_ROLE.ROLE_DESC
     *
     * @param roleDesc the value for TFG_ROLE.ROLE_DESC
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_ROLE.STATUS
     *
     * @return the value of TFG_ROLE.STATUS
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_ROLE.STATUS
     *
     * @param status the value for TFG_ROLE.STATUS
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
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
        TFGRole other = (TFGRole) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getParentRoleId() == null ? other.getParentRoleId() == null : this.getParentRoleId().equals(other.getParentRoleId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRoleDesc() == null ? other.getRoleDesc() == null : this.getRoleDesc().equals(other.getRoleDesc()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getParentRoleId() == null) ? 0 : getParentRoleId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRoleDesc() == null) ? 0 : getRoleDesc().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_ROLE
     *
     * @mbggenerated Thu Apr 07 10:59:59 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parentRoleId=").append(parentRoleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleDesc=").append(roleDesc);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}