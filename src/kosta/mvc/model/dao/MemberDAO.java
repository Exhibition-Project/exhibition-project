package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.MemberDTO;
/**
 * @author 박성하
 */
public interface MemberDAO {

	/**
	 * 로그인
	 * @param id
	 * @param password
	 * @return 회원 로그인
	 * @throws SQLException
	 */
	public MemberDTO login(String id, String password) throws SQLException;

	/**
	 * 회원 중복조회
	 * @param id
	 * @return 회원 중복체크
	 */
	public int getMemberId(String id);

	/**
	 * 회원가입
	 * @param memberDTO
	 * @return 회원가입
	 * @throws SQLException
	 */
	public int insertMembership(MemberDTO memberDTO) throws SQLException;

	/**
	 * 회원정보 수정
	 * @param sessionNo
	 * @param updatememDto
	 * @return 수정된 회원정보 레코드
	 * @throws SQLException
	 */
	public int updateMember(int sessionNo, MemberDTO updatememDto) throws SQLException;

	/**
	 * 회원정보 조회
	 * @param memberNo
	 * @param memberID
	 * @return 회원정보 조회
	 * @throws SQLException
	 */
	public MemberDTO selectMemberInformation(int memberNo, String memberID) throws SQLException;

	/**
	 * 기존 비밀번호 체크
	 * @param sessionNo
	 * @param confirmPassword
	 * @return
	 * @throws SQLException
	 */
	public int checkPassword(int sessionNo, String confirmPassword) throws SQLException;

}
