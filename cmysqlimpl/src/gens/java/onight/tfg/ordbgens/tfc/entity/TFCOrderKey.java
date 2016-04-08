package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TFCOrderKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_ORDER.ORDER_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private String orderId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_ORDER.ORDER_ID
     *
     * @return the value of TFC_ORDER.ORDER_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_ORDER.ORDER_ID
     *
     * @param orderId the value for TFC_ORDER.ORDER_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
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
        TFCOrderKey other = (TFCOrderKey) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_ORDER
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
}