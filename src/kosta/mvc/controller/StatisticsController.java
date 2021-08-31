package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;

import kosta.mvc.model.service.StatisticsService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
/**
 * @author 채창완
 */
public class StatisticsController {
	private static StatisticsService statisticsService = new StatisticsService();
	
	/**
	 * 전시회번호로 해당 전시회의 예매내역 조회
	 * @param no
	 * @param firstDate
	 * @param lastDate
	 */
	public static void selectStatisticsByNo(int no, String firstDate, String lastDate) {
		try {
			ExhibitionDTO exhibitionDTO =  statisticsService.selectStatisticsByNo(no, firstDate, lastDate);
			EndView.printStatistics(exhibitionDTO); 
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 전체 예매내역 조회
	 * @param firstDate
	 * @param lastDate
	 */
	public static void selectStatisticsAll(String firstDate, String lastDate) {
		try {
			ExhibitionDTO exhibitionDTO =  statisticsService.selectStatisticsAll(firstDate, lastDate);
			EndView.printStatistics(exhibitionDTO);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
