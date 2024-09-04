package com.yedam.app.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yedam.app.chat.domain.ChatMessage;


public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
	
}