package kosta.mvc.model.service;

import java.util.Iterator;
import java.util.Set;

import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.dao.MemberDAOImpl;
import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();
	
	/**
	 * id, password 받아서 맞는 MemberDTO를 가져온다.
	 */
	public MemberDTO login(String id, String password) throws Exception{
		
		MemberDTO memberDTO = memberDAO.login(id, password);
		if (memberDTO == null) {
			throw new Exception("ID와 비밀번호가 틀렸습니다.");
		}
		
		Session session = new Session(memberDTO.getMemberNo(), memberDTO.getMemberId());
		
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.addSession(session);
		return memberDTO;
	}
	
	/**
	 * 회원중복조회
	 */
	public int getMemberId(String id) {
		return memberDAO.getMemberId(id); 
	}
	
	/**
	 * 회원가입
	 */
	public int insertMembership(MemberDTO memberDTO) {
		return memberDAO.insertMembership(memberDTO);
	}

	/**
	 * 기존비밀번호와 일치하는지 체크 
	 */
	public int checkPassword(String confirmPassword) {
		SessionSet sessionSet = SessionSet.getInstance();
		Set<Session> set = sessionSet.getSessionSet();
		Iterator<Session> iterator = set.iterator();
		Session session = null;
		if (iterator.hasNext()) {
			session = iterator.next();
		}
		int result = memberDAO.checkPassword(session.getSessionNo(), confirmPassword);
		return result;
	}
	
	/**
	 * 고객정보수정
	 */
	public int updateMember(String confirmPassword, MemberDTO updateMemberDTO) {
		SessionSet sessionSet = SessionSet.getInstance();
		Set<Session> set = sessionSet.getSessionSet();
		Iterator<Session> iterator = set.iterator();
		Session session = null;
		if (iterator.hasNext()) {
			session = iterator.next();
		}
		int memberNo = session.getSessionNo();
		String memberID = session.getSessionId();
		return memberDAO.updateMember(memberNo, updateMemberDTO);
	}

	/**
	 * 고객 로그인한 회원정보 조회
	 */
	public MemberDTO memberSelectReservation() {
		SessionSet sessionSet = SessionSet.getInstance();
		Set<Session> set = sessionSet.getSessionSet();
		Iterator<Session> iterator = set.iterator();
		Session session = null;
		if (iterator.hasNext()) {
			session = iterator.next();
		}
		int memberNo = session.getSessionNo();
		String memberID = session.getSessionId();
		MemberDTO memberDTO = memberDAO.selectMemberInformation(memberNo, memberID);
		return memberDTO;
	}

	public void logout() {
		SessionSet ss = SessionSet.getInstance();
		for (Session s : ss.getSessionSet()) {
			ss.removeSession(s);
		}
	}
}