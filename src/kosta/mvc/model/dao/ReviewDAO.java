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
	 * 후기 보기 : 전시회 번호로 조희
	 * */
	List<ReviewDTO> selectAllbyExhibitionNo(int exibitionNo) throws SQLException;
	
	/**
	 * 내 후기 보기
	 * 1) 현재 로그인 한 사용자 번호 가져옴
	 * 2) 후기 검색
	 * */
	List<ReviewDTO> selectByMemberNo (int memberNo) throws SQLException;  
	
	/**
	 * 후기 번호에 해당하는 후기 수정
	 * */
	int ReviewUpdate(ReviewDTO dto) throws SQLException;
	
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
