package org.thinker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.thinker.common.BookJsonParser;
import org.thinker.common.PageUtil;
import org.thinker.common.ReflectServlet;
import org.thinker.common.RequestToVOConverter;
import org.thinker.common.WebRequest;
import org.thinker.common.WebResponse;
import org.thinker.dao.BookDAO;
import org.thinker.vo.BookVO;
import org.thinker.vo.BorrowVO;
import org.thinker.vo.CommentVO;
import org.thinker.vo.Criteria;

public class BookController extends ReflectServlet {

	BookDAO bookDAO;
	HttpSession session;
	
	public BookController() {
		setLocalPath(PATH + "book/");
		bookDAO = new BookDAO();

	}

	// 주소에 아무것도 안치고 들어왔을 경우
	private String doGET(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("doGET....");
		return "redirect:/book/list";
	}

	// 책 리스트를 보여준다
	private String listGET(WebRequest request, WebResponse response)
			throws Exception {

		logger.info("listGET.....................");

		Criteria cri = new RequestToVOConverter<Criteria>(
				"org.thinker.vo.Criteria", request).getObject();
		cri.setPageNumber(request.getIntParameter("pageNumber", 1));
		logger.info(cri);

		List<BookVO> bookList = bookDAO.getBookList(cri);
		request.setAttribute("bookList", bookList);
		logger.info(bookList);

		return getLocalPath() + "bookList.jsp";
	}

	// 책 상세정보를 보여준다
	private String bookDetailGET(WebRequest request, WebResponse response)
			throws Exception {

		logger.info("bookDetailGet.....................");

		session = request.getSession();
		String id = (String) session.getAttribute("id");
		logger.info(id);
		
		
		BookVO bookVO = new BookVO();
		bookVO = new RequestToVOConverter<BookVO>("org.thinker.vo.BookVO",
				request).getObject();
		bookVO = bookDAO.getBookDetail(bookVO).get(0);
		logger.info(bookVO);
		request.setAttribute("bookVO", bookVO);

		return getLocalPath() + "bookDetail.jsp";
	}

	// 코멘트를 보여준다

	private String commentGET(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("commentGET");
		int pageNum = request.getIntParameter("pageNum", 1);
		CommentVO vo = new CommentVO();
		vo = new RequestToVOConverter<CommentVO>("org.thinker.vo.CommentVO",
				request).getObject();
		List<CommentVO> commentList = bookDAO.getCommentList(vo, pageNum);
		logger.info(commentList);
		
		if (commentList.size() != 0) {
			List<String> pageNumberList = new PageUtil().makePageList(pageNum,
					commentList.get(0).getTotalcnt());
			request.setAttribute("pageNumberList", pageNumberList);
			request.setAttribute("currentPnum", pageNum);
		}
		
		
		request.setAttribute("bno", vo.getBno());
		request.setAttribute("commentList", commentList);
		return getLocalPath() + "comment.jsp";
	}

	// 코멘트를 입력한다
	private String commentPOST(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("commentPOST............");

		CommentVO vo = new RequestToVOConverter<CommentVO>("org.thinker.vo.CommentVO", request).getObject();
		vo.setId("user69");
		bookDAO.createComment(vo);
		
		return "redirect:/book/comment?bno="+vo.getBno();
	}

	// 책 등록창을 보여준다
	private String registBookGET(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("registBookGET........");

		return getLocalPath() + "registBook.jsp";
	}

	// 책을 등록한다
	private String registBookPOST(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("registBookPOST......");
		long isbn = request.getLongParameter("isbn");

		BookJsonParser bjp = new BookJsonParser();
		BookVO bookVO = bjp.getBookInfo(isbn);
		logger.info(bookVO);
		bookDAO.createBook(bookVO);
		
		return "redirect:/member/adminPage";
	}
	
	
	//책 대여
	private String borrowPOST(WebRequest request, WebResponse response)
			throws Exception {
		logger.info("registBookPOST......");

		
		BorrowVO borrowVO = new RequestToVOConverter<BorrowVO>("org.thinker.vo.BorrowVO", request).getObject();
		logger.info(borrowVO);
		
		
		
		
		return "redirect:/book/list";
	}
	
	

}
