package org.thinker.test;

import org.junit.Before;
import org.junit.Test;
import org.thinker.common.BookJsonParser;
import org.thinker.dao.BookDAO;
import org.thinker.vo.BookVO;
import org.thinker.vo.CommentVO;
import org.thinker.vo.Criteria;


public class BookDAOTest {

	
	BookDAO dao;
	
	@Before
	public void ready(){
		dao = new BookDAO();
	}
	

//  책 생성 테스트	
//	@Test
//	public void createTest() throws Exception{
//		
//		BookVO vo  = new BookVO();
//		
//		BookJsonParser bjp = new BookJsonParser();
//		
//		vo = bjp.getBookInfo(8947529524L);
//		
//		
//		dao.createBook(vo);
//		
//	}
	
//  책 리스트보기
	@Test
	public void getBookListTest() throws Exception{
		
		Criteria cri  = new Criteria();
		
		cri.setKeyword("fefe");
		cri.setPageNumber(1);
		cri.setType("title");
	
		
		dao.getBookList(cri);
	
	}
	
	
	//책 상세정보 보기
//	@Test
//	public void getBookdetailTest() throws Exception{
//		
//		BookVO vo  = new BookVO();
//		
//		vo.setBno(1);
//		
//		dao.getBookDetail(vo);
//	
//	}
	
	 //책 서평 달기
//	@Test
//	public void createCommentTest() throws Exception{
//		
//		CommentVO vo = new CommentVO();
//		
//		vo.setId("user20");
//		vo.setBno(9);
//		vo.setContent("재미없다있다없다.");
//		vo.setScore("★★★");
//		
//		
//		dao.createComment(vo);
//	
//	}
	
	//책 서평 보기
//	@Test
//	public void getCommentListTest() throws Exception{
//		
//		CommentVO vo  = new CommentVO();
//		
//		
//	    vo.setBno(9);
//	    
//		
//		dao.getCommentList(vo, 1);
//	
//	}
}