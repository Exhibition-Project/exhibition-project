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

	@Override
	public List<ExhibitionDTO> exhibitionSelectAll() throws SQLException{
//		Connection con=null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
		List<ExhibitionDTO> list = new ArrayList<>();
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
		return null;
	}

	@Override
	public List<ExhibitionDTO> exhibitionSelectByDate(String startDate, String endDate) throws SQLException{
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
		return null;
	}

	@Override
	public int exhibitionInsert(ExhibitionDTO dto) throws SQLException{
//		int re1 = cs.executeInsert();
		return 0;
	}
	
	@Override
	public int exhibitionUpdate(int exhibitionNo) throws SQLException{
//		int re2 = cs.executeUpdate();
		return 0;
	}

	@Override
	public int exhibitionDelete(int exhibitionNo) throws SQLException{
//		int re3 = cs.executeDelete();
		return 0;
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


}