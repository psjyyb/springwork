package com.yedam.app.chat.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.chat.service.ChatRoomService;


@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;
   
    
	/*
	 * @PostMapping public ChatRoomVO createChatRoom(@RequestBody ChatRoomVO
	 * chatRoomVO,HttpSession session) { System.out.println(chatRoomVO+"컨트롤러에서 찍기");
	 * String comCode = (String)session.getAttribute("companyCode");
	 * chatRoomVO.setCompanyCode(comCode); return
	 * chatRoomService.createChatRoom(chatRoomVO); }
	 */

}