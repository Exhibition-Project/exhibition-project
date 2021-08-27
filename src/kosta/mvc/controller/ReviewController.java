package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.Service.ReviewService;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;


public class ReviewController {
	private ReviewService reviewService = new ReviewService();
	
	
	/**
	 * ��ü�˻�
	 * */
	public void reviewSelectAll() {
		
	}
	
	/**
	 * ����� ��ȣ�� ��ȸ (�� �ı� ����)
	 * */
	public void reviewSelectByReviewNo(int memberNo) {
		
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
		
	}

}
