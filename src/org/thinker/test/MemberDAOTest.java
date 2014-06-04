package org.thinker.test;

import org.junit.Before;
import org.junit.Test;
import org.thinker.dao.MemberDAO;
import org.thinker.vo.MessageVO;

public class MemberDAOTest {

	MemberDAO dao;

	@Before
	public void ready() {
		dao = new MemberDAO();
	}

	// 회원 가입
	// @Test
	// public void createTest() throws Exception{
	//
	// MemberVO vo = new MemberVO();
	//
	// vo.setId("user101");
	// vo.setName("고진호");
	// vo.setPhone("010-1234-0119");
	// vo.setPw("user101");
	//
	// dao.createMember(vo);
	//
	//
	// }

	// // 로그인
	// @Test
	// public void loginTest() throws Exception{
	//
	// MemberVO vo = new MemberVO();
	//
	// vo.setId("user101");
	// vo.setPw("user101");
	//
	// dao.login(vo);
	//
	// }

	// // id 중복 체크
	// @Test
	// public void idDuplicateCheckTest() throws Exception {
	//
	// MemberVO vo = new MemberVO();
	//
	// vo.setId("user101");
	//
	// dao.idDuplicateCheck(vo);
	//
	// }

	// @Test
	// public void getBorrowListForUser() throws Exception {
	//
	// MemberVO vo = new MemberVO();
	//
	// vo.setId("user08");
	//
	// dao.getBorrowListForUser(vo);
	//
	// }

	// @Test
	// public void getBorrowListForAdmin() throws Exception {
	//
	// MemberVO vo = new MemberVO();
	//
	// dao.getBorrowListForAdmin();
	//
	// }

	// @Test
	// public void getReservationListForUser() throws Exception {
	//
	// ReservationVO vo = new ReservationVO();
	//
	// vo.setId("user08");
	//
	// dao.getReservationListForUser(vo);
	//
	// }

	// @Test
	// public void getReservationListForAdmin() throws Exception {
	//
	// ReservationVO vo = new ReservationVO();
	//
	// dao.getReservationListForAdmin();
	//
	// }

	// @Test
	// public void createMessage() throws Exception {
	//
	// MessageVO vo = new MessageVO();
	//
	// vo.setFromId("user08");
	// vo.setToId("user21");
	// vo.setMsg("안됩니다.");
	//
	// dao.createMessage(vo);
	//
	// }

	@Test
	public void getMessageList() throws Exception {

		MessageVO vo = new MessageVO();

		vo.setToId("user21");

		dao.getMessageList(vo);

	}

};
