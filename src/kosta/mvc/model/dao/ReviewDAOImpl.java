package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.util.DBUtil;


public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DBUtil.getProFile();
	
	
	//등록
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


	//삭제
	@Override
	public int reviewDelete(int reviewNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = proFile.getProperty("review.delete");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, reviewNo);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	//수정
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

	
	//내후기보기
	@Override
	public List<ReviewDTO> selectByMemberNo(int memberNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		String sql = proFile.getProperty("review.selectAllbyMemberNo");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, memberNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO(rs.getInt(1), memberNo, rs.getInt(2), rs.getString(3), rs.getInt(4));
				reviewList.add(reviewDTO);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return reviewList;
	}
	
	
	//후기 번호로 검색 (수정, 삭제를 위한)
	@Override
	public ReviewDTO selectByReviewNo(int reviewNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReviewDTO dto = null;
		String sql = proFile.getProperty("review.selectByReviewNo");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, reviewNo);
			while(rs.next()) {
				dto = new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return dto;
	}

	
	//전시회 번호로 후기 조회
	@Override
	public List<ReviewDTO> selectAllbyExhibitionNo(int exibitionNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		String sql = proFile.getProperty("review.selectAllbyExhibitionNo");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, exibitionNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				reviewList.add(reviewDTO);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return reviewList;
	}

}