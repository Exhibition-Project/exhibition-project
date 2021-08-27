package kosta.mvc.model.dao;

public interface MemberDAO {
		
		/**
		 * 로그인
		 */
		public void login(String id, String password);

		/**
		 * 회원가입
		 */
		public void InputInsertMember();

		/**
		 * 로그아웃
		 */
		public void logout();

		/**
		 * 고객정보수정
		 */
		public void UpdateMember();

		/**
		 * 고객 예매내역 조회
		 */
		public void MemberReservation();
		
}
