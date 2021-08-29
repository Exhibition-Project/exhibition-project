package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.ReviewDTO;

public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	
	/**
	 * ����ȸ ��ȣ�� ��ȸ
	 * */
	public List<ReviewDTO> selectAllbyExhibitionNo(int exNo) throws SQLException{
		List<ReviewDTO> reviewDTO = reviewDAO.selectAllbyExhibitionNo(exNo);
		if(reviewDTO == null || reviewDTO.isEmpty()) {
			throw new SQLException("����ȸ ��ȣ" + exNo + "�� ��ϵ� �ıⰡ �����ϴ�.");
		}
		
		return reviewDTO;
	}
	
	/**
	 * ����� ��ȣ�� ��ȸ (�� �ı� ����)
	 * */
	public List<ReviewDTO> selectByMemberNo(int memberNo)throws SQLException{
		List<ReviewDTO> dto = reviewDAO.selectByMemberNo(memberNo);
		if(dto == null) {
			throw new SQLException("��ϵ� �ıⰡ �����ϴ�.");
		}
	
		return dto;
	}
	
	/**
	 * �ı� ��ȣ�� ��ȸ
	 * */
	public ReviewDTO selectByReviewNo(int reviewNo) throws SQLException {
		ReviewDTO dto = reviewDAO.selectByReviewNo(reviewNo);
		if(dto == null) {
			throw new SQLException(reviewNo + " ���� �ش��ϴ� �Խù��� �����ϴ�.");
		}
		
		return dto;
	}
	
	
	
	
	/**
	 * ���
	 * */
	public void reviewInsert(ReviewDTO dto) throws SQLException{
		int result = reviewDAO.reviewInsert(dto);
		if(result == 0)throw new SQLException("�ı⸦ ����� �� �����ϴ�.");
		
	}
	
	/**
	 * ����
	 * */
	public void reviewUpdate(ReviewDTO dto) throws SQLException{
		int result = reviewDAO.ReviewUpdate(dto);
		if(result == 0)throw new SQLException("�ı⸦ ������ �� �����ϴ�.");
	}
	
	/**
	 * ����
	 * */
	public void reviewDelete(int reviewNo) throws SQLException {
		int result = reviewDAO.reviewDelete(reviewNo);
		if(result == 0) throw new SQLException("�ı� ������ �����߽��ϴ�.");
	}

}
