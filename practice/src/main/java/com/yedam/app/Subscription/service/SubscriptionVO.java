package com.yedam.app.Subscription.service;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SubscriptionVO {
    private Long id;
    private Long userId;
    private String plan;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
