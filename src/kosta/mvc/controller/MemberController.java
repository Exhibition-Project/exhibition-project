package kosta.mvc.controller;

import kosta.mvc.Service.MemberService;
import kosta.mvc.model.dto.MemberDTO;

public class MemberController {
	MemberService memberService = new MemberService();

	/**
	 * 로그인
	 */
	public MemberDTO login(String id, String password) {
		return null;
	}

	/**
	 * 회원가입
	 */
	public void InputInsertMember(String memberId,  String memberPassword, String memberName, String memberBirth) {
		
	}

	/**
	 * 로그아웃
	 */
	public void logout() {
		
	}

	/**
	 * 고객정보수정
	 */
	public void UpdateMember() {

	}

	/**
	 * 고객 예매내역 조회
	 */
	public void MemberSelectReservation() {

	}
}
