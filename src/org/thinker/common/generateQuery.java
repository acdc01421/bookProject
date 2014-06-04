package org.thinker.common;

import org.thinker.vo.Criteria;


public class generateQuery {

	public final static String preQuery = "select rn, bno, image, title, author, pyear, isbn, publisher, status, regdate, cnt, category, description from ( select /*+INDEX_DESC (tbl_book pk_book) */ rownum rn, bno, image, title, author, pyear, isbn, publisher, status, regdate, count(bno) over() cnt, category, description from tbl_book where rownum <=(CEIL(?/10)*60)+1 ";
	public final static String postQuery = " ) where rn>(?-1)*6 and rn<=(?*6)";
	public final static String createBookQuery = "insert into tbl_book(bno, image, title, author, pyear, isbn, publisher, category, description) values(seq_member.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
	public final static String getBookDetailQuery = "select bno, image, title, author, pyear, isbn, publisher, status, regdate, category, description from tbl_book where bno = ? ";
	public final static String createBorrowQuery = "insert into tbl_borrow(bwno,bno,id) values(seq_borrow.nextval, ?, ?)";
	
	public final static String updateBookStatusQuery = "update tbl_book set status=? where bno=?";
	public final static String updateBorrowReturnDateQuery = "update tbl_borrow set returndate = sysdate where bwno=?";
	public final static String getBorrowListQuery = "select bw.bno, borrowdate, bwno, duedate, id, returndate, bk.title from tbl_borrow bw, tbl_book bk where bw.bno = bk.bno";
	public final static String createCommentQuery = "insert into tbl_comment(cno, id, bno, content, score) values(seq_comment.nextval, ?, ?, ?, ?)";
	public final static String getCommentListQuery = "select rn,content,id,moddate,regdate,score,cno,totalcnt,bno from ( select /*+INDEX_DESC (tbl_comment pk_comment) */ rownum rn, content, id, moddate, regdate, score, cno, count(cno) over() totalcnt, bno from tbl_comment where rownum <=(CEIL(?/10)*100)+1 and bno = ? ) where rn>(?-1)*10 and rn<=(?*10)";
	
	public final static String createMemberQuery = "insert into tbl_member(ID,NAME,PHONE,PW) values(?,?,?,?)";
	public final static String loginQuery = "select id, pw, name, phone, rank from tbl_member where id = ? and pw = ?";
	public final static String duplicateCheckQuery = "select id, pw, name, phone, rank from tbl_member where id = ? ";
	public final static String createMessageQuery = "insert into tbl_message(mno, fromid, toid, msg) values(seq_message.nextval, ?, ?, ?)";
	public final static String getMessageListQuery = "select mno, toid, msg, regdate from tbl_message where toid=? order by regdate desc";
	
	public final static String createReservationQuery = "insert into tbl_reservation(rno, id, bno) values(seq_reservation.nextval, ?, ?";
	public final static String getReservationListForUserQuery = "select re.bno, re.regdate, id, bk.title from tbl_reservation re, tbl_book bk where re.bno = bk.bno and id = ? order by regdate desc";
	public final static String getReservationListForAdminQuery = "select re.bno, re.regdate, id, bk.title from tbl_reservation re, tbl_book bk where re.bno = bk.bno order by regdate desc";
	public final static String findPrimaryBorrowerQuery ="select ROWNUM priority, bno, id from TBL_RESERVATION where bno = ? and rownum = 1 order by regdate asc ";

	
	public static StringBuffer generateQuery(Criteria cri){
		StringBuffer sb = new StringBuffer();
		
		sb.append(preQuery);
		
		
		if(cri.getType() != null){
			sb.append(" and "+cri.getType() +" like '%'||?||'%' ");
		}
		
		sb.append(postQuery);

		return sb;
	}
}
