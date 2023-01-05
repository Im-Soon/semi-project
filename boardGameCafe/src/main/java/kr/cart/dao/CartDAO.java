package kr.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.cart.vo.CartVO;
//import kr.product.vo.ProductVO;
import kr.util.DBUtil;

public class CartDAO {
	//싱글턴 패턴
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
		return instance;
	}
	private CartDAO() {}
	
	//장바구니 등록
		public void insertCart(CartVO cart)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = null;
			
			try {
				//커넥션 풀로부터 커넥션 할당
				conn = DBUtil.getConnection();			
				//SQL문 작성
				sql = "INSERT INTO zcart (cart_num,item_num,"
					+ "order_quantity,mem_num) VALUES ("
					+ "zcart_seq.nextval,?,?,?)";
				//PreparedStatement 객체 생성
				pstmt = conn.prepareStatement(sql);
				//?에 데이터 바인딩
				pstmt.setInt(1, cart.getItem_num());
				pstmt.setInt(2, cart.getOrder_quantity());
				pstmt.setInt(3, cart.getMem_num());
				//SQL문 실행
				pstmt.executeUpdate();			
			}catch (Exception e) {
				throw new Exception(e);
			}finally {
				DBUtil.executeClose(null, pstmt, conn);
			}
		}
	//장바구니 목록
		public List<CartVO> getListCart(int mem_num)throws Exception{
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			List<CartVO> list = null;
			
			
			
			try {
				//커넥션 풀로부터 커넥션 할당
				conn = DBUtil.getConnection();			
				//SQL문 작성
				sql = "SELECT * FROM cart c JOIN product i ON "
						+ "c.pro_num = i.pro_num WHERE c.mem_num = ? "
						+ "ORDER BY i.pro_num ASC";
				//PreparedStatement 객체 생성
				pstmt = conn.prepareStatement(sql);
				//?에 데이터 바인딩
				pstmt.setInt(1, mem_num);
				//SQL문 실행해서 결과행을 ResultSet에 담음
				rs = pstmt.executeQuery();
				list = new ArrayList<CartVO>();
				
				while(rs.next()) {
					CartVO cart = new CartVO();
					cart.setCart_num(rs.getInt("cart_num"));
					cart.setItem_num(rs.getInt("item_num"));
					cart.setOrder_quantity(rs.getInt("order_quantity"));
					cart.setMem_num(rs.getInt("mem_num"));
					
					/*
					 * ProductVO product = new ProductVO(); product.setName(rs.getString("name"));
					 * product.setPrice(rs.getInt("price"));
					 * product.setPhoto1(rs.getString("photo1"));
					 * product.setQuantity(rs.getInt("quantity"));
					 * product.setStatus(rs.getInt("status"));
					 * 
					 * cart.setProductVO(product);
					 */
					//같은 상품의 총 구매 비용 연산
					//cart.setSub_total(cart.getOrder_quantity() * product.getPrice());
					
					list.add(cart);
				}
				
			}catch (Exception e) {
				throw new Exception(e);
			}finally {
				DBUtil.executeClose(rs, pstmt, conn);
			}
			return list;
		}
		//장바구니 상품 등록
		
		//장바구니 상품 삭제
		
		//장바구니 상품 삭제
	
	
}
