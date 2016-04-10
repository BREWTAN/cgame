package onight.tfg.ordbgens.sys.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="T_SYS_ROLE_MENU")
@AllArgsConstructor
@NoArgsConstructor
public class TSysRoleMenu extends TSysRoleMenuKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ROLE_MENU.MENU_ID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    private Integer menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ROLE_MENU.ROLE_ID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_ROLE_MENU.STATUS
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ROLE_MENU.MENU_ID
     *
     * @return the value of T_SYS_ROLE_MENU.MENU_ID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ROLE_MENU.MENU_ID
     *
     * @param menuId the value for T_SYS_ROLE_MENU.MENU_ID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ROLE_MENU.ROLE_ID
     *
     * @return the value of T_SYS_ROLE_MENU.ROLE_ID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ROLE_MENU.ROLE_ID
     *
     * @param roleId the value for T_SYS_ROLE_MENU.ROLE_ID
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_ROLE_MENU.STATUS
     *
     * @return the value of T_SYS_ROLE_MENU.STATUS
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_ROLE_MENU.STATUS
     *
     * @param status the value for T_SYS_ROLE_MENU.STATUS
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
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
        TSysRoleMenu other = (TSysRoleMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_ROLE_MENU
     *
     * @mbggenerated Sun Apr 10 20:07:00 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", roleId=").append(roleId);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}