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

	SessionSet sessionSet = SessionSet.getInstance(); // �α��ο����� ���� privateó��
	Set<Session> set = sessionSet.getSessionSet();

	/**
	 * id, password �޾Ƽ� �´� MemberDTO�� �����´�.
	 */
	public MemberDTO login(String id, String password) throws Exception {

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

		int result = memberDAO.checkPassword(getSessionNo(), confirmPassword);
		return result;
	}

	/**
	 * ����������
	 */
	public int updateMember(String confirmPassword, MemberDTO updateMemberDTO) {

		int memberNo = getSessionNo();
		return memberDAO.updateMember(memberNo, updateMemberDTO);
	}

	/**
	 * �� �α����� ȸ������ ��ȸ
	 */
	public MemberDTO memberSelectReservation() {

		int memberNo = getSessionNo();
		String memberID = getSessionId();
		MemberDTO memberDTO = memberDAO.selectMemberInformation(memberNo, memberID);
		return memberDTO;
	}

	/**
	 * �α׾ƿ�
	 */
	public void logout() {
		SessionSet ss = SessionSet.getInstance();
		for (Session s : ss.getSessionSet()) { // �迭
			ss.removeSession(s);
		}
	}

	/**
	 * ���ǿ��� �α��ε� ����ڹ�ȣ ��������
	 */
	private int getSessionNo() {
		Iterator<Session> iterator = set.iterator();
		Session session = null;
		if (iterator.hasNext()) {
			session = iterator.next();
		}

		return session.getSessionNo();
	}

	/**
	 * ���ǿ��� �α��ε� ����ھ��̵� ��������
	 */
	private String getSessionId() {

		Iterator<Session> iterator = set.iterator();
		Session session = null;
		if (iterator.hasNext()) {
			session = iterator.next();
		}

		return session.getSessionId();
	}
}