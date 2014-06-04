package org.thinker.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.thinker.common.AbstractDBUtil;
import org.thinker.common.ResultSetToVOConverter;
import org.thinker.common.generateQuery;
import org.thinker.vo.BorrowVO;
import org.thinker.vo.MemberVO;
import org.thinker.vo.MessageVO;
import org.thinker.vo.ReservationVO;

public class MemberDAO {

	private static Logger logger = Logger.getLogger(MemberDAO.class);

	public void createMember(final MemberVO vo) throws Exception {

		logger.info("createMember....");

		final StringBuffer sb = new StringBuffer();
		sb.append(generateQuery.createMemberQuery);

		logger.info("Query: " + generateQuery.createMemberQuery);
		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(i++, vo.getId());
				pstmt.setString(i++, vo.getName());
				pstmt.setString(i++, vo.getPhone());
				pstmt.setString(i++, vo.getPw());

				int createMemberCnt = pstmt.executeUpdate();
				logger.info("createMemberCnt...." + createMemberCnt);
				sb.setLength(0);
			}
		}.doExecute();

	}

	public List<MemberVO> login(final MemberVO vo) throws Exception {

		logger.info("login....");

		final StringBuffer sb = new StringBuffer();

		final List<MemberVO> memberList = new ArrayList<MemberVO>();

		sb.append(generateQuery.loginQuery);

		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(i++, vo.getId());
				pstmt.setString(i++, vo.getPw());

				rs = pstmt.executeQuery();

				while (rs.next()) {

					MemberVO vo = new ResultSetToVOConverter<MemberVO>(
							"org.thinker.vo.MemberVO", rs).getObject();

					memberList.add(vo);

					logger.info("vo..." + vo);
				}
				sb.setLength(0);
				
			}
		}.doExecute();

		return memberList;

	}

	public List<MemberVO> idDuplicateCheck(final MemberVO vo) throws Exception {

		logger.info("idDuplicateCheck....");

		final StringBuffer sb = new StringBuffer();

		final List<MemberVO> memberList = new ArrayList<MemberVO>();

		sb.append(generateQuery.duplicateCheckQuery);
		
		logger.info("query...." + generateQuery.duplicateCheckQuery);
		
		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(i++, vo.getId());

				rs = pstmt.executeQuery();

				while (rs.next()) {

					MemberVO vo = new ResultSetToVOConverter<MemberVO>(
							"org.thinker.vo.MemberVO", rs).getObject();

					logger.info("vo..." + vo);

					memberList.add(vo);

				}
				sb.setLength(0);
			}
		}.doExecute();

		return memberList;

	}
	
	public List<BorrowVO> getBorrowListForUser(final MemberVO vo) throws Exception{
		
		logger.info("getBorrowListForUser.....");
		
		final StringBuffer sb = new StringBuffer();
		final List<BorrowVO> borrowList = new ArrayList<BorrowVO>();
		
		sb.append(generateQuery.getBorrowListQuery + " and id = ?");
		
		logger.info("query...." + generateQuery.getBorrowListQuery + " and id = ?");
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {
				pstmt = con.prepareStatement(sb.toString());
				int i = 1;
				pstmt.setString(i++, vo.getId());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					BorrowVO vo = new ResultSetToVOConverter<BorrowVO>("org.thinker.vo.BorrowVO", rs).getObject();
					
					borrowList.add(vo);
					
					logger.info("vo...." + vo);
					
				}
				sb.setLength(0);
			}
		}.doExecute();
		
		return borrowList;
		
	}
	
	public List<BorrowVO> getBorrowListForAdmin() throws Exception{
		
		logger.info("getBorrowListForAdmin........");
		
		final List<BorrowVO> borrowList = new ArrayList<BorrowVO>();
	    final StringBuffer sb = new StringBuffer();
		
	    sb.append(generateQuery.getBorrowListQuery);
		
	    logger.info("query...." + generateQuery.getBorrowListQuery);
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {
				
				pstmt = con.prepareStatement(sb.toString());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					BorrowVO vo = new ResultSetToVOConverter<BorrowVO>("org.thinker.vo.BorrowVO", rs).getObject();
					
					borrowList.add(vo);
					
					logger.info(vo);
				}
				sb.setLength(0);
				
			}
		}.doExecute();
		
		return borrowList;
		
	}
	
	public List<ReservationVO> getReservationListForUser(final ReservationVO vo) throws Exception{
		
		logger.info("getReservationListForUser......");
		
		final StringBuffer sb = new StringBuffer();		
		sb.append(generateQuery.getReservationListForUserQuery);
		
		logger.info("query....." + generateQuery.getReservationListForUserQuery);
		
		final List<ReservationVO> ReservationList = new ArrayList<ReservationVO>();
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {

				pstmt = con.prepareStatement(sb.toString());
				int i = 1;
				pstmt.setString(i++, vo.getId());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					ReservationVO vo = new ResultSetToVOConverter<ReservationVO>("org.thinker.vo.ReservationVO", rs).getObject();
					
					ReservationList.add(vo);	
					
					
					logger.info(vo);
				}
				sb.setLength(0);
				
			}
		}.doExecute();
		
		return ReservationList;
		
	}


	public List<ReservationVO> getReservationListForAdmin() throws Exception{
		
		
		logger.info("getReservationListForAdmin......");
		
		final StringBuffer sb = new StringBuffer();		
		sb.append(generateQuery.getReservationListForAdminQuery);
		
		logger.info("query....." + generateQuery.getReservationListForAdminQuery);
		
		final List<ReservationVO> ReservationList = new ArrayList<ReservationVO>();
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {

				pstmt = con.prepareStatement(sb.toString());
				int i = 1;
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					ReservationVO vo = new ResultSetToVOConverter<ReservationVO>("org.thinker.vo.ReservationVO", rs).getObject();
					ReservationList.add(vo);
					
					logger.info(vo);
				}
				sb.setLength(0);
				
			}
		}.doExecute();
		return ReservationList;
		
		
	}
	
	public void createMessage(final MessageVO vo) throws Exception {
		
		logger.info("createMessage..........");
		
		final StringBuffer sb = new StringBuffer();

		sb.append(generateQuery.createMessageQuery);
		
		logger.info("query..." + generateQuery.createMessageQuery);

		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {
				
				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(i++, vo.getFromId());
				pstmt.setString(i++, vo.getToId());
				pstmt.setString(i++, vo.getMsg());

				int createMessageCnt = pstmt.executeUpdate();
				
				logger.info("createMessageCnt:" + createMessageCnt);

				sb.setLength(0);
			}

		}.doExecute();
		
	}
	
	public List<MessageVO> getMessageList(final MessageVO vo) throws Exception {
		
		logger.info("getMessageList..........");
		
		final StringBuffer sb = new StringBuffer();

		final List<MessageVO> messageList = new ArrayList<MessageVO>();

		sb.append(generateQuery.getMessageListQuery);

		logger.info("query...." + generateQuery.getMessageListQuery);

		new AbstractDBUtil() {

			@Override
			protected void execute() throws Exception {

				int i = 1;

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(i++, vo.getToId());

				rs = pstmt.executeQuery();

				while (rs.next()) {
					MessageVO vo = new ResultSetToVOConverter<MessageVO>(
							"org.thinker.vo.MessageVO", rs).getObject();
					
					messageList.add(vo);
					
					logger.info("vo...." + vo);
				}
				sb.setLength(0);
			}
		}.doExecute();

		return messageList;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
};
