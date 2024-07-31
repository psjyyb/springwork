package com.yedam.app.Payment.web;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.Payment.service.PaymentService;

@Controller
public class PaymentController {
	
	private PaymentService pmsi;
	
	public PaymentController(PaymentService pmsi) {
		this.pmsi = pmsi;
	}
	
	
	@GetMapping("/payTest")
	public String payTest(Model model) {
		String customerKey = getCustomerKey(); // 고객 키 생성 또는 조회
		model.addAttribute("customerKey", customerKey);
		return "tossPayments/toss";
	}

	// 결제 성공
	@GetMapping("/success")
	public String success(@RequestParam String customerKey, @RequestParam String authKey, Model model) {
		String billingKey = getBillingKey(customerKey, authKey);
		model.addAttribute("customerKey", customerKey);
		model.addAttribute("authKey", authKey);
        model.addAttribute("billingKey", billingKey);
        pmsi.processPayment(customerKey, billingKey);
		return "tossPayments/success";
	}

	// 결제 실패
	@GetMapping("/fail")
	public String fail(@RequestParam(required = false) String code, @RequestParam(required = false) String message,
			Model model) {
		model.addAttribute("errorCode", code);
		model.addAttribute("errorMessage", message);
		return "tossPayments/fail";
	}

	private String getCustomerKey() {
		// 고객 키 생성 또는 조회 로직
		return UUID.randomUUID().toString();
	}

	private String getBillingKey(String customerKey, String authKey) {
        String secretKey = "test_sk_mBZ1gQ4YVXQ1Oj2OJJvjrl2KPoqN";
        String endpoint = "https://api.tosspayments.com/v1/billing/authorizations/" + authKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(secretKey, "");
        headers.add("Content-Type", "application/json");

        // 필수 파라미터 포함
        Map<String, String> body = new HashMap<>();
        body.put("customerKey", customerKey);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = "";
        try {
            requestBody = objectMapper.writeValueAsString(body);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                JsonNode root = objectMapper.readTree(response.getBody());
                return root.path("billingKey").asText();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: " + response.getBody());
        }
        return null;
    }
}
