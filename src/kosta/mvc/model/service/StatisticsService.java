package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.SearchNotFoundException;
import kosta.mvc.model.dao.StatisticsDAO;
import kosta.mvc.model.dao.StatisticsDAOImpl;
import kosta.mvc.model.dto.ExhibitionDTO;
/**
 * @author 채창완
 */
public class StatisticsService {
	private StatisticsDAO statisTicsDAO = new StatisticsDAOImpl();
	
	/**
	 * 전시회번호로 예매내역 조회
	 * @param no
	 * @param firstDate
	 * @param lastDate
	 * @return 해당하는 예매내역 리스트
	 * @throws SQLException
	 */
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
	
	/**
	 * 전체 예매내역 조회
	 * @param firstDate
	 * @param lastDate
	 * @return 입력한 기간에 해당하는 전체 예매내역 리스트
	 * @throws SQLException
	 */
	public ExhibitionDTO selectStatisticsAll(String firstDate, String lastDate) throws SQLException{
		ExhibitionDTO exhibitionDTO = statisTicsDAO.selectStatisticsAll(firstDate, lastDate);	
		if(exhibitionDTO.getStatisticsList() == null ||  exhibitionDTO.getStatisticsList().size() == 0) {
			throw new SearchNotFoundException("찾으시는 기간의 예매 내역이 없습니다.");
		}
		return exhibitionDTO;
	}
}
