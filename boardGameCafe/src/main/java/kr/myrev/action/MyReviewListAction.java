package kr.myrev.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.myrev.dao.MyrevDAO;
import kr.myrev.vo.MyrevVO;
import kr.util.PagingUtil;

public class MyReviewListAction implements Action {

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
		
		
		MyrevDAO dao = MyrevDAO.getInstance();
		int count = dao.getRevCount(user_num);
		
		//페이지 처리
		//currentPage,count,rowCount,pageCount,url
		PagingUtil page = new PagingUtil(
				Integer.parseInt(pageNum),count,10,10,"myReviewList.do");
		
		List<MyrevVO> list = null;
		
		if(count > 0) {
			list = dao.getReviewListBoard(page.getStartRow(),
					                page.getEndRow(),
					                user_num);
		}
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("page", page.getPage());
		
		
		return "/WEB-INF/views/myreview/myreviewlist.jsp";
	}

}
