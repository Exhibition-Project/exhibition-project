package kosta.mvc.Service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.ReviewDTO;

public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	
	/**
	 * 전체 검색
	 * */
	public List<ReviewDTO> reviewSelectAll() throws SQLException{
		
		return null;
	}
	
	/**
	 * 사용자 번호로 조회 (내 후기 보기)
	 * */
	public List<ReviewDTO> reviewSelectByMemberNo(int memberNo)throws SQLException{
		return null;
	
	}
	
	/**
	 * 등록
	 * */
	public void reviewInsert(ReviewDTO dto) throws SQLException{
		
	}
	
	/**
	 * 삭제
	 * */
	public void reviewDelete(int reviewNo) throws SQLException {
		
	}

}
