package com.yedam.app.chat.web;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.yedam.app.chat.domain.ChatMessage;
import com.yedam.app.chat.repository.ChatMessageRepository;



@Controller
public class ChatController {
	 @Autowired
	    private ChatMessageRepository chatMessageRepository;

	    @MessageMapping("/chat")
	    @SendTo("/topic/messages")
	    public ChatMessage sendMessage(ChatMessage message) {
	        message.setTimestamp(LocalDateTime.now()); // 현재 시간 설정
	        chatMessageRepository.save(message); // 메시지 DB 저장
	        return message;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	private final ChatService chatService;
//
//	public ChatController(ChatService chatService) {
//		this.chatService = chatService;
//	}
//
//	@MessageMapping("/chat")
//	@SendTo("/topic/messages")
//	public ChatMessageDTO sendMessage(ChatMessageDTO message) {
//		chatService.processMessage(message);
//		return message;
//	}
}
