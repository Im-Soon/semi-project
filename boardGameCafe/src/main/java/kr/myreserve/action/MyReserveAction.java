package kr.myreserve.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.myreserve.dao.MyReserveDAO;
import kr.myreserve.vo.MyReserveVO;
import kr.util.PagingUtil;

public class MyReserveAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Integer user_num = 
				(Integer)session.getAttribute("user_num");
		if(user_num==null) {//로그인이 되지 않은 경우
			return "redirect:/mymember/loginForm.do";
		}
		//로그인 된 경우
		
		
		//페이지 번호 반환
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		
		
		MyReserveDAO dao = MyReserveDAO.getInstance();
		//총 레코드 수 - 예약목록
		int count = dao.getMyReserveCount(user_num);
		//총 레코드 수 - 오늘예약
		int todaycount = dao.getMyReserveCountToday(user_num);
		//페이지 처리
		//currentPage,count,rowCount,pageCount,url
		PagingUtil page = new PagingUtil(
				Integer.parseInt(pageNum),count,10,10,"myReserve.do");
		//예약목록
		List<MyReserveVO> list = null;
		if(count > 0) {
			list = dao.getMyReserveListBefore(page.getStartRow(),
					                page.getEndRow(),
					                user_num);
		}
		//오늘예약
		MyReserveVO MyRe = new MyReserveVO();
		if(todaycount > 0) {
			MyRe = dao.getMyReserveToday(user_num);
		}
		
		
		
		
		request.setAttribute("count", count);
		request.setAttribute("todaycount", todaycount);

		request.setAttribute("list", list);
		request.setAttribute("MyRe", MyRe);
		
		request.setAttribute("page", page.getPage());
		
		
		
		return "/WEB-INF/views/myreserve/myreservelist.jsp";
	}

}
