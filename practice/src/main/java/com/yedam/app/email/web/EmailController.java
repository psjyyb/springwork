/*
 * package com.yedam.app.email.web;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.yedam.app.email.service.EmailService;
 * 
 * @Controller public class EmailController {
 * 
 * @Autowired private EmailService emailService;
 * 
 * @GetMapping("/emailSend") public String emailSend(Model model) { return
 * "email/emailSend"; }
 * 
 * @PostMapping("/emailSend") public String sendEmail(@RequestParam("toEmail")
 * String toEmail,
 * 
 * @RequestParam("subject") String subject,
 * 
 * @RequestParam("body") String body, Model model) {
 * emailService.sendSimpleEmail(); model.addAttribute("message",
 * "Email sent successfully!"); return "email/emailSend"; } }
 */