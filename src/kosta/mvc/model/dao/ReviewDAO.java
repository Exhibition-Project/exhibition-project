package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * 후기 등록하기
	 * 1) 사용자가 직접 입력한 후기 가져옴
	 * 2) Review 테이블에 insert
	 *
	 * */
	int reviewInsert(ReviewDTO review) throws SQLException;
	
	
	/**
	 * 후기 전체보기
	 * */
	List<ReviewDTO> selectByAllReviews() throws SQLException;
	
	/**
	 * 내 후기 보기
	 * 1) 현재 로그인 한 사용자 번호 가져옴
	 * 2) 후기 검색
	 * */
	List<ReviewDTO> selectByMemberNo (int memberNo) throws SQLException; 
	
	/**
	 * 내 후기 수정
	 * 1) 사용자 번호로 후기 검색 (후기가 여러개이면..?)
	 * 2) 내용 수정
	 * */
	
	/////////////////////////////////////////////
	
	/**
	 * 후기번호에 해당하는 후기 검색 (관리자용)
	 * */
	ReviewDTO selectByReviewNo(int reviewNo) throws SQLException;

	
	/**
	 * 후기 번호에 해당하는 후기 삭제 (관리자용)
	 * */
	int reviewDelete(int reviewNo) throws SQLException;
	
	
	
	

}
