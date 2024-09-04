package com.yedam.app.chat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.chat.domain.ChatMessage;
import com.yedam.app.chat.repository.ChatMessageRepository;


@Controller
public class ChatPageController {

	@Autowired
	private ChatMessageRepository chatMessageRepository;

	@GetMapping("/chat")
	public String getChatPage(Model model) {
		List<ChatMessage> previousMessages = chatMessageRepository.findAll();
		model.addAttribute("messages", previousMessages);
		return "group/chat/chatTest";
	}
	
	
	
	
	
	
	
	
	
	
	
//	private GroupAdminService gaService;
//	private ChatRoomService chatRoomService;
//	
//	public ChatPageController(GroupAdminService gaService,ChatRoomService chatRoomService) {
//		this.gaService = gaService;
//		this.chatRoomService = chatRoomService;
//	}
//
//	@GetMapping("/group/chat")
//	public String chatPage(HttpSession session, Model model) {
//		String comCode = (String) session.getAttribute("companyCode");
//		Integer empNo = (Integer) session.getAttribute("employeeNo");
//		List<ChatRoomVO> chatRoomList = chatRoomService.chatRoomsSelect(comCode, empNo);
//		List<EmployeeVO> list = gaService.empListSelect(comCode);
//		model.addAttribute("chatRoomList",chatRoomList);
//		model.addAttribute("empList", list);
//		String empName = (String) session.getAttribute("empName");
//		model.addAttribute("empName", empName);
//		return "group/chat/chatTest";
//	}
}
