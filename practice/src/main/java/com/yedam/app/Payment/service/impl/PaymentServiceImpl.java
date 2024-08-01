package com.yedam.app.Payment.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.Payment.mapper.PaymentMapper;
import com.yedam.app.Payment.service.PaymentService;
import com.yedam.app.Payment.service.PaymentVO;
import com.yedam.app.Subscription.mapper.SubscriptionMapper;
import com.yedam.app.Subscription.service.SubscriptionVO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	 private final String secretKey ="test_sk_mBZ1gQ4YVXQ1Oj2OJJvjrl2KPoqN";
	 private final RestTemplate restTemplate = new RestTemplate();
	 private final ObjectMapper objectMapper = new ObjectMapper();
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

	/*
	 * @Override
	 * 
	 * @Scheduled(fixedDelay = 10000) public void run() {
	 * System.out.println("스케줄러 테스트"); }
	 */
	@Override
	public int insertbillingKey(String billingKey) {
		return paymentMapper.billingKeyInsert(billingKey);
	}
	
	
	 //@Scheduled(fixedDelay = 10000)
	    public void processScheduledBilling() {
	        // 고객 키 및 빌링 키를 가져오는 로직이 필요합니다.
	        // 여기서는 예시로 고정된 값을 사용하겠습니다.
	        String customerKey = "962670a3-54fd-4c64-b575-ec42a14be098";
	        String billingKey = "I4d6AjcvyNPQfJhxG2zb2s7Tu9vcIkpWRyQsxNINlCE=";

	        if (billingKey != "") {
	            processPayment(customerKey, billingKey);
	        }else {
	        	System.out.println("빌링키없음");
	        }
	    }
	 
	    public void processPayment(String customerKey, String billingKey) {
	        String endpoint = "https://api.tosspayments.com/v1/billing/" + billingKey;

	        HttpHeaders headers = new HttpHeaders();
	        headers.setBasicAuth(secretKey, "");
	        headers.add("Content-Type", "application/json");

	        Map<String, Object> body = new HashMap<>();
	        body.put("customerKey", customerKey);
	        body.put("amount", 500000); // 결제 금액
	        body.put("orderId", UUID.randomUUID().toString());
	        body.put("orderName", "자동결제");
	        body.put("customerEmail", "ass6728@naver.com");
	        body.put("customerName", "박토스");
	        body.put("taxFreeAmount", 0);
	        body.put("taxExemptionAmount", 0);

	        String requestBody = "";
	        try {
	            requestBody = objectMapper.writeValueAsString(body);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

	        ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);

	        if (response.getStatusCode() == HttpStatus.OK) {
	            System.out.println("결제 성공: " + response.getBody());
	        } else {
	            System.out.println("결제 실패: " + response.getBody());
	        }
	    }
}