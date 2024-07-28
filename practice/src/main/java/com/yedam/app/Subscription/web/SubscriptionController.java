package com.yedam.app.Subscription.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.Subscription.service.SubscriptionService;
import com.yedam.app.user.service.UserService;
import com.yedam.app.user.service.UserVO;

@Controller
public class SubscriptionController {

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/subscription")
    public String getSubscriptionPage(HttpSession session, Model model) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "subscription/subscription";
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String plan, HttpSession session, Model model) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        } 
        subscriptionService.createSubscription(user, plan);
        return "redirect:/subscription";
    }
}
