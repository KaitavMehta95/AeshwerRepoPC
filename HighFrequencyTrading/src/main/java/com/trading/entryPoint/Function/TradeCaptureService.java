package com.trading.entryPoint.Function;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public interface TradeCaptureService {

	TradeResponse updateTrade(Trade trade);
	
	Trade findTrade(final Long tradeId);

	Trade fetchTrade(String fieldId, String filterText);

}
