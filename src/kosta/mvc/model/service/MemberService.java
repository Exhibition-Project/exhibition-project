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
	 * id, password �޾Ƽ� �´� MemberDTO�� �����´�.
	 */
	public MemberDTO login(String id, String password) throws Exception{
		
		MemberDTO memberDTO = memberDAO.login(id, password);
		if (memberDTO == null) {
			throw new Exception("ID�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		
		Session session = new Session(memberDTO.getMemberNo(), memberDTO.getMemberId());
		
		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.addSession(session);
		return memberDTO;
	}
	
	/**
	 * ȸ���ߺ���ȸ
	 */
	public int getMemberId(String id) {
		return memberDAO.getMemberId(id); 
	}
	
	/**
	 * ȸ������
	 */
	public int insertMembership(MemberDTO memberDTO) {
		return memberDAO.insertMembership(memberDTO);
	}

	/**
	 * ������й�ȣ�� ��ġ�ϴ��� üũ 
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
	 * ����������
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
	 * �� �α����� ȸ������ ��ȸ
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