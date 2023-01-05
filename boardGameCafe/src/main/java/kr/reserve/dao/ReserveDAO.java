package kr.reserve.dao;


public class ReserveDAO {
	   //╫л╠шео фпео
	   private static ReserveDAO instance = new ReserveDAO();
	   
	   public static ReserveDAO getInstance() {
	      return instance;
	   }
	   private ReserveDAO() {}
}
