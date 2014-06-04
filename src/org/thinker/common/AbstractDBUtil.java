package org.thinker.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public abstract class AbstractDBUtil {
	
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	private static Logger logger = Logger.getLogger(AbstractDBUtil.class);
	// 외부에선 오로지 doExecute로만 출력
	// final로 하면 하위서 오버라이드 못한다
	// 저안에서 try catch final한다
	public final void doExecute() throws Exception {
		try {
			makeConnection();
			execute();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}

	private void makeConnection() throws Exception {
		logger.info("make Connection");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@61.72.15.156:50404:orcl", "user21",//192.168.0.5:1521
				"user21");
//
//		con = DriverManager.getConnection(
//				"jdbc:oracle:thin:@192.168.0.112:1521:orcl", "user21",//192.168.0.5:1521
//				"user21");
		con.setAutoCommit(false);
		
	}

	// 추상메소드(하위 애들이 쓸것이므로 protected로)
	// 파라미터가 리턴타입을 못받는다 그래서 익명클래스 사용(final로 고정해서)
	protected abstract void execute() throws Exception;

	private void closeAll() {
		logger.info("close all");
		if(rs != null){
			try{ rs.close();}catch(Exception e){}
		}
		if(pstmt != null){
			try{ pstmt.close();}catch(Exception e){}
		}
		if(con != null){
			try{ con.close();}catch(Exception e){}
		}
	}

}
