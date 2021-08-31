package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;

import kosta.mvc.model.service.StatisticsService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class StatisticsController {
	private static StatisticsService statisticsService = new StatisticsService();
	
	public static void selectStatisticsByNo(int no, String firstDate, String lastDate) {
		try {
			ExhibitionDTO exhibitionDTO =  statisticsService.selectStatisticsByNo(no, firstDate, lastDate);
			EndView.printStatistics(exhibitionDTO); 
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void selectStatisticsAll(String firstDate, String lastDate) {
		try {
			ExhibitionDTO exhibitionDTO =  statisticsService.selectStatisticsAll(firstDate, lastDate);
			EndView.printStatistics(exhibitionDTO);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
