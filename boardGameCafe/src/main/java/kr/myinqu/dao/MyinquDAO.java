package kr.myinqu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.myinqu.vo.MyinquVO;
import kr.util.DBUtil;
import kr.util.StringUtil;

public class MyinquDAO {
	
	//싱글턴 패턴
	private static MyinquDAO instance = new MyinquDAO();
	
	public static MyinquDAO getInstance() {
		return instance;
	}
	private MyinquDAO() {}
		
	
	
	//총 레코드 수
	public int getInQuCount(int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//커넥셔풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT COUNT(*) FROM inquiry WHERE mem_num=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, mem_num);

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
	
	
	
	//내가 쓴 문의 목록
	public List<MyinquVO> getInquListBoard(int start, int end, int mem_num)
	                                   throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyinquVO> list = null;
		String sql = null;
		
		try {
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM "
					+ "(SELECT * FROM inquiry WHERE mem_num=? ORDER BY inqu_num DESC)a) "
					+ "WHERE rnum>=? AND rnum<=?";
					
			
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			//SQL문을 실행해서 결과행들을 ResultSet에 담음
			rs = pstmt.executeQuery();
			list = new ArrayList<MyinquVO>();
			while(rs.next()) {
				MyinquVO Myinqu = new MyinquVO();
				Myinqu.setInqu_num(rs.getInt("inqu_num"));
				Myinqu.setInqu_title(StringUtil.useNoHtml(rs.getString("inqu_title")));
				Myinqu.setInqu_content(StringUtil.useNoHtml(rs.getString("inqu_content")));
				Myinqu.setInqu_reg_date(rs.getDate("inqu_reg_date"));				
				list.add(Myinqu);
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return list;
	}	
	
		
		
		
}
