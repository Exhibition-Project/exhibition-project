package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.Service.ExhibitionService;
import kosta.mvc.Service.ReviewService;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;


public class ReviewController {
	private ReviewService reviewService = new ReviewService();
	
	
//	/**
//	 * 전시회 번호로 검색
//	 * */
//	public void selectAllbyExhibitionNo() {
//		ExhibitionService exhibitionSevice = new ExhibitionService();
//		try {
//			List<ReviewDTO> redto = reviewService.selectAllbyExhibitionNo();
//			List<ExhibitionDTO> exdto = exhibitionSevice.exihibitionSelectByNo();
//			EndView.printReAndEx(redto, exdto);
//		}catch(SQLException e) {
//			FailView.errorMessage(e.getMessage());
//		}
//		
//	}
	
	/**
	 * 사용자 번호로 검색 (내 후기 보기)
	 * */
	public void reviewSelectByReviewNo(int memberNo) {
		try {
			List<ReviewDTO> list = reviewService.selectByMemberNo(memberNo);
			EndView.printReviewList(list);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 후기 번호로 검색
	 * */
	public void selectByReviewNo(int reviewNo) {
		try {
			ReviewDTO dto = reviewService.selectByReviewNo(reviewNo);
			EndView.printReviewByNo(dto);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
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
		try {
			reviewService.reviewDelete(reviewNo);
			EndView.printMessage("후기가 삭제");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
