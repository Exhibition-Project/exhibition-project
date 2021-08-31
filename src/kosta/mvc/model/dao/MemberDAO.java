package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.MemberDTO;

public interface MemberDAO {
		
		/**
		 * 로그인
		 */
		public MemberDTO login(String id, String password) throws SQLException;

		/**
		 * 회원중복조회
		 */
		public int getMemberId(String id);
		
		/**
		 * 회원가입
		 */
		public int insertMembership(MemberDTO memberDTO) throws SQLException;


		/**
		 * 고객정보수정
		 */
		public int updateMember(int sessionNo, MemberDTO updatememDto) throws SQLException;
		
		/**
		 * 고객정보조회
		 */
		public MemberDTO selectMemberInformation(int memberNo, String memberID) throws SQLException;

		/**
		 * 기존 비밀번호 체크 
		 */
		public int checkPassword(int sessionNo, String confirmPassword) throws SQLException;
		
}
