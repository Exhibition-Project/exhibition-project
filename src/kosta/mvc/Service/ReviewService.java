package kosta.mvc.Service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.ReviewDTO;

public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	
	/**
	 * ��ü �˻�
	 * */
	public List<ReviewDTO> reviewSelectAll() throws SQLException{
		
		return null;
	}
	
	/**
	 * ����� ��ȣ�� ��ȸ (�� �ı� ����)
	 * */
	public List<ReviewDTO> reviewSelectByMemberNo(int memberNo)throws SQLException{
		return null;
	
	}
	
	/**
	 * ���
	 * */
	public void reviewInsert(ReviewDTO dto) throws SQLException{
		
	}
	
	/**
	 * ����
	 * */
	public void reviewDelete(int reviewNo) throws SQLException {
		
	}

}
