package com.trading.gateway.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import com.google.inject.Inject;
import com.trading.commons.util.EntityManagerFactoryWrapper;
import com.trading.commons.util.HighFrequencyTradingPersistence;
import com.trading.commons.util.LogManagerUtil;
import com.trading.commons.util.TransactionUtil;
import com.trading.domain.trade.Trade;
import com.trading.domain.trade.TradeStatus;
import com.trading.gateway.jpa.persistable.PersistableTradeEntityModel;
import com.trading.gateway.jpa.persistable.TradePersistable;
import com.trading.gateway.repository.transformer.TradePersistableTransformer;

public class TradeRepositoryImpl implements TradeRepository{

	private static final Integer MAX_RESULT_SIZE = 100;
	private final EntityManagerFactoryWrapper entityManagerFactory;
	private final TradePersistableTransformer persistableTransformer;
	private static Logger logger;

	@Inject
	public TradeRepositoryImpl(@HighFrequencyTradingPersistence final EntityManagerFactoryWrapper entityManagerFactory,final TradePersistableTransformer persistableTransformer) {
		this.entityManagerFactory = entityManagerFactory;
		this.persistableTransformer = persistableTransformer;
		logger = LogManagerUtil.getLogger(TradeRepositoryImpl.class);

	}

	@Override
	public Trade persist(Trade trade) {
		final AtomicReference<PersistableTradeEntityModel> updatedEntityModel = new AtomicReference<>();
		final Optional<Long> tradeIdOptional = Optional.ofNullable(trade.getTradeId());
		try{
			TransactionUtil.doInJPA(logger,
					this.entityManagerFactory.getEntityManagerFactory(),
					entityManager -> {
						final EntityTransaction transaction = entityManager.getTransaction();
						transaction.begin();
						if (tradeIdOptional.isPresent()) {
							updatedEntityModel.set(this.updateTerm(entityManager, trade));
						} else {
							updatedEntityModel.set(this.createTerm(entityManager, trade));
						}
						transaction.commit();
						logger.info(TradeRepositoryImpl.class +":  Persist Request Success ");
					});
		}catch(Exception e)
		{
			updatedEntityModel.get().getTrade().setTradeStatus(TradeStatus.INVALID);
			logger.info(TradeRepositoryImpl.class + ":  Persist Failed");
		}
		updatedEntityModel.get().getTrade().setTradeStatus(TradeStatus.ACCECPTED);
		updatedEntityModel.get().getTrade().setTradeId(updatedEntityModel.get().getPersistable().getId());
		return updatedEntityModel.get().getTrade();
	}

	@Override
	public Trade findByTradeId(Long tradeId) {
		final AtomicReference<TradePersistable> fetchedTradePersistable = new AtomicReference<>();
		TransactionUtil.doInJPA(logger,this.entityManagerFactory.getEntityManagerFactory(), entityManager -> {
			fetchedTradePersistable.set(entityManager.find(TradePersistable.class, tradeId));
		});

		final Trade trade = this.persistableTransformer.createDomainFromPersistable(fetchedTradePersistable.get());
		return trade;
	}

	@Override
	public Trade findTradeByCriteria(String fieldId, String filterText) {
		final List<Trade> trades = new ArrayList<>();
		final AtomicReference<List<TradePersistable>> fetchedTradePersistable = new AtomicReference<>();
		TransactionUtil.doInJPA(logger,this.entityManagerFactory.getEntityManagerFactory(), entityManager -> {
			
			final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		    final CriteriaQuery<TradePersistable> query = criteriaBuilder.createQuery(TradePersistable.class);
		    final Root<TradePersistable> from = query.from(TradePersistable.class);
		    query.select(from);
		    query.where();
		    final TypedQuery<TradePersistable> selectQuery = entityManager.createQuery(query);
		    selectQuery.setMaxResults(MAX_RESULT_SIZE);
		    fetchedTradePersistable.set(selectQuery.getResultList());
		    for(TradePersistable  l: fetchedTradePersistable.get())
		    {
		    	System.out.println(l.getId()+ l.getBuySellIndicator());
		    }
		});
		return trades.get(0);
	}

	private PersistableTradeEntityModel updateTerm(final EntityManager entityManager, final Trade trade) {
		/*final TradePersistable tradePersistable = entityManager.find(TradePersistable.class, trade.getId());
		   this.persistableTransformer.updatePersistable(trade, tradePersistable );

		    final TradeHeaderPersistable tradeHeaderPersistable = tradePersistable.getTradeHeader();
		    tradePersistable.setData(trade);
		    tradeHeaderPersistable.setData(trade.getTradeHeader());

		    this.persistTerm(entityManager, tradePersistable, tradeHeaderPersistable);
		    return trade;*/
		return new PersistableTradeEntityModel();
	}

	private PersistableTradeEntityModel createTerm(final EntityManager entityManager, final Trade trade) {
		PersistableTradeEntityModel entityModel = new PersistableTradeEntityModel();
		final TradePersistable tradePersistable = this.persistableTransformer.createPersistable(trade);
		// XXX  Temporary Done Until a gud Id generation Mechanism is Implemented
		//this.persistableTransformer.generateIds(tradePersistable,trade);
		entityManager.persist(tradePersistable);
		entityModel.setPersistable(tradePersistable);
		entityModel.setTrade(trade);
		return entityModel;
	}
}