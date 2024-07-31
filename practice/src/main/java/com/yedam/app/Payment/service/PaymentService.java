package com.yedam.app.Payment.service;

import java.math.BigDecimal;

import com.yedam.app.Subscription.service.SubscriptionVO;

public interface PaymentService {
	void processPayment(SubscriptionVO subscription, BigDecimal amount);
	//public void run();
	public int insertbillingKey(String billingKey);
	public void processPayment(String customerKey, String billingKey);
	public void processScheduledBilling();
}
