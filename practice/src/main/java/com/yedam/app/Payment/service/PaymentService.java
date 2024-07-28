package com.yedam.app.Payment.service;

import java.math.BigDecimal;

import com.yedam.app.Subscription.service.SubscriptionVO;

public interface PaymentService {
	void processPayment(SubscriptionVO subscription, BigDecimal amount);
}
