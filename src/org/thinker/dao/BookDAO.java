package org.thinker.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.thinker.common.AbstractDBUtil;
import org.thinker.common.BookJsonParser;
import org.thinker.common.ResultSetToVOConverter;
import org.thinker.common.generateQuery;
import org.thinker.vo.BookVO;
import org.thinker.vo.CommentVO;
import org.thinker.vo.Criteria;

public class BookDAO {

	private static Logger logger = Logger.getLogger(BookDAO.class);

	public void createBook(final BookVO vo) throws Exception {

		logger.info("create........................");

		final StringBuffer sb = new StringBuffer();
		sb.append(generateQuery.createBookQuery);

		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(i++, vo.getImage());
				pstmt.setString(i++, vo.getTitle());
				pstmt.setString(i++, vo.getAuthor());
				pstmt.setInt(i++, vo.getpYear());
				pstmt.setLong(i++, vo.getIsbn());
				pstmt.setString(i++, vo.getPublisher());
				pstmt.setString(i++, vo.getCategory());
				pstmt.setString(i++, vo.getDescription());

				int createBookCnt = pstmt.executeUpdate();
				logger.info(createBookCnt);
				sb.setLength(0);

			}

		}.doExecute();

	}

	public List<BookVO> getBookList(final Criteria cri) throws Exception {

		logger.info("getBookList...........");

		final StringBuffer sb = new StringBuffer();
		final List<BookVO> bookList = new ArrayList<BookVO>();
		sb.append(generateQuery.generateQuery(cri));
		logger.info(generateQuery.generateQuery(cri));
		
		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setInt(i++, cri.getPageNumber());
				if (cri.getType() != null) {
					pstmt.setString(i++, cri.getKeyword());
				}
				pstmt.setInt(i++, cri.getPageNumber());
				pstmt.setInt(i++, cri.getPageNumber());

				rs = pstmt.executeQuery();

				while (rs.next()) {
					BookVO vo = new ResultSetToVOConverter<BookVO>(
							"org.thinker.vo.BookVO", rs).getObject();
					bookList.add(vo);
				}
				sb.setLength(0);
			}

		}.doExecute();
		return bookList;

	}

	public List<BookVO> getBookDetail(final BookVO vo) throws Exception {

		logger.info("getBookDetail...........");
		final StringBuffer sb = new StringBuffer();

		final List<BookVO> bookDetailList = new ArrayList<BookVO>();
		sb.append(generateQuery.getBookDetailQuery);

		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());
				pstmt.setInt(i++, vo.getBno());

				rs = pstmt.executeQuery();

				while (rs.next()) {
					BookVO vo = new ResultSetToVOConverter<BookVO>(
							"org.thinker.vo.BookVO", rs).getObject();

					bookDetailList.add(vo);

				}

				sb.setLength(0);

			}

		}.doExecute();
		return bookDetailList;

	}

	public void createComment(final CommentVO vo) throws Exception {

		logger.info("createComment......");

		final StringBuffer sb = new StringBuffer();

		sb.append(generateQuery.createCommentQuery);

		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {

				// TODO Auto-generated method stub

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(i++, vo.getId());

				pstmt.setInt(i++, vo.getBno());

				pstmt.setString(i++, vo.getContent());

				pstmt.setString(i++, vo.getScore());

				int createCommentCnt = pstmt.executeUpdate();

				logger.info(createCommentCnt);

				
				sb.setLength(0);

			}

		}.doExecute();

	}

	/*
	 * 
	 * date: 2014.05.27 writer: 박명수 details: 서평을 보여주는 메소드
	 */

	public List<CommentVO> getCommentList(final CommentVO vo,

	final int PageNumber) throws Exception {

		logger.info("getCommentList......");

		final List<CommentVO> commentList = new ArrayList<CommentVO>();

		final StringBuffer sb = new StringBuffer();

		sb.append(generateQuery.getCommentListQuery);

		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {

				// TODO Auto-generated method stub

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setInt(i++, PageNumber);

				pstmt.setInt(i++, vo.getBno());

				pstmt.setInt(i++, PageNumber);

				pstmt.setInt(i++, PageNumber);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					CommentVO vo = new ResultSetToVOConverter<CommentVO>(

					"org.thinker.vo.CommentVO", rs).getObject();

					commentList.add(vo);

				}

			}

		}.doExecute();

		sb.setLength(0);

		return commentList;

	}

}
