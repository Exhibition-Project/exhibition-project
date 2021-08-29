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
//	 * ����ȸ ��ȣ�� �˻�
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
	 * ����� ��ȣ�� �˻� (�� �ı� ����)
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
	 * �ı� ��ȣ�� �˻�
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
	 * �ı� ���
	 * */
	public void reviewInsert(ReviewDTO dto) {
		try{
			reviewService.reviewInsert(dto);
			EndView.printMessage("�ı� ��Ͽ� �����Ͽ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �ı� ����
	 * */
	public void reviewUpdate(ReviewDTO dto) {
		try {
			reviewService.reviewUpdate(dto);
			EndView.printMessage("�ıⰡ �����Ǿ����ϴ�.");
		} catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * ����
	 * */
	public void reviewDelete(int reviewNo) {
		try {
			reviewService.reviewDelete(reviewNo);
			EndView.printMessage("�ıⰡ ����");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
