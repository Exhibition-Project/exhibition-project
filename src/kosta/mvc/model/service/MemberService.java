package kosta.mvc.model.service;

import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.dao.MemberDAOImpl;

public class MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();
	
	/**
	 * id, password �޾Ƽ� �´� MemberDTO�� �����´�.
	 */
	public void login(String id, String password) {
		
	}
	
	/**
	 * ȸ������
	 */
	public void InsertMembership(String memberId,  String memberPassword, String memberName, String memberBirth) {
		
	}

	/**
	 * �α׾ƿ�  ?
	 */
	public void logout() {
		
	}

	/**
	 * ����������
	 */
	public void UpdateMember() {

	}

	/**
	 * �� ���ų��� ��ȸ
	 */
	public void MemberSelectReservation() {

	}
	
	

}
