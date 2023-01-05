package kr.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.cart.dao.CartDAO;
import kr.controller.Action;

public class CartAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		CartDAO dao = CartDAO.getInstance();
		
		return "/WEB-INF/views/cart/cart.jsp";
	}

}
