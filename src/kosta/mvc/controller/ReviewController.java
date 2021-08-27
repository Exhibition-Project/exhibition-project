package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.Service.ReviewService;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;


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
		try{
			reviewService.reviewInsert(dto);
			EndView.printMessage("후기 등록에 성공하였습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 후기 수정
	 * */
	public void reviewUpdate(ReviewDTO dto) {
		try {
			reviewService.reviewUpdate(dto);
			EndView.printMessage("후기가 수정되었습니다.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 삭제
	 * */
	public void reviewDelete(int reviewNo) {
		
	}

}
