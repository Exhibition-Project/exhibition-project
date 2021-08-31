package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.util.DBUtil;
/**
 * @author 김연식
 */
public class ExhibitionDAOImpl implements ExhibitionDAO {
	Properties proFile = DBUtil.getProFile();

	/**
	 * 전시회 전체 검색
	 */
	@Override
	public List<ExhibitionDTO> exhibitionSelectAll() throws SQLException{
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ExhibitionDTO> exhibitionList = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("exhibition.selectAll"));
			rs = ps.executeQuery();
			
			 while(rs.next()) {
				 ExhibitionDTO exhibitionDTO = new ExhibitionDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						 rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				 exhibitionList.add(exhibitionDTO);
			 }
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return exhibitionList;
	}

	/**
	 * 전시회 날짜별 검색
	 */
	@Override
	public List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException{
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ExhibitionDTO exhitionDTO = null;
		List<ExhibitionDTO> exhibitionList = new ArrayList<ExhibitionDTO>();
		try {
			con = DBUtil.getConnection();
			ps= con.prepareStatement(proFile.getProperty("exhibition.selectByDate"));
			ps.setString(1, date);
		    rs = ps.executeQuery();		    
		    while(rs.next()) {
		    	ExhibitionDTO exhibitionDTO = new ExhibitionDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						 rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				exhibitionList.add(exhibitionDTO);
		    }
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return exhibitionList;
	}

	/**
	 * 전시회 별점순으로 검색
	 */
	@Override
	public List<ExhibitionDTO> exhibitionSelectByStars() throws SQLException{
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ExhibitionDTO> exhibitionList = new ArrayList<ExhibitionDTO>();
		String sql = proFile.getProperty("exhibition.selectByStars");
		try {
			con = DBUtil.getConnection();
			ps= con.prepareStatement(sql);
		    rs = ps.executeQuery();		    
		    while(rs.next()) {
		    	ExhibitionDTO exhibitionDTO = new ExhibitionDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						 rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
		    	exhibitionDTO.setAvgStars(rs.getDouble(8));
				exhibitionList.add(exhibitionDTO);
		    }
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return exhibitionList;
	}
	
	/**
	 * 전시회 등록
	 */
	@Override
	public int exhibitionInsert(ExhibitionDTO dto) throws SQLException{
		Connection con=null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = proFile.getProperty("exhibition.insert");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getExhibitionName());
			ps.setString(2, dto.getStartDate());
			ps.setString(3, dto.getEndDate());
			ps.setString(4, dto.getGenre());
			ps.setInt(5, dto.getPrice());
			ps.setString(6, dto.getExhibitionLocation());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 전시회 수정
	 */
	@Override
	public int exhibitionUpdate(ExhibitionDTO dto) throws SQLException{
	
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("exhibition.update");
		/*name = ?, genre = ?, price = ?, exhibition_loc = ? where exhibition_no = ?*/
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getExhibitionName());
			ps.setString(2, dto.getGenre());
			ps.setInt(3, dto.getPrice());
			ps.setString(4, dto.getExhibitionLocation());
			ps.setInt(5, dto.getExhibitioNo());
			result = ps.executeUpdate();
			System.out.println(result);

		}finally {
				DBUtil.dbClose(con, ps);
		}

		return result;
	}

	/**
	 * 전시회 삭제
	 */
	@Override
	public int exhibitionDelete(int exhibitionNo) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("exhibition.delete");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, exhibitionNo);
			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	/**
	 * 전시회번호에 해당하는 검색
	 **/
	@Override
	public ExhibitionDTO exhibitionSelectByNo(int exhibitionNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ExhibitionDTO exhibitionDTO = null;
		String sql = proFile.getProperty("exhibition.selectByNo");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, exhibitionNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				exhibitionDTO = new ExhibitionDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(con, ps, rs);
			}
		return exhibitionDTO;
	}

}