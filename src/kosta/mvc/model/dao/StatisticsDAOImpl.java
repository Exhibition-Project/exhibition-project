package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.StatisticsDTO;
import kosta.mvc.util.DBUtil;

public class StatisticsDAOImpl implements StatisticsDAO{
	private Properties proFile = DBUtil.getProFile();

	@Override
	public ExhibitionDTO selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException{
		ExhibitionDAO exhibitionDAO = new ExhibitionDAOImpl();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ExhibitionDTO exhibitionDTO = null;
		List<StatisticsDTO> statisticsList = new ArrayList<StatisticsDTO>();
		String sql = proFile.getProperty("statistics.selectStatisticsByNo");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, firstDate);
			ps.setString(3, lastDate);
			rs = ps.executeQuery();
			
			exhibitionDTO = exhibitionDAO.exhibitionSelectByNo(no);
			while(rs.next()) {
				StatisticsDTO statisticsDTO = new StatisticsDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				statisticsList.add(statisticsDTO);
			}
			if(exhibitionDTO != null) {
				exhibitionDTO.setStatisticsList(statisticsList);				
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return exhibitionDTO;
	}
	

}
