package kosta.mvc.model.dao;

import kosta.mvc.model.dto.MemberDTO;

public interface MemberDAO {
		
		/**
		 * �α���
		 */
		public MemberDTO login(String id, String password);

		/**
		 * ȸ���ߺ���ȸ
		 */
		public int getMemberId(String id);
		
		/**
		 * ȸ������
		 */
		public int insertMembership(MemberDTO memberDTO);


		/**
		 * ����������
		 */
		public int updateMember(MemberDTO memberDTO, MemberDTO updatememDto);
		
		/**
		 * ��������ȸ
		 */
		public MemberDTO selectMemberInformation(int memberNo, String memberID);
		
}
