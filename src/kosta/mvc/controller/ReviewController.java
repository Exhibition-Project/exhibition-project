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
	 * ����ȸ ��ȣ�� �˻�
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
	 * ����� ��ȣ�� �˻� (�� �ı� ����)
	 * */
	public static void reviewSelectByReviewNo() {
		try {
			List<ReviewDTO> list = reviewService.selectByMemberNo();
			if(list.isEmpty()) {
				throw new SQLException("\n��ϵ� �ıⰡ �����ϴ�.");
			}
			EndView.printReviewList(list);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}	
	}
	
	/**
	 * �ı� ��ȣ�� �˻�
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
	 * �ı� ���
	 * */
	public static void reviewInsert(ReviewDTO dto) {
		try{
			reviewService.reviewInsert(dto);
			EndView.printMessage("\n�ı� ��Ͽ� �����Ͽ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �ı� ����
	 * */
	public static void reviewUpdate(ReviewDTO dto) {
		try {
			reviewService.reviewUpdate(dto);
			EndView.printMessage("\n�ıⰡ �����Ǿ����ϴ�.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * ����
	 * */
	public static void reviewDelete(int reviewNo) {
		try {
			reviewService.reviewDelete(reviewNo);
			EndView.printMessage("\n�ıⰡ �����Ǿ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
