package com.graby.store.remote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.graby.store.base.remote.service.RemotingService;
import com.graby.store.entity.ShipOrder;
import com.graby.store.entity.Trade;
import com.graby.store.entity.TradeMapping;
import com.graby.store.service.TradeService;

@RemotingService(serviceInterface = TradeRemote.class, serviceUrl = "/trade.call")
public class TradeRemoteImpl implements TradeRemote {

	@Autowired
	private TradeService tradeService;
	
	@Override
	public Long getRelatedTradeId(Long tid) {
		return tradeService.getRelatedTradeId(tid);
	}

	@Override
	public TradeMapping getRelatedMapping(Long tid) {
		return tradeService.getRelatedMapping(tid);
	}

	@Override
	public Long getRelatedTid(Long tradeId) {
		return tradeService.getRelatedTid(tradeId);
	}

	@Override
	public String validateTrade(Trade trade) {
		return tradeService.validateTrade(trade);
	}

	@Override
	public void createTrade(Trade trade) {
		tradeService.createTrade(trade);
	}

	@Override
	public ShipOrder createSendShipOrderByTradeId(Long tradeId) {
		return tradeService.createSendShipOrderByTradeId(tradeId);
	}


	@Override
	public List<Trade> findWaitAuditTrades() {
		return tradeService.findWaitAuditTrades();
	}

	@Override
	public Page<Trade> findUserTrades(Long userId, String status, long pageNo, long pageSize) {
		return tradeService.findUserTrades(userId, status, pageNo, pageSize);
	}

	@Override
	public Trade getTrade(Long id) {
		return tradeService.getTrade(id);
	}

}
