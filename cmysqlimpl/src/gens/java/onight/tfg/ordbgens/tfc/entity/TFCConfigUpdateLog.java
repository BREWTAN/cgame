package onight.tfg.ordbgens.tfc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_CONFIG_UPDATE_LOG")
@AllArgsConstructor
@NoArgsConstructor
public class TFCConfigUpdateLog extends TFCConfigUpdateLogKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CONFIG_UPDATE_LOG.UPDATE_TIME
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_CONFIG_UPDATE_LOG.NOTE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CONFIG_UPDATE_LOG.UPDATE_TIME
     *
     * @return the value of TFC_CONFIG_UPDATE_LOG.UPDATE_TIME
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CONFIG_UPDATE_LOG.UPDATE_TIME
     *
     * @param updateTime the value for TFC_CONFIG_UPDATE_LOG.UPDATE_TIME
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_CONFIG_UPDATE_LOG.NOTE
     *
     * @return the value of TFC_CONFIG_UPDATE_LOG.NOTE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_CONFIG_UPDATE_LOG.NOTE
     *
     * @param note the value for TFC_CONFIG_UPDATE_LOG.NOTE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
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
        TFCConfigUpdateLog other = (TFCConfigUpdateLog) that;
        return (this.getConfigType() == null ? other.getConfigType() == null : this.getConfigType().equals(other.getConfigType()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConfigType() == null) ? 0 : getConfigType().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_CONFIG_UPDATE_LOG
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", updateTime=").append(updateTime);
        sb.append(", note=").append(note);
        sb.append("]");
        return sb.toString();
    }
}