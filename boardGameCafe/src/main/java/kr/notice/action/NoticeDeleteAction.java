package kr.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.notice.dao.NoticeDAO;
import kr.notice.vo.NoticeVO;
import kr.util.FileUtil;

public class NoticeDeleteAction implements Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int noti_num = Integer.parseInt(request.getParameter("noti_num"));
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO notice = dao.getNotice(noti_num);
		
		//로그인한 회원번호와 작성자 회원번호가 일치
		dao.deleteNotice(noti_num);
		
		//파일 삭제
		FileUtil.removeFile(request, notice.getNoti_file());
		
		return "redirect:/notice/noticeList.do";
	}
}
