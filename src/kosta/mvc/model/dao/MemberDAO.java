package kosta.mvc.model.dao;

public interface MemberDAO {
		
		/**
		 * �α���
		 */
		public void login(String id, String password);

		/**
		 * ȸ������
		 */
		public void InputInsertMember();

		/**
		 * �α׾ƿ�
		 */
		public void logout();

		/**
		 * ����������
		 */
		public void UpdateMember();

		/**
		 * �� ���ų��� ��ȸ
		 */
		public void MemberReservation();
		
}
