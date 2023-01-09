package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.member.vo.MemberVO;
import kr.util.DBUtil;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	//회원가입 
	public void insertMember(MemberVO member)throws Exception{
		Connection conn = null; 
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String sql = null;
		int num = 0; //시퀀스 번호 저장 
		
		try {
			conn = DBUtil.getConnection();
			
			conn.setAutoCommit(false);
			
			sql = "SELECT MEMBER_SEQ.nextval FROM dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			sql="INSERT INTO MEMBER (mem_num,mem_id)VALUES(?,?)";//MEM
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, num);//회원번호 
			pstmt2.setString(2, member.getMem_id());
			pstmt2.executeUpdate();
			
			sql = "INSERT INTO MEMBER_DETAIL(MEM_NUM,MEM_NAME,MEM_PW,MEM_EMAIL,MEM_PHONE,MEM_ZIPCODE,MEM_ADDRESS1,MEM_ADDRESS2)VALUES(?,?,?,?,?,?,?,?)";
			
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setInt(1, num);
			pstmt3.setString(2, member.getMem_name());
			pstmt3.setString(3, member.getMem_pw());
			pstmt3.setString(4, member.getMem_email());
			pstmt3.setString(5, member.getMem_phone());
			pstmt3.setString(6, member.getMem_zipcode());
			pstmt3.setString(7, member.getMem_address1());
			pstmt3.setString(8, member.getMem_address2());
			pstmt3.executeUpdate();
			
			conn.commit();
			
		}catch(Exception e) {
			//sql 실행 실패시 롤백
			conn.rollback();
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
	}
	//ID중복 체크 및 로그인 처리 
	public MemberVO checkMember(String mem_id)throws Exception{
		System.out.println(mem_id);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM MEMBER m LEFT OUTER JOIN " 
					+ "MEMBER_DETAIL d ON m.MEM_NUM=d.MEM_NUM "
					+ "WHERE m.mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setMem_num(rs.getInt("mem_num"));
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_auth(rs.getInt("mem_auth"));
				member.setMem_pw(rs.getString("mem_pw"));
				member.setMem_photo(rs.getString("mem_photo"));
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return member;
	}
	
}



























