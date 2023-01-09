package kr.myreserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.myreserve.vo.MyReserveVO;
import kr.util.DBUtil;
import kr.util.StringUtil;

public class MyReserveDAO {

	//싱글턴 패턴
	private static MyReserveDAO instance = new MyReserveDAO();
	
	public static MyReserveDAO getInstance() {
		return instance;
	}
	private MyReserveDAO() {}
	
	
	
	//총 레코드 수 - 예약목록
	public int getMyReserveCount(int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//커넥셔풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT COUNT(*) FROM reserve WHERE mem_num=?";
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
	
	
	
	//내 예약 목록 - 지난예약(예약날짜로 정렬)
	public List<MyReserveVO> getMyReserveListBefore(int start, int end, int mem_num)
	                                   throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MyReserveVO> list = null;
		String sql = null;
		
		try {
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM (SELECT r.*,m.room_name,m.room_size,m.room_detail, rownum rnum FROM (SELECT * FROM reserve WHERE mem_num=?)r JOIN room m ON m.room_num=r.room_num) WHERE rnum>=? AND rnum<=? ORDER BY res_date DESC";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			//SQL문을 실행해서 결과행들을 ResultSet에 담음
			rs = pstmt.executeQuery();
			list = new ArrayList<MyReserveVO>();
			while(rs.next()) {
				MyReserveVO MyRe = new MyReserveVO();
				MyRe.setRes_date(StringUtil.useNoHtml(rs.getString("res_date")));
				MyRe.setRes_time(StringUtil.useNoHtml(rs.getString("res_time")));				
				MyRe.setRoom_name(StringUtil.useNoHtml(rs.getString("room_name")));
				MyRe.setRoom_size(rs.getInt("room_size"));
				MyRe.setRoom_detail(StringUtil.useNoHtml(rs.getString("room_detail")));
				
				list.add(MyRe);
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return list;
	}	
	
	//총 레코드 수 - 오늘예약
	public int getMyReserveCountToday(int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int todaycount = 0;
		
		try {
			//커넥셔풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT COUNT(*) FROM reserve WHERE mem_num=? AND res_date=TO_CHAR(SYSDATE, 'YY/MM/DD')";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, mem_num);

			//SQL문을 실행하고 결과행을 ResultSet 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				todaycount = rs.getInt(1);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return todaycount;
	}
	
	//오늘 예약 내용
	public MyReserveVO getMyReserveToday(int mem_num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyReserveVO MyRe = null;
		String sql = null;
		
		try {
			//커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			//SQL문 작성
			sql = "SELECT * FROM reserve r JOIN room m ON r.room_num=m.room_num WHERE r.mem_num=? AND r.res_date=TO_CHAR(SYSDATE, 'YY/MM/DD')";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, mem_num);
			//SQL문을 실행해서 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MyRe = new MyReserveVO();
				
				MyRe.setRes_date(StringUtil.useNoHtml(rs.getString("res_date")));
				MyRe.setRes_time(StringUtil.useNoHtml(rs.getString("res_time")));				
				MyRe.setRoom_name(StringUtil.useNoHtml(rs.getString("room_name")));
				MyRe.setRoom_size(rs.getInt("room_size"));
				MyRe.setRoom_detail(StringUtil.useNoHtml(rs.getString("room_detail")));
				
				MyRe.setPhoto1(StringUtil.useNoHtml(rs.getString("photo1")));
				MyRe.setPhoto2(StringUtil.useNoHtml(rs.getString("photo2")));
				MyRe.setPhoto3(StringUtil.useNoHtml(rs.getString("photo3")));
				MyRe.setRes_num(rs.getInt("res_num"));//나중에 쓸 수도 있으니 일단 추가
				
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return MyRe;
	}		
}	
