package kosta.mvc.model.dao;

import java.util.List;

import kosta.mvc.model.dto.StatisticsDTO;

public interface StatisticsDAO {
	List<StatisticsDTO> selectStatisticsByNo(int no, String firstDate, String lastDate);
}
