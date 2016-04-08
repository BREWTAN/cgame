package onight.tfg.ordbgens.tfg.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFG_USER_ID_LIST")
@AllArgsConstructor
@NoArgsConstructor
public class TFGUserIdList extends TFGUserIdListKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFG_USER_ID_LIST.STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFG_USER_ID_LIST.STATUS
     *
     * @return the value of TFG_USER_ID_LIST.STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFG_USER_ID_LIST.STATUS
     *
     * @param status the value for TFG_USER_ID_LIST.STATUS
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
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
        TFGUserIdList other = (TFGUserIdList) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFG_USER_ID_LIST
     *
     * @mbggenerated Thu Apr 07 21:43:53 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}