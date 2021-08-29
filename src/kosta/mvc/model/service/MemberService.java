package kosta.mvc.model.service;

import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.dao.MemberDAOImpl;

public class MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();
	
	/**
	 * id, password 받아서 맞는 MemberDTO를 가져온다.
	 */
	public void login(String id, String password) {
		
	}
	
	/**
	 * 회원가입
	 */
	public void InsertMembership(String memberId,  String memberPassword, String memberName, String memberBirth) {
		
	}

	/**
	 * 로그아웃  ?
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
