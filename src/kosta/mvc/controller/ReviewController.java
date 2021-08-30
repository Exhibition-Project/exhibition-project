package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.model.service.ReviewService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;


public class ReviewController {
	private static ReviewService reviewService = new ReviewService();
	
	
	/**
	 * 전시회 번호로 검색
	 * */
	public static void selectAllbyExhibitionNo(int exNo) {
		ExhibitionService exhibitionSevice = new ExhibitionService();
		try {
			List<ReviewDTO> redto = reviewService.selectAllbyExhibitionNo(exNo);
			ExhibitionDTO exdto = exhibitionSevice.selectByExhibitionxNo(exNo);
		EndView.printReAndEx(redto, exdto);
	   }catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
	 }
		
	}
	
	/**
	 * 사용자 번호로 검색 (내 후기 보기)
	 * */
	public static void reviewSelectByReviewNo() {
		try {
			List<ReviewDTO> list = reviewService.selectByMemberNo();
			if(list.isEmpty()) {
				throw new SQLException("\n등록된 후기가 없습니다.");
			}
			EndView.printReviewList(list);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}	
	}
	
	/**
	 * 후기 번호로 검색
	 * */
	public static void selectByReviewNo(int reviewNo) {
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
	public static void reviewInsert(ReviewDTO dto) {
		try{
			reviewService.reviewInsert(dto);
			EndView.printMessage("\n후기 등록에 성공하였습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 후기 수정
	 * */
	public static void reviewUpdate(ReviewDTO dto) {
		try {
			reviewService.reviewUpdate(dto);
			EndView.printMessage("\n후기가 수정되었습니다.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 삭제
	 * */
	public static void reviewDelete(int reviewNo) {
		try {
			reviewService.reviewDelete(reviewNo);
			EndView.printMessage("\n후기가 삭제되었습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
