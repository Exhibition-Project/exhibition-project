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
 * @author 박성하
 */
public class MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();

	SessionSet sessionSet = SessionSet.getInstance(); // 로그인에서만 쓰면 private처리
	Set<Session> set = sessionSet.getSessionSet();

	/**
	 * 로그인
	 * @param id
	 * @param password
	 * @return 해당 MemberDTO를 가져온다
	 * @throws Exception
	 */
	public MemberDTO login(String id, String password) throws Exception {

		MemberDTO memberDTO = memberDAO.login(id, password);
		if (memberDTO == null) {
			throw new Exception("\nID와 비밀번호에 맞는 회원이 없습니다.");
		}

		Session session = new Session(memberDTO.getMemberNo(), memberDTO.getMemberId());

		SessionSet sessionSet = SessionSet.getInstance();
		sessionSet.addSession(session);
		return memberDTO;
	}

	/**
	 * 회원 중복조회
	 * @param id
	 * @return 중복된 회원있는지 확인하는 메소드
	 */
	public int getMemberId(String id) {
		return memberDAO.getMemberId(id);
	}

	/**
	 * 회원가입
	 * @param memberDTO
	 * @return MemberDTO에 회원 레코드 추가
	 * @throws SQLException
	 */
	public int insertMembership(MemberDTO memberDTO) throws SQLException{
		return memberDAO.insertMembership(memberDTO);
	}

	/**
	 * 기존비밀번호와 일치하는지 체크
	 * @param confirmPassword
	 * @return 비밀번호 일치여부 확인하는 메소드
	 * @throws SQLException
	 */
	public int checkPassword(String confirmPassword) throws SQLException{

		int result = memberDAO.checkPassword(getSessionNo(), confirmPassword);
		return result;
	}

	/**
	 * 회원정보 수정
	 * @param confirmPassword
	 * @param updateMemberDTO
	 * @return 수정된 회원의 MemberDTO
	 * @throws SQLException
	 */
	public int updateMember(String confirmPassword, MemberDTO updateMemberDTO) throws SQLException{

		int memberNo = getSessionNo();
		return memberDAO.updateMember(memberNo, updateMemberDTO);
	}

	/**
	 * 로그인한 회원 정보 조회
	 * @return 회원 정보
	 * @throws SQLException
	 */
	public MemberDTO memberSelectReservation() throws SQLException{

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
	public int getSessionNo() {
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
	public String getSessionId() {

		Iterator<Session> iterator = set.iterator();
		Session session = null;
		if (iterator.hasNext()) {
			session = iterator.next();
		}

		return session.getSessionId();
	}
}