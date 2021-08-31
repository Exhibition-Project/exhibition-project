package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.StatisticsDTO;

public interface StatisticsDAO {
	ExhibitionDTO selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException;

	ExhibitionDTO selectStatisticsAll(String firstDate, String lastDate) throws SQLException;
}
