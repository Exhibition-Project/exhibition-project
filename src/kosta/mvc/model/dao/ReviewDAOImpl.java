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
/**
 * @author 현지윤
 */
public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DBUtil.getProFile();

	/**
	 * 후기 등록
	 */
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


	/**
	 * 후기 삭제(회원)
	 */
	@Override
	public int reviewDelete(int memberNo, int reviewNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = proFile.getProperty("review.delete");

		try {
			con = DBUtil.getConnection();
			if(!isMyReview(con, memberNo, reviewNo)) {
				throw new SQLException("삭제할 수 없는 후기입니다.");
			}
			ps = con.prepareStatement(sql);

			ps.setInt(1, reviewNo);

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 후기 삭제(관리자)
	 */
	@Override
	public int reviewDeleteAdmin(int reviewNo) throws SQLException {
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

	/**
	 * 후기 수정(회원)
	 */
	@Override
	public int ReviewUpdate(ReviewDTO dto) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = proFile.getProperty("review.update");

		try {
			con = DBUtil.getConnection();
			if(!isMyReview(con, dto.getMemberNo(), dto.getReviewNo())) {
				throw new SQLException("수정할 수 없는 후기입니다.");
			}
			
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getReviewContnet());
			ps.setInt(2, dto.getReviewNo());

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 내후기보기
	 */
	@Override
	public List<ReviewDTO> selectByMemberNo(int memberNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();

		String sql = proFile.getProperty("review.selectByReviewNo");
		//SELECT R.REVIEW_NO, R.EXHIBITION_NO, E.EXHIBITION_NAME, R.REVIEW_CONTENT, R.STARS FROM REVIEW R, EXHIBITION E 
		//WHERE R.MEMBER_NO = ? AND R.EXHIBITION_NO = E.EXHIBITION_NO
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, memberNo);

			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				reviewList.add(reviewDTO);
			}

		}finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return reviewList;
	}

	/**
	 * 후기 번호로 검색 (수정, 삭제를 위한)
	 */
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

	/**
	 * 전시회 번호로 후기 조회
	 */
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
	
	/**
	 * 
	 * @param con
	 * @param memberNo
	 * @param reviewNo
	 * @return 자신이 작성한 후기면 true 아니면 false
	 * @throws SQLException
	 */
	private boolean isMyReview(Connection con, int memberNo, int reviewNo) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = proFile.getProperty("review.selectMemberNoByReviewNo");
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = memberNo == rs.getInt(1) ? true : false;
			}
		}finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return result;
	}

}