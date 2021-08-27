package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.util.DBUtil;


public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DBUtil.getProFile();

	@Override
	public int reviewInsert(ReviewDTO review) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDTO> selectByAllReviews() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int reviewDelete(int reviewNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDTO> selectByMemberNo(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewDTO selectByReviewNo(int reviewNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ReviewUpdate(ReviewDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
