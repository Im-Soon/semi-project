package kr.notice.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.notice.dao.NoticeDAO;
import kr.notice.vo.NoticeVO;
import kr.util.PagingUtil;

public class NoticeListAction implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		NoticeDAO dao = NoticeDAO.getInstance();
		int count = dao.getCount();
		
		PagingUtil page = new PagingUtil(Integer.parseInt(pageNum), count, 10, 10, "noticeList.do");
		
		List<NoticeVO> list = null;
		if(count > 0) {
			list = dao.getNoticeList(page.getStartRow(), page.getEndRow());
		}
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("pagingHtml", page.getPage());
		
		//JSP 경로 반환
		return "/WEB-INF/views/notice/noticeList.jsp";
	}
}
