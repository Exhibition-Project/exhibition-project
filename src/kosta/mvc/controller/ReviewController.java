package kosta.mvc.controller;

import kosta.mvc.Service.ReviewService;
import kosta.mvc.model.dto.ReviewDTO;

public class ReviewController {
	private ReviewService reviewService = new ReviewService();
	
	
	/**
	 * 전체검색
	 * */
	public void reviewSelectAll() {
		
	}
	
	/**
	 * 사용자 번호로 조회 (내 후기 보기)
	 * */
	public void reviewSelectByReviewNo(int memberNo) {
		
	}
	
	/**
	 * 후기 등록
	 * */
	public void reviewInsert(ReviewDTO dto) {
		
	}
	
	/**
	 * 후기 수정
	 * */
	public void reviewUpdate(ReviewDTO dto) {
		
	}
	
	/**
	 * 삭제
	 * */
	public void reviewDelete(int reviewNo) {
		
	}

}
