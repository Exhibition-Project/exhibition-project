package kosta.mvc.controller;

import kosta.mvc.Service.MemberService;
import kosta.mvc.model.dto.MemberDTO;

public class MemberController {
	MemberService memberService = new MemberService();

	/**
	 * �α���
	 */
	public MemberDTO login(String id, String password) {
		return null;
	}

	/**
	 * ȸ������
	 */
	public void InputInsertMember(String memberId,  String memberPassword, String memberName, String memberBirth) {
		
	}

	/**
	 * �α׾ƿ�
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
