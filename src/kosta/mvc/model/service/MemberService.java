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
	public MemberDTO login(String id, String password) {
		MemberDTO memberDTO= memberDAO.login(id, password);
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
	 * 고객정보수정
	 */
	public int updateMember( MemberDTO memberDTO, MemberDTO updateMemberDTO) {
		return memberDAO.updateMember(memberDTO, updateMemberDTO);
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
}