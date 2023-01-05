package kr.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.notice.dao.NoticeDAO;
import kr.notice.vo.NoticeVO;
import kr.util.StringUtil;

public class NoticeDetailAction implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//글번호 반환
		int noti_num = Integer.parseInt(request.getParameter("noti_num"));
				
		NoticeDAO dao = NoticeDAO.getInstance();
				
		//조회수 증가
		dao.updateReadcount(noti_num);
				
		NoticeVO notice = dao.getNotice(noti_num);
				
		//HTML 태그를 허용하지 않음
		notice.setNoti_title(StringUtil.useNoHtml(notice.getNoti_title()));
				
		//HTML 태그를 허용하지 않으면서 줄바꿈 처리
		notice.setNoti_content(StringUtil.useBrNoHtml(notice.getNoti_content()));
			
		request.setAttribute("notice", notice);
				
		return "/WEB-INF/views/notice/noticeDetail.jsp";
	}
}
