package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.StatisticsDTO;
/**
 * @author 채창완
 */
public interface StatisticsDAO {
	
	/**
	 * 전시회 번호로 예매내역 조회
	 * @param no
	 * @param firstDate
	 * @param lastDate
	 * @return 전시회 번호에 해당하는 예매내역 리스트
	 * @throws SQLException
	 */
	ExhibitionDTO selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException;

	/**
	 * 전체 예매내역
	 * @param firstDate
	 * @param lastDate
	 * @return 전체 예매내역 리스트
	 * @throws SQLException
	 */
	ExhibitionDTO selectStatisticsAll(String firstDate, String lastDate) throws SQLException;
}
