package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전송된 데이터 인코딩 처리 
		request.setCharacterEncoding("utf-8");
		String mem_id = request.getParameter("mem_id");
		String mem_pw= request.getParameter("mem_pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.checkMember(mem_id);
		boolean check = false;
		
		if(member!=null){
			check=member.isCheckedPassword(mem_pw);
			request.setAttribute("mem_auth", member.getMem_auth());
		}
		if(check) {
			HttpSession session = request.getSession();
			session.setAttribute("user_num", member.getMem_num());
			session.setAttribute("user_id", member.getMem_id());
			session.setAttribute("user_auth", member.getMem_auth());
			session.setAttribute("user_photo", member.getMem_photo());

			return "redirect:/main/main.do";
		}
		return "/WEB-INF/views/member/login.jsp";
	}
}








