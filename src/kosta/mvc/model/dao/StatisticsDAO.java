package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.StatisticsDTO;
/**
 * @author äâ��
 */
public interface StatisticsDAO {
	
	/**
	 * ����ȸ ��ȣ�� ���ų��� ��ȸ
	 * @param no
	 * @param firstDate
	 * @param lastDate
	 * @return ����ȸ ��ȣ�� �ش��ϴ� ���ų��� ����Ʈ
	 * @throws SQLException
	 */
	ExhibitionDTO selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException;

	/**
	 * ��ü ���ų���
	 * @param firstDate
	 * @param lastDate
	 * @return ��ü ���ų��� ����Ʈ
	 * @throws SQLException
	 */
	ExhibitionDTO selectStatisticsAll(String firstDate, String lastDate) throws SQLException;
}
