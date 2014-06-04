package org.thinker.dao;

import org.apache.log4j.Logger;
import org.thinker.common.AbstractDBUtil;
import org.thinker.common.generateQuery;
import org.thinker.vo.BookVO;
import org.thinker.vo.BorrowVO;
import org.thinker.vo.ReservationVO;

public class BorrowDAO {
	private static Logger logger = Logger.getLogger(BorrowDAO.class);
	
	//도서대여시호출되는메소드
	public void borrow(final BorrowVO borrowVO,final BookVO bookVO)throws Exception {
        logger.info("createBorrower......");
        
	    final StringBuffer sb = new StringBuffer();
        sb.append(generateQuery.createBorrowQuery);

        new AbstractDBUtil() {

             @Override
             protected void execute() throws Exception {

                  int i = 1;

                  pstmt = con.prepareStatement(sb.toString());              
                  pstmt.setInt(i++, borrowVO.getBno());
                  pstmt.setString(i++, borrowVO.getId());

                  int createBorrowCnt = pstmt.executeUpdate();
                  
                  sb.setLength(0);
                  
                  sb.append(generateQuery.updateBookStatusQuery);
                  
                  
                  i = 1;
                  pstmt = con.prepareStatement(sb.toString());
                  pstmt.setString(i++, bookVO.getStatus());
                  pstmt.setInt(i++, bookVO.getBno());

                  int updateBookStatusCnt = pstmt.executeUpdate();
                  logger.info(updateBookStatusCnt);
                  
                  sb.setLength(0);
                  logger.info(bookVO);
                  logger.info(borrowVO);

                  
             }
        }.doExecute();
	}
	//책반납시예약자가없을경우호출되는메소드
	public void bookReturn(final BorrowVO borrowVO,final BookVO bookVO)  throws Exception{
        logger.info("updateBorrowReturnDate...........");
       
	    final StringBuffer sb = new StringBuffer();
        sb.append(generateQuery.updateBorrowReturnDateQuery);
        new AbstractDBUtil() {

             @Override
             protected void execute() throws Exception {

          	   	//반납일자를 변경해준다 null -> sysdate
                  int i = 1;
                  pstmt = con.prepareStatement(sb.toString());
                  pstmt.setInt(i++, borrowVO.getBwno());
                  int updateBorrowReturnDateCnt = pstmt.executeUpdate();
                  logger.info(updateBorrowReturnDateCnt);
                  sb.setLength(0);
                  
                 //책상태 업데이트:  반납되었으니 책의 상태를 대출중에서 대출가능으로 
                  i = 1;
                  sb.append(generateQuery.updateBookStatusQuery);
                  pstmt = con.prepareStatement(sb.toString());
                  pstmt.setString(i++, bookVO.getStatus());
                  pstmt.setInt(i++, bookVO.getBno());
                  int updateBookStatusCnt = pstmt.executeUpdate();
                  logger.info(updateBookStatusCnt);
                  sb.setLength(0);
                  logger.info(bookVO);
                  logger.info(borrowVO);                   
             }
        }.doExecute();
   }
   
   //책반납시예약자가있을경우호출되는메소드
   public void reservedBookRetrun(final BorrowVO borrowVO,final ReservationVO reservationVO)  throws Exception{
       logger.info("updateBorrowReturnDateAndCreateMessage");
      
	    final StringBuffer sb = new StringBuffer();
       sb.append(generateQuery.updateBorrowReturnDateQuery);
       new AbstractDBUtil() {

            @Override
            protected void execute() throws Exception {

         	   	//반납일자를 변경해준다 null -> sysdate
                 int i = 1;
                 pstmt = con.prepareStatement(sb.toString());
                 pstmt.setInt(i++, borrowVO.getBwno());
                 int updateBorrowReturnDateCnt = pstmt.executeUpdate();
                 logger.info(updateBorrowReturnDateCnt);
                 sb.setLength(0);
                 
                //책상태 업데이트:  반납되었으니 책의 상태를 대출중에서 대출가능으로 
                  i = 1;
                  sb.append(generateQuery.createMessageQuery);
 					pstmt = con.prepareStatement(sb.toString());

 					pstmt.setString(i++, "Admin");
 					pstmt.setString(i++, reservationVO.getId());
 					pstmt.setString(i++, "책이 반납되었습니다.");

 					int createMessageCnt = pstmt.executeUpdate();

            }
       }.doExecute();
  }
}
