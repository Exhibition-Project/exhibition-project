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

public class ExhibitionDAOImpl implements ExhibitionDAO {
	Properties proFile = DBUtil.getProFile();

	//��ü �˻�
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


	
	
	//��¥�� �˻�
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

	//����ȸ ���
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
	
	//����ȸ ����
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

	//����ȸ ����
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
	 * ����ȸ��ȣ�� �ش��ϴ� �˻�
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