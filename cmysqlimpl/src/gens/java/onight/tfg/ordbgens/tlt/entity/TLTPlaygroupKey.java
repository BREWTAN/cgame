package onight.tfg.ordbgens.tlt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TLTPlaygroupKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TLT_PLAYGROUP.ID
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    private Long id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TLT_PLAYGROUP.ID
     *
     * @return the value of TLT_PLAYGROUP.ID
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TLT_PLAYGROUP.ID
     *
     * @param id the value for TLT_PLAYGROUP.ID
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
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
        TLTPlaygroupKey other = (TLTPlaygroupKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TLT_PLAYGROUP
     *
     * @mbggenerated Sun Apr 10 12:52:15 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}