package kr.mymember.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.mymember.dao.MemberDAO;
import kr.mymember.vo.MemberVO;
import kr.util.FileUtil;

public class DeleteUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = 
				(Integer)session.getAttribute("user_num");
		if(user_num==null) {//로그인이 되지 않은 경우
			return "redirect:/mymember/loginForm.jsp";
		}
		
		//로그인 된 경우
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//전송된 데이터 반환
		//현재 비밀번호
		String passwd = request.getParameter("passwd");
		//현재 로그인한 아이디
		String user_id = (String)session.getAttribute("user_id");
		
		
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.checkMember2(user_id);
		boolean check = false;
		//비밀번호 일치 여부 체크
		check = member.isCheckedPassword(passwd);
		
		
		if(check) {//인증 성공
			//회원정보 삭제
			dao.deleteMember(user_num);
			//프로필 사진 삭제
			FileUtil.removeFile(request, member.getMem_photo());
			//로그아웃
			session.invalidate();
		}
		
		request.setAttribute("check", check);	
		
		return "/WEB-INF/views/mymember/deleteUser.jsp";
	}

}
