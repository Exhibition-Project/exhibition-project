package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * �ı� ����ϱ�
	 * 1) ����ڰ� ���� �Է��� �ı� ������
	 * 2) Review ���̺� insert
	 *
	 * */
	int reviewInsert(ReviewDTO review) throws SQLException;
	
	
	/**
	 * �ı� ���� : ����ȸ ��ȣ�� ����
	 * */
	List<ReviewDTO> selectAllbyExhibitionNo(int exibitionNo) throws SQLException;
	
	/**
	 * �� �ı� ����
	 * 1) ���� �α��� �� ����� ��ȣ ������
	 * 2) �ı� �˻�
	 * */
	List<ReviewDTO> selectByMemberNo (int memberNo) throws SQLException;  
	
	/**
	 * �ı� ��ȣ�� �ش��ϴ� �ı� ����
	 * */
	int ReviewUpdate(ReviewDTO dto) throws SQLException;
	
	/////////////////////////////////////////////
	
	/**
	 * �ı��ȣ�� �ش��ϴ� �ı� �˻� (�����ڿ�)
	 * */
	ReviewDTO selectByReviewNo(int reviewNo) throws SQLException;

	
	/**
	 * �ı� ��ȣ�� �ش��ϴ� �ı� ���� (�����ڿ�)
	 * */
	int reviewDelete(int reviewNo) throws SQLException;
	
	
	
	

}
