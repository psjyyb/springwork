package com.yedam.app.Subscription.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.Subscription.mapper.SubscriptionMapper;
import com.yedam.app.Subscription.service.SubscriptionService;
import com.yedam.app.Subscription.service.SubscriptionVO;
import com.yedam.app.user.service.UserVO;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionMapper subscriptionMapper;

	@Override
	public SubscriptionVO createSubscription(UserVO user, String plan) {
		SubscriptionVO subscription = new SubscriptionVO();
		subscription.setUserId(user.getId());
		subscription.setPlan(plan);
		subscription.setStartDate(LocalDate.now());
		subscription.setEndDate(LocalDate.now().plusMonths(1)); // 예: 1개월 구독
		subscription.setStatus("ACTIVE");
		subscriptionMapper.insertSubscription(subscription);
		return subscription;
	}

	@Override
	public void updateSubscription(SubscriptionVO subscription) {
		subscriptionMapper.updateSubscription(subscription);
	}
}
