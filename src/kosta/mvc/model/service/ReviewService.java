package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.ReviewDTO;

public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	
	/**
	 * 전시회 번호로 조회
	 * */
	public List<ReviewDTO> selectAllbyExhibitionNo(int exNo) throws SQLException{
		List<ReviewDTO> reviewDTO = reviewDAO.selectAllbyExhibitionNo(exNo);
		if(reviewDTO == null || reviewDTO.isEmpty()) {
			throw new SQLException("전시회 번호" + exNo + "에 등록된 후기가 없습니다.");
		}
		
		return reviewDTO;
	}
	
	/**
	 * 사용자 번호로 조회 (내 후기 보기)
	 * */
	public List<ReviewDTO> selectByMemberNo(int memberNo)throws SQLException{
		List<ReviewDTO> dto = reviewDAO.selectByMemberNo(memberNo);
		if(dto == null) {
			throw new SQLException("등록된 후기가 없습니다.");
		}
	
		return dto;
	}
	
	/**
	 * 후기 번호로 조회
	 * */
	public ReviewDTO selectByReviewNo(int reviewNo) throws SQLException {
		ReviewDTO dto = reviewDAO.selectByReviewNo(reviewNo);
		if(dto == null) {
			throw new SQLException(reviewNo + " 번에 해당하는 게시물이 없습니다.");
		}
		
		return dto;
	}
	
	
	
	
	/**
	 * 등록
	 * */
	public void reviewInsert(ReviewDTO dto) throws SQLException{
		int result = reviewDAO.reviewInsert(dto);
		if(result == 0)throw new SQLException("후기를 등록할 수 없습니다.");
		
	}
	
	/**
	 * 수정
	 * */
	public void reviewUpdate(ReviewDTO dto) throws SQLException{
		int result = reviewDAO.ReviewUpdate(dto);
		if(result == 0)throw new SQLException("후기를 수정할 수 없습니다.");
	}
	
	/**
	 * 삭제
	 * */
	public void reviewDelete(int reviewNo) throws SQLException {
		int result = reviewDAO.reviewDelete(reviewNo);
		if(result == 0) throw new SQLException("후기 삭제에 실패했습니다.");
	}

}
