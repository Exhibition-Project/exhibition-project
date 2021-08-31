package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.MemberDTO;

public interface MemberDAO {
		
		/**
		 * �α���
		 */
		public MemberDTO login(String id, String password) throws SQLException;

		/**
		 * ȸ���ߺ���ȸ
		 */
		public int getMemberId(String id);
		
		/**
		 * ȸ������
		 */
		public int insertMembership(MemberDTO memberDTO) throws SQLException;


		/**
		 * ����������
		 */
		public int updateMember(int sessionNo, MemberDTO updatememDto) throws SQLException;
		
		/**
		 * ��������ȸ
		 */
		public MemberDTO selectMemberInformation(int memberNo, String memberID) throws SQLException;

		/**
		 * ���� ��й�ȣ üũ 
		 */
		public int checkPassword(int sessionNo, String confirmPassword) throws SQLException;
		
}
