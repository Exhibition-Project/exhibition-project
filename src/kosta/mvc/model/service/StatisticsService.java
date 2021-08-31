package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.SearchNotFoundException;
import kosta.mvc.model.dao.StatisticsDAO;
import kosta.mvc.model.dao.StatisticsDAOImpl;
import kosta.mvc.model.dto.ExhibitionDTO;


public class StatisticsService {
	private StatisticsDAO statisTicsDAO = new StatisticsDAOImpl();
	
	public ExhibitionDTO selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException{
		ExhibitionDTO exhibitionDTO = statisTicsDAO.selectStatisticsByNo(no, firstDate, lastDate);	
		if(exhibitionDTO == null) {
			throw new SearchNotFoundException("찾으시는 전시회가 존재하지 않습니다.");
		}
		if(exhibitionDTO.getStatisticsList() == null ||  exhibitionDTO.getStatisticsList().size() == 0) {
			throw new SearchNotFoundException("찾으시는 기간의 예매 내역이 없습니다.");
		}
		return exhibitionDTO;
	}
}
