package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.util.DBUtil;

public class ExhibitionDAOImpl implements ExhibitionDAO {

	//전체 검색
//	@Override
//	public List<ExhibitionDTO> exhibitionSelectAll() throws SQLException{
//		Connection con=null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<ExhibitionDTO> exhibitionList = new ArrayList<>();
//		try {
//			con = DBUtil.getConnection();
//			ps = con.preparedStatement("select * from exhibition reserve");
//			rs = ps.executeQuery();
//			
//			 while(rs.next()) {
//				 ExhibitionDTO exhibitionDTO = new ExhibitionDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//				 list.add(exhibitionDTO);
//			 }
//		}finally {
//			DBUtil.dbClose(con, ps, rs);
//		}
//		return list;
//	}

	//날짜별 검색
//	@Override
//	public List<ExhibitionDTO> exhibitionSelectByDate(String startDate, String endDate) throws SQLException{
//		Connection con=null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		ExhibitionDTO exhitionDTO = null;
//		try {
//			con = DbUtil.getConnection();
//			ps= con.prepareStatement("select * from exhibition");
//			ps.setString(1, userId);
//		    rs = ps.executeQuery();
//		    
//		    if(rs.next()) {
//		    	exhibitionDTO = new exhibitionDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
//		    } finally {
//		    	DBUtil.dbClose(con, ps, rs);
//		    }
//		}
//		return exhibitonDTO;
//	}

	//전시회 등록
//	@Override
//	public int exhibitionInsert(ExhibitionDTO dto) throws SQLException{
//		Connection con=null;
//		PreparedStatement ps = null;
		
//		int result = cs.executeInsert();
/*		String sql = proFile.getProperty("exhibition.insert");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, getexhibitionNo());
			ps.setString(2, getexhibitionName());
			ps.setString(3, getstartDate());
			ps.setString(4, getendDate());
			ps.setString(5, getGenre());
			ps.setString(6, getPrice());
			ps.setString(7, getExhibitionLocation());
			
			result = ps.executeInsert();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	//전시회 수정
	@Override
	public int exhibitionUpdate(ExhibitionDTO dto) throws SQLException{
//		
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = cs.executeUpdate();
		String sql = profile.getProperty("exhibition.update");
		
		try {
				con = DBUtil.getConnection();
				ps = con.preparedStatement(sql);
				
				ps.setInt(1, dto.getExhibitionNo());
				result = ps.executeUpdate();
		}finally {
				DBUtil.dbClose(con, ps);
		}
		return result;
	}

	//전시회 삭제
	@Override
	public int exhibitionDelete(int exhibitionNo) throws SQLException{
//		Connection con = null;
		PreparedStatement ps = null;
		
		int result = cs.executeDelete();
		String sql = proFile.getProperty("exhibition.delete");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, exhibitionNo);
			
			result = ps.executeDelete();
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
		String sql = "select exhibition_no, exhibition_name, start_date, end_date, genre, price, exhibition_loc from exhibition where exhibition_no = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, exhibitionNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				exhibitionDTO = new ExhibitionDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(6));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(con, ps, rs);
			}
		return exhibitionDTO;
	}

	@Override
	public List<ExhibitionDTO> exhibitionSelectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExhibitionDTO> exhibitionSelectByDate(String startDate, String endDate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int exhibitionInsert(ExhibitionDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int exhibitionUpdate(ExhibitionDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int exhibitionDelete(int exhibitionNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}