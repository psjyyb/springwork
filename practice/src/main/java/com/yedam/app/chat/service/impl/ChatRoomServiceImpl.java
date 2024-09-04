package com.yedam.app.chat.service.impl;


import org.springframework.stereotype.Service;

import com.yedam.app.chat.service.ChatRoomService;

	
@Service
public class ChatRoomServiceImpl implements ChatRoomService {
	
	/*
	 * private ChatRoomMapper chatRoomMapper;
	 * 
	 * public ChatRoomServiceImpl(ChatRoomMapper chatRoomMapper) {
	 * this.chatRoomMapper = chatRoomMapper; }
	 * 
	 * @Transactional
	 * 
	 * @Override public ChatRoomVO createChatRoom(@RequestBody ChatRoomVO
	 * chatRoomVO) { System.out.println(chatRoomVO + " - Service Implementation");
	 * 
	 * // 채팅방 생성 chatRoomMapper.createChatRoom(chatRoomVO);
	 * 
	 * // 채팅방 멤버 추가 ChatMemberVO chatMemberVO = new ChatMemberVO();
	 * chatMemberVO.setRoomNo(chatRoomVO.getRoomNo());
	 * 
	 * // 배열이 null이 아닌지 확인 if (chatRoomVO.getEmployeeIds() == null ||
	 * chatRoomVO.getEmployeeIds().length == 0) { throw new
	 * IllegalArgumentException("Employee IDs array is null or empty"); }
	 * 
	 * for (int i = 0; i < chatRoomVO.getEmployeeIds().length; i++) {
	 * chatMemberVO.setEmployeeNo(chatRoomVO.getEmployeeIds()[i]);
	 * System.out.println(chatRoomVO.getEmployeeIds()[i] + " - Employee ID");
	 * System.out.println(chatMemberVO + " - Chat Member VO");
	 * chatRoomMapper.membersChatRoom(chatMemberVO); }
	 * 
	 * return chatRoomVO; } // 채팅방 목록
	 * 
	 * @Override public List<ChatRoomVO> chatRoomsSelect(String companyCode, int
	 * employeeNo) { return chatRoomMapper.selectChatRooms(companyCode, employeeNo);
	 * }
	 */
}