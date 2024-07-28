package com.yedam.app.Payment.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentVO {
    private Long id;
    private Long subscriptionId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String status;
}
