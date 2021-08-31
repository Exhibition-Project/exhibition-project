package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.SearchNotFoundException;
import kosta.mvc.model.dao.StatisticsDAO;
import kosta.mvc.model.dao.StatisticsDAOImpl;
import kosta.mvc.model.dto.ExhibitionDTO;
/**
 * @author äâ��
 */
public class StatisticsService {
	private StatisticsDAO statisTicsDAO = new StatisticsDAOImpl();
	
	/**
	 * ����ȸ��ȣ�� ���ų��� ��ȸ
	 * @param no
	 * @param firstDate
	 * @param lastDate
	 * @return �ش��ϴ� ���ų��� ����Ʈ
	 * @throws SQLException
	 */
	public ExhibitionDTO selectStatisticsByNo(int no, String firstDate, String lastDate) throws SQLException{
		ExhibitionDTO exhibitionDTO = statisTicsDAO.selectStatisticsByNo(no, firstDate, lastDate);	
		if(exhibitionDTO == null) {
			throw new SearchNotFoundException("ã���ô� ����ȸ�� �������� �ʽ��ϴ�.");
		}
		if(exhibitionDTO.getStatisticsList() == null ||  exhibitionDTO.getStatisticsList().size() == 0) {
			throw new SearchNotFoundException("ã���ô� �Ⱓ�� ���� ������ �����ϴ�.");
		}
		return exhibitionDTO;
	}
	
	/**
	 * ��ü ���ų��� ��ȸ
	 * @param firstDate
	 * @param lastDate
	 * @return �Է��� �Ⱓ�� �ش��ϴ� ��ü ���ų��� ����Ʈ
	 * @throws SQLException
	 */
	public ExhibitionDTO selectStatisticsAll(String firstDate, String lastDate) throws SQLException{
		ExhibitionDTO exhibitionDTO = statisTicsDAO.selectStatisticsAll(firstDate, lastDate);	
		if(exhibitionDTO.getStatisticsList() == null ||  exhibitionDTO.getStatisticsList().size() == 0) {
			throw new SearchNotFoundException("ã���ô� �Ⱓ�� ���� ������ �����ϴ�.");
		}
		return exhibitionDTO;
	}
}
