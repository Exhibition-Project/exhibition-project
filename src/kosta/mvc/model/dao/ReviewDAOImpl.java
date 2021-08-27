package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.util.DBUtil;


public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DBUtil.getProFile();

	@Override
	public int reviewInsert(ReviewDTO review) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = proFile.getProperty("review.insert");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?에 대한 set 함수
			ps.setInt(1, review.getMemberNo());
			ps.setInt(2, review.getExhibitionNo());
			ps.setString(3, review.getReviewContnet());
			ps.setInt(4, review.getStars());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
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
		
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = proFile.getProperty("review.update");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getReviewContnet());
			ps.setInt(2, dto.getReviewNo());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

}
