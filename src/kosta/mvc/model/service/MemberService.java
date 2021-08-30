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

	SessionSet sessionSet = SessionSet.getInstance(); // 로그인에서만 쓰면 private처리
	Set<Session> set = sessionSet.getSessionSet();

	/**
	 * id, password 받아서 맞는 MemberDTO를 가져온다.
	 */
	public MemberDTO login(String id, String password) throws Exception {

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

		int result = memberDAO.checkPassword(getSessionNo(), confirmPassword);
		return result;
	}

	/**
	 * 고객정보수정
	 */
	public int updateMember(String confirmPassword, MemberDTO updateMemberDTO) {

		int memberNo = getSessionNo();
		return memberDAO.updateMember(memberNo, updateMemberDTO);
	}

	/**
	 * 고객 로그인한 회원정보 조회
	 */
	public MemberDTO memberSelectReservation() {

		int memberNo = getSessionNo();
		String memberID = getSessionId();
		MemberDTO memberDTO = memberDAO.selectMemberInformation(memberNo, memberID);
		return memberDTO;
	}

	/**
	 * 로그아웃
	 */
	public void logout() {
		SessionSet ss = SessionSet.getInstance();
		for (Session s : ss.getSessionSet()) { // 배열
			ss.removeSession(s);
		}
	}

	/**
	 * 세션에서 로그인된 사용자번호 가져오기
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
	 * 세션에서 로그인된 사용자아이디 가져오기
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