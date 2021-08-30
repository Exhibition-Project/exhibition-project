package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	/**
	 * 아이디에 맞는 MemberDTO 객체 반환
	 */
	@Override
	public MemberDTO login(String id, String password) {

		MemberDTO memberDTO = null;

		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement(
					"SELECT MEMBER_NO, MEMBER_ID, MEMBER_NAME, TO_CHAR(MEMBER_BIRTH, 'YYYYMMDD'), MEMBER_PASS FROM MEMBER"
							+ " WHERE MEMBER_ID = ? AND MEMBER_PASS = ?");
			st.setString(1, id);
			st.setString(2, password);

			rs = st.executeQuery();

			if (rs.next()) {
				memberDTO = new MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, st, rs);
		}
		return memberDTO;
	}

	/**
	 * 중복체크
	 */
	@Override
	public int getMemberId(String id) {
		int count = 0;
		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement("SELECT COUNT(1) FROM MEMBER WHERE MEMBER_ID = ?");
			st.setString(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, st, rs);
		}

		return count;
	}

	/**
	 * 회원추가
	 */
	@Override
	public int insertMembership(MemberDTO memberDTO) {
		int result = 0;
		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement("INSERT INTO MEMBER(MEMBER_NO, MEMBER_ID, MEMBER_NAME, MEMBER_BIRTH, MEMBER_PASS)"
					+ " VALUES(MEMBER_NO_SEQ.NEXTVAL, ?, ?, TO_DATE(?, 'YYYYMMDD'), ?)");
			st.setString(1, memberDTO.getMemberId());
			st.setString(2, memberDTO.getMemberName());
			st.setString(3, memberDTO.getMemberBirth());
			st.setString(4, memberDTO.getMemberPass());

			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, st);
		}

		return result;
	}

	/**
	 * 회원수정
	 */
	@Override
	public int updateMember(int sessionNo, MemberDTO updateMemberDTO) {

		int result = 0;
		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement(
					"UPDATE MEMBER SET MEMBER_NAME=?, MEMBER_BIRTH = TO_DATE(?,'YYYYMMDD'), MEMBER_PASS = ? "
							+ "WHERE MEMBER_NO=?");

			st.setString(1, updateMemberDTO.getMemberName());
			st.setString(2, updateMemberDTO.getMemberBirth());
			st.setString(3, updateMemberDTO.getMemberPass());
			st.setInt(4, sessionNo);

			result = st.executeUpdate();

		} catch (SQLException e) { // 여기서 에러남..
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, st);
		}

		return result;

	}

	/**
	 * 회원정보조회
	 */
	@Override
	public MemberDTO selectMemberInformation(int memberNo, String memberID) {
		MemberDTO memberDTO = null;

		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement("SELECT MEMBER_NO, MEMBER_ID, MEMBER_NAME, MEMBER_BIRTH, MEMBER_PASS FROM MEMBER"
					+ " WHERE MEMBER_NO=? AND MEMBER_ID=?");
			st.setInt(1, memberNo);
			st.setString(2, memberID);

			rs = st.executeQuery();

			if (rs.next()) {
				memberDTO = new MemberDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, st, rs);
		}

		return memberDTO;
	}

	/**
	 * 기존 비밀번호 확인
	 */
	@Override
	public int checkPassword(int memberNo, String confirmPassword) {
		int count = 0;
		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement("SELECT COUNT(1) FROM MEMBER WHERE MEMBER_NO = ? AND MEMBER_PASS = ?");
			st.setInt(1, memberNo);
			st.setString(2, confirmPassword);

			rs = st.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, st, rs);
		}
		return count;
	}

}
