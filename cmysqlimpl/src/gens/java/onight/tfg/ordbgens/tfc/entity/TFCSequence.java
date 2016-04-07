package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_SEQUENCE")
@AllArgsConstructor
@NoArgsConstructor
public class TFCSequence extends TFCSequenceKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_SEQUENCE.CURRENT_VALUE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    private Long currentValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_SEQUENCE._INCREMENT
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    private Integer increment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_SEQUENCE.CURRENT_VALUE
     *
     * @return the value of TFC_SEQUENCE.CURRENT_VALUE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public Long getCurrentValue() {
        return currentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_SEQUENCE.CURRENT_VALUE
     *
     * @param currentValue the value for TFC_SEQUENCE.CURRENT_VALUE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public void setCurrentValue(Long currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_SEQUENCE._INCREMENT
     *
     * @return the value of TFC_SEQUENCE._INCREMENT
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public Integer getIncrement() {
        return increment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_SEQUENCE._INCREMENT
     *
     * @param increment the value for TFC_SEQUENCE._INCREMENT
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_SEQUENCE
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
        TFCSequence other = (TFCSequence) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCurrentValue() == null ? other.getCurrentValue() == null : this.getCurrentValue().equals(other.getCurrentValue()))
            && (this.getIncrement() == null ? other.getIncrement() == null : this.getIncrement().equals(other.getIncrement()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_SEQUENCE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCurrentValue() == null) ? 0 : getCurrentValue().hashCode());
        result = prime * result + ((getIncrement() == null) ? 0 : getIncrement().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_SEQUENCE
     *
     * @mbggenerated Thu Apr 07 11:00:00 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", currentValue=").append(currentValue);
        sb.append(", increment=").append(increment);
        sb.append("]");
        return sb.toString();
    }
}