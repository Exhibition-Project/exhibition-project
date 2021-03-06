package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReviewDTO;
/**
 * @author 현지윤
 */
public interface ReviewDAO {

	/**
	 * 후기 등록하기
	 * 1) 사용자가 직접 입력한 후기 가져옴
	 * 2) Review 테이블에 insert
	 * @param review
	 * @return insert 성공여부
	 * @throws SQLException
	 */
	int reviewInsert(ReviewDTO review) throws SQLException;
	
	
	/**
	 * 후기보기(전시회 번호로 조회)
	 * @param exibitionNo
	 * @return 후기 리스트
	 * @throws SQLException
	 */
	List<ReviewDTO> selectAllbyExhibitionNo(int exibitionNo) throws SQLException;
	
	/**
	 * 내 후기 보기
	 * 1) 현재 로그인 한 사용자 번호 가져옴
	 * 2) 후기 검색
	 * @param memberNo
	 * @return 후기 리스트
	 * @throws SQLException
	 * */
	List<ReviewDTO> selectByMemberNo (int memberNo) throws SQLException;  
	
	/**
	 * 후기 번호에 해당하는 후기 수정
	 * @param ReviewDTO
	 * @return update 성공여부
	 * @throws SQLException
	 * */
	int ReviewUpdate(ReviewDTO dto) throws SQLException;
	
	/////////////////////////////////////////////
	
	/**
	 * 후기번호에 해당하는 후기 검색 (관리자용)
	 * @param reviewNo
	 * @return 후기
	 * @throws SQLException
	 * */
	ReviewDTO selectByReviewNo(int reviewNo) throws SQLException;

	
	/**
	 * 후기 번호에 해당하는 후기 삭제 (회원용)
	 * @param memberNo
	 * @param reviewNo
	 * @return delete 성공여부
	 * @throws SQLException
	 * */
	int reviewDelete(int memberNo, int reviewNo) throws SQLException;
	
	/**
	 * 후기 번호에 해당하는 후기 삭제 (관리자용)
	 * @param reviewNo
	 * @return delete 성공여부
	 * @throws SQLException
	 * */
	int reviewDeleteAdmin(int reviewNo) throws SQLException;
	
	
	
	

}
