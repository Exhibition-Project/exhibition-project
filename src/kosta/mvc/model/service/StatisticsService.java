package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.StatisticsDAO;
import kosta.mvc.model.dao.StatisticsDAOImpl;
import kosta.mvc.model.dto.StatisticsDTO;

public class StatisticsService {
	private StatisticsDAO statisTicsDAO = new StatisticsDAOImpl();
	
	public List<StatisticsDTO> selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException{
		
		List<StatisticsDTO> statisticsList = statisTicsDAO.selectStatisticsByNo(no, firstDate, lastDate);		
		if(statisticsList == null || statisticsList.size() == 0) throw new SQLException("해당 기간 내 예매 이력이 없거나, 존재하지 않는 전시회 입니다.");
		return statisticsList;

	}
}
