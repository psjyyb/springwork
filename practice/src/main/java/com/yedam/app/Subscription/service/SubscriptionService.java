package com.yedam.app.Subscription.service;

import com.yedam.app.user.service.UserVO;

public interface SubscriptionService {
	SubscriptionVO createSubscription(UserVO user, String plan);

	void updateSubscription(SubscriptionVO subscription);
}
