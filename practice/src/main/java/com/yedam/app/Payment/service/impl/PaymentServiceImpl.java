package com.yedam.app.Payment.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.Payment.mapper.PaymentMapper;
import com.yedam.app.Payment.service.PaymentService;
import com.yedam.app.Payment.service.PaymentVO;
import com.yedam.app.Subscription.mapper.SubscriptionMapper;
import com.yedam.app.Subscription.service.SubscriptionVO;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;
    
    @Autowired 
    private SubscriptionMapper subscriptionMapper;
  

    @Override
    public void processPayment(SubscriptionVO subscription, BigDecimal amount) {
        PaymentVO payment = new PaymentVO();
        payment.setSubscriptionId(subscription.getId());
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("COMPLETED");
        paymentMapper.insertPayment(payment);

        // 다음 결제일 갱신
        subscription.setEndDate(subscription.getEndDate().plusMonths(1));
        subscriptionMapper.updateSubscription(subscription);
    }
}