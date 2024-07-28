package com.yedam.app.Subscription.mapper;

import java.util.List;

import com.yedam.app.Subscription.service.SubscriptionVO;

public interface SubscriptionMapper {

	List<SubscriptionVO> findByUserId(Long userId);

	void insertSubscription(SubscriptionVO subscription);

	void updateSubscription(SubscriptionVO subscription);
}
