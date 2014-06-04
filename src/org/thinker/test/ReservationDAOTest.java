package org.thinker.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.thinker.dao.BookDAO;
import org.thinker.dao.ReservationDAO;
import org.thinker.vo.ReservationVO;

public class ReservationDAOTest {

	ReservationDAO dao;
	private static Logger logger ;
	@Before
	public void ready(){
		dao = new ReservationDAO();
		logger = Logger.getLogger(BookDAO.class);
	}
	
//	@Test
//	public void createReservation()throws Exception {
//		ReservationVO vo = new ReservationVO();
//	
//		vo.setRno(5);
//		dao.cancelReservation(vo);
//	}
	
//	@Test
//	public void findPrimaryBorrower()throws Exception {
//		ReservationVO vo = new ReservationVO();
//		vo.setBno(45);
//		logger.info(dao.findPrimaryBorrower(vo));
//	}


}
