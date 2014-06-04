package org.thinker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thinker.common.ReflectServlet;
import org.thinker.common.RequestToVOConverter;
import org.thinker.common.WebRequest;
import org.thinker.common.WebResponse;
import org.thinker.dao.MemberDAO;
import org.thinker.vo.BorrowVO;
import org.thinker.vo.MemberVO;
import org.thinker.vo.MessageVO;
import org.thinker.vo.ReservationVO;

/**
 * Servlet implementation class memberController
 */
public class MemberController extends ReflectServlet {

	MemberDAO memberDAO;
	HttpSession session;
	/**
	 * Default constructor.
	 */
	public MemberController() {
		setLocalPath(PATH + "member/");
		memberDAO = new MemberDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String doGET(WebRequest request, WebResponse response)
			throws ServletException, IOException {

		logger.info("doGET :");

		return getLocalPath() + "login.jsp";
	}

	private String loginGET(WebRequest request, WebResponse response)
			throws Exception {

		logger.info("loginGET");

		session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		logger.info(id);
		
		return getLocalPath() + "login.jsp";
	}

	private String loginPOST(WebRequest request, WebResponse response)
			throws Exception {

		logger.info("loginPost");

		session = request.getSession(true);

		MemberVO memberVO = new RequestToVOConverter<MemberVO>(
				"org.thinker.vo.MemberVO", request).getObject();

		List<MemberVO> memberList = memberDAO.login(memberVO);

		if (memberList.size() == 0 ? false : true) {
			session.setAttribute("id", memberList.get(0).getId());
			session.setAttribute("pw", memberList.get(0).getPw());
			session.setAttribute("name", memberList.get(0).getName());
			session.setAttribute("rank", memberList.get(0).getRank());
		}

		logger.info("memberList :" + memberList);

		return "redirect:/book/list";
	}

	private String messageGET(WebRequest request, WebResponse response)
			throws Exception {

		logger.info("messageGET");
		
		session = request.getSession();
		String id = (String) session.getAttribute("id");
		logger.info("id: "+ id);
		MessageVO messageVO = new RequestToVOConverter<MessageVO>(
				"org.thinker.vo.MessageVO", request).getObject();
		List<MessageVO> messageList = new ArrayList<MessageVO>();
		messageList = memberDAO.getMessageList(messageVO);

		request.setAttribute("messageList", messageList);
		logger.info(messageList);
		return getLocalPath() + "message.jsp";
	}

	private String registMemberGET(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("registMemberGET");

		return getLocalPath() + "registMember.jsp";
	}

	private String registMemberPOST(WebRequest request, WebResponse response)
			throws Exception {

		logger.info("regsitMemberPost");

		MemberVO memberVO = new RequestToVOConverter<MemberVO>(
				"org.thinker.vo.MemberVO", request).getObject();

		memberDAO.createMember(memberVO);

		logger.info(memberVO);

		return "redirect:/book/book/bookList";

	}

	private String myPageGET(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("myPageGET");
		
		MemberVO memberVO = new RequestToVOConverter<MemberVO>(
				"org.thinker.vo.MemberVO", request).getObject();
		List<BorrowVO> borrowList = new ArrayList<BorrowVO>();
		borrowList = memberDAO.getBorrowListForUser(memberVO);

		request.setAttribute("borrowList", borrowList);
		logger.info(borrowList);

		return getLocalPath() + "myPage.jsp";
	}

	private String adminPageGET(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("adminPageGET");

		List<BorrowVO> borrowList = memberDAO.getBorrowListForAdmin();
		List<ReservationVO> reservationList = memberDAO
				.getReservationListForAdmin();

		logger.info("borrowList :" + borrowList);
		logger.info("reservationList :" + reservationList);

		request.setAttribute("borrowList", borrowList);
		request.setAttribute("reservationList", reservationList);

		return getLocalPath() + "adminPage.jsp";
	}

}
