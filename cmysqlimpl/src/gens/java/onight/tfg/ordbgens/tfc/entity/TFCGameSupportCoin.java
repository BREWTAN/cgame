package onight.tfg.ordbgens.tfc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="TFC_GAME_SUPPORT_COIN")
@AllArgsConstructor
@NoArgsConstructor
public class TFCGameSupportCoin extends TFCGameSupportCoinKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_GAME_SUPPORT_COIN.COIN_TYPE_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private String coinTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TFC_GAME_SUPPORT_COIN.GAME_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    private String gameId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_GAME_SUPPORT_COIN.COIN_TYPE_ID
     *
     * @return the value of TFC_GAME_SUPPORT_COIN.COIN_TYPE_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getCoinTypeId() {
        return coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_GAME_SUPPORT_COIN.COIN_TYPE_ID
     *
     * @param coinTypeId the value for TFC_GAME_SUPPORT_COIN.COIN_TYPE_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setCoinTypeId(String coinTypeId) {
        this.coinTypeId = coinTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFC_GAME_SUPPORT_COIN.GAME_ID
     *
     * @return the value of TFC_GAME_SUPPORT_COIN.GAME_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFC_GAME_SUPPORT_COIN.GAME_ID
     *
     * @param gameId the value for TFC_GAME_SUPPORT_COIN.GAME_ID
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
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
        TFCGameSupportCoin other = (TFCGameSupportCoin) that;
        return (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getCoinTypeId() == null ? other.getCoinTypeId() == null : this.getCoinTypeId().equals(other.getCoinTypeId()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRowId() == null) ? 0 : getRowId().hashCode());
        result = prime * result + ((getCoinTypeId() == null) ? 0 : getCoinTypeId().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TFC_GAME_SUPPORT_COIN
     *
     * @mbggenerated Thu Apr 07 23:51:51 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coinTypeId=").append(coinTypeId);
        sb.append(", gameId=").append(gameId);
        sb.append("]");
        return sb.toString();
    }
}