package com.jpmorgan.stocks.model.trade;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IRVINEG on 16/05/2016.
 */
public class Trade {

    private Date tradeTimestamp;
    private int shareQuantity;
    private TradeType tradeType;
    private BigDecimal tradedPrice;

    public Trade(Date tradeTimestamp, int shareQuantity, TradeType tradeType, BigDecimal price) {
        this.tradeTimestamp = tradeTimestamp;
        this.shareQuantity = shareQuantity;
        this.tradeType = tradeType;
        this.tradedPrice = price.multiply(tradeType.getTradeTypeModifier());
    }

    BigDecimal getTradedPrice() {
        return tradedPrice;
    }

    public int getShareQuantity() {
        return shareQuantity;
    }

    TradeType getTradeType() {
        return tradeType;
    }

    public Date getTradeTimestamp() {
        return tradeTimestamp;
    }

    public BigDecimal getTotalTradedPrice() {
        return tradedPrice.multiply(BigDecimal.valueOf(shareQuantity));
    }
}
