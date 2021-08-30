package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.StatisticsDTO;
import kosta.mvc.util.DBUtil;

public class StatisticsDAOImpl implements StatisticsDAO{

	@Override
	public List<StatisticsDTO> selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return null;
	}

}
