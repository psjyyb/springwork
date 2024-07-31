package com.yedam.app.Payment.mapper;

import java.util.List;

import com.yedam.app.Payment.service.PaymentVO;

public interface PaymentMapper {
	List<PaymentVO> findBySubscriptionId(Long subscriptionId);

	void insertPayment(PaymentVO payment);
	int billingKeyInsert(String billingKey);
}
