package kr.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.notice.dao.NoticeDAO;
import kr.notice.vo.NoticeVO;
import kr.util.StringUtil;

public class NoticeUpdateFormAction implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int noti_num = Integer.parseInt(request.getParameter("noti_num"));

		NoticeDAO dao = NoticeDAO.getInstance();
		
		NoticeVO notice = dao.getNotice(noti_num);
		
		//로그인이 되어 있고 로그인한 회원번호와 작성자 회원번호가 일치
		
		//제목에 큰 따옴표가 있으면 input 태그에 데이터를 표시할 때
		//오동작이 일어나기 때문에 " -> &quot; 로 변환
		notice.setNoti_title(StringUtil.parseQuot(notice.getNoti_title()));
		
		request.setAttribute("notice", notice);

		return "/WEB-INF/views/notice/noticeUpdateForm.jsp";
	}
}
