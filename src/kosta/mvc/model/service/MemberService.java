package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.dao.MemberDAOImpl;
import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;
/**
 * @author �ڼ���
 */
public class MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();

	SessionSet sessionSet = SessionSet.getInstance(); // �α��ο����� ���� privateó��
	Set<Session> set = sessionSet.getSessionSet();

	/**
	 * �α���
	 * @param id
	 * @param password
	 * @return �ش� MemberDTO�� �����´�
	 * @throws Exception
	 */
	public MemberDTO login(String id, String password) throws Exception {

		MemberDTO memberDTO = memberDAO.login(id, password);
		if (memberDTO == null) {
			throw new Exception("\nID�� ��й�ȣ�� �´� ȸ���� �����ϴ�.");
		}

		Session session = new Session(memberDTO.getMemberNo(), memberDTO.getMemberId());

		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.addSession(session);
		return memberDTO;
	}

	/**
	 * ȸ�� �ߺ���ȸ
	 * @param id
	 * @return �ߺ��� ȸ���ִ��� Ȯ���ϴ� �޼ҵ�
	 */
	public int getMemberId(String id) {
		return memberDAO.getMemberId(id);
	}

	/**
	 * ȸ������
	 * @param memberDTO
	 * @return MemberDTO�� ȸ�� ���ڵ� �߰�
	 * @throws SQLException
	 */
	public int insertMembership(MemberDTO memberDTO) throws SQLException{
		return memberDAO.insertMembership(memberDTO);
	}

	/**
	 * ������й�ȣ�� ��ġ�ϴ��� üũ
	 * @param confirmPassword
	 * @return ��й�ȣ ��ġ���� Ȯ���ϴ� �޼ҵ�
	 * @throws SQLException
	 */
	public int checkPassword(String confirmPassword) throws SQLException{

		int result = memberDAO.checkPassword(getSessionNo(), confirmPassword);
		return result;
	}

	/**
	 * ȸ������ ����
	 * @param confirmPassword
	 * @param updateMemberDTO
	 * @return ������ ȸ���� MemberDTO
	 * @throws SQLException
	 */
	public int updateMember(String confirmPassword, MemberDTO updateMemberDTO) throws SQLException{

		int memberNo = getSessionNo();
		return memberDAO.updateMember(memberNo, updateMemberDTO);
	}

	/**
	 * �α����� ȸ�� ���� ��ȸ
	 * @return ȸ�� ����
	 * @throws SQLException
	 */
	public MemberDTO memberSelectReservation() throws SQLException{

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
	public int getSessionNo() {
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
	public String getSessionId() {

		Iterator<Session> iterator = set.iterator();
		Session session = null;
		if (iterator.hasNext()) {
			session = iterator.next();
		}

		return session.getSessionId();
	}
}