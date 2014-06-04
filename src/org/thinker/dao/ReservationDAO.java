package org.thinker.dao;

import java.util.ArrayList;
import java.util.List;

import org.thinker.common.AbstractDBUtil;
import org.thinker.common.ResultSetToVOConverter;
import org.thinker.common.generateQuery;
import org.thinker.vo.ReservationVO;

public class ReservationDAO {
	
	
	public void createReservation(final ReservationVO vo) throws Exception{
		final StringBuffer sb = new StringBuffer();
		
		sb.append(generateQuery.createReservationQuery);
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub
				pstmt = con.prepareStatement(sb.toString());
				int i=1;
				pstmt.setString(i++, vo.getId());
				pstmt.setInt(i++, vo.getBno());
				
				int CreateCnt = pstmt.executeUpdate();
				
				
				if(CreateCnt == 1 ){
					con.commit();
				}else{
					throw new Exception("Rollback");
				}
				
				sb.setLength(0);
				
				
			}
		}.doExecute();
	}
	
	public List<ReservationVO> getReservationListForUser(final ReservationVO vo) throws Exception{
		
		final StringBuffer sb = new StringBuffer();		
		sb.append(generateQuery.getReservationListForUserQuery);
		
		final List<ReservationVO> ReservationList = new ArrayList<ReservationVO>();
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub
				pstmt = con.prepareStatement(sb.toString());
				int i = 1;
				pstmt.setString(i++, vo.getId());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					ReservationVO vo = new ResultSetToVOConverter<ReservationVO>("com.library.vo.ReservationVO", rs).getObject();
					ReservationList.add(vo);					
				}
				sb.setLength(0);
				
			}
		}.doExecute();
		return ReservationList;
		
	}

	
	public List<ReservationVO> getReservationListForAdmin() throws Exception{
		
		final StringBuffer sb = new StringBuffer();		
		sb.append(generateQuery.getReservationListForAdminQuery);
		
		final List<ReservationVO> ReservationList = new ArrayList<ReservationVO>();
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub
				pstmt = con.prepareStatement(sb.toString());
				int i = 1;
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					ReservationVO vo = new ResultSetToVOConverter<ReservationVO>("com.library.vo.ReservationVO", rs).getObject();
					ReservationList.add(vo);					
				}
				sb.setLength(0);
				
			}
		}.doExecute();
		return ReservationList;
		
	}
	
	public List<ReservationVO> findPrimaryBorrower(final ReservationVO vo) throws Exception{
		final StringBuffer sb = new StringBuffer();
		sb.append(generateQuery.findPrimaryBorrowerQuery);
		final List<ReservationVO> primaryBorrowerList = new ArrayList<ReservationVO>();
		
		new AbstractDBUtil() {
			
			@Override
			protected void execute() throws Exception {
				// TODO Auto-generated method stub
				pstmt = con.prepareStatement(sb.toString());
				int i=1;
				
				pstmt.setInt(i, vo.getBno());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					ReservationVO vo = new ResultSetToVOConverter<ReservationVO>("com.library.vo.ReservationVO", rs).getObject();
					primaryBorrowerList.add(vo);					
				}
				sb.setLength(0);
			}
			
		
		}.doExecute();
		return primaryBorrowerList;
	}
	
	public static void main(String[] args)throws Exception {
		ReservationDAO dao = new ReservationDAO();
		ReservationVO vo = new ReservationVO();	
		vo.setBno(45);
		System.out.println(dao.findPrimaryBorrower(vo).get(0).getId());
	}
	
}
