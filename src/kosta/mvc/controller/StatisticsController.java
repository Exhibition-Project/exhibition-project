package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.StatisticsDTO;
import kosta.mvc.model.service.StatisticsService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class StatisticsController {
	private static StatisticsService statisticsService = new StatisticsService();
	
	public static void selectStatisticsByNo(int no, String firstDate, String lastDate) {
		try {
			List<StatisticsDTO> statisticsList =  statisticsService.selectStatisticsByNo(no, firstDate, lastDate);
			EndView.printStatistics(statisticsList); //endview 쪽 수정해야함.
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
