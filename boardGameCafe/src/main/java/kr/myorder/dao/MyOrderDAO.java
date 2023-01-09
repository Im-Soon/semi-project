/*

구매목록 페이지도 배우는지 월욜에 물어보고 월욜에 하기




package kr.myorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.myorder.vo.MyOrderVO;
import kr.myrev.vo.MyrevVO;
import kr.util.DBUtil;
import kr.util.StringUtil;

public class MyOrderDAO {
	//싱글턴 패턴
	private static MyOrderDAO instance = new MyOrderDAO();
	
	public static MyOrderDAO getInstance() {
		return instance;
	}
	private MyOrderDAO() {}
			
	//총 레코드 수
	public int getOrderCount(int mem_num, int order_main_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//커넥셔풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT COUNT(*) FROM order_main WHERE mem_num=? AND order_main_num=? ";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, order_main_num);

			//SQL문을 실행하고 결과행을 ResultSet 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}
			
	//내가 쓴 댓글 목록
	public List<MyOrderVO> getOrderListBoard(int start, int end, int mem_num, int order_main_num)
		            								throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyOrderVO> list = null;
		String sql = null;
		
		try {
		//커넥션풀로부터 커넥션을 할당
		conn = DBUtil.getConnection();
		
		
		sql = "SELECT * FROM (SELECT a.*, rownum rnum, p.pro_name FROM "
			+ "(SELECT * FROM review WHERE mem_num=? ORDER BY rev_num DESC) a "
			+ "JOIN product p ON a.pro_num=p.pro_num) "
			+ "WHERE rnum>=? AND rnum<=?";
		
		sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM "
			+ "(SELECT * FROM inquiry WHERE mem_num=? ORDER BY inqu_num DESC)a) "
			+ "WHERE rnum>=? AND rnum<=?";
		
		//SQL문 작성
		sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM "
			+ "(SELECT * FROM order_main WHERE mem_num=? AND order_main_num=? ORDER BY order_main_num DESC)a) "
			+ "WHERE rnum>=? AND rnum<=?";
		
		//PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setInt(1, mem_num);
		pstmt.setInt(2, order_main_num);
		pstmt.setInt(3, start);
		pstmt.setInt(4, end);
		
		//SQL문을 실행해서 결과행들을 ResultSet에 담음
		rs = pstmt.executeQuery();
		list = new ArrayList<MyrevVO>();
		
		while(rs.next()) {
		MyrevVO Myrev = new MyrevVO();
		Myrev.setRev_num(rs.getInt("rev_num"));
		Myrev.setRev_content(StringUtil.useNoHtml(rs.getString("rev_content")));
		Myrev.setRev_date(rs.getDate("rev_date"));
		Myrev.setPro_name(StringUtil.useNoHtml(rs.getString("pro_name")));
		list.add(Myrev);
		}
		
		}catch(Exception e) {
		throw new Exception(e);
		}finally {
		DBUtil.executeClose(rs, pstmt, conn);
		}
		return list;
	}	
	
	
	
	
	
	
	
	
	
}


*/
