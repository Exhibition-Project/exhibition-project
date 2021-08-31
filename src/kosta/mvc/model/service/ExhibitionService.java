package kosta.mvc.model.service;
//����ȸ ��ü ������.
import kosta.mvc.exception.SearchNotFoundException;
import kosta.mvc.exception.DMLException;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ExhibitionDAO;
import kosta.mvc.model.dao.ExhibitionDAOImpl;
import kosta.mvc.model.dto.ExhibitionDTO;
/**
 * @author �迬��
 */
public class ExhibitionService {

	ExhibitionDAO exhibitionDAO = new ExhibitionDAOImpl();//��ü ����

	/**
	 * ����ȸ ��ü �˻�
	 * @return ��ü ����ȸ ����Ʈ
	 * @throws SQLException
	 */
	public List<ExhibitionDTO> exhibitionSelectAll() throws SQLException{
		List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectAll();
		if(exhibitionList.size()==0 || exhibitionList == null) throw new SearchNotFoundException("\n���� ã���ô� ����ȸ�� �������� �ʽ��ϴ�.");
		return exhibitionList;
	}

	/**
	 * ��¥�� ����ȸ �˻�
	 * @param date
	 * @return ��¥�� �ش��ϴ� ����ȸ ����Ʈ
	 * @throws SQLException
	 */
	public List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException{
		List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectByDate(date);
		if(exhibitionList.size()==0 || exhibitionList == null) throw new SearchNotFoundException("\nã���ô� ��¥�� ������ ����ȸ�� �����ϴ�.");
		return exhibitionList;
	}

	/**
	 * ������ ����ȸ �˻�
	 * @return ���� ������ �ش��ϴ� ����Ʈ���� ����ϴ� �޼ҵ�
	 * @throws SQLException
	 */
	public List<ExhibitionDTO> exhibitionSelectByStars() throws SQLException{
		List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectByStars();
		if(exhibitionList.size()==0 || exhibitionList == null) throw new SearchNotFoundException("\nã���ô� ����ȸ�� �������� �ʽ��ϴ�.");
		return exhibitionList;
	}

	/**
	 * ����ȸ ���
	 * @param dto
	 * @throws SQLException
	 */
	public void exhibitionInsert(ExhibitionDTO dto) throws SQLException{
		int result = exhibitionDAO.exhibitionInsert(dto);
		if(result == 0) throw new DMLException("\n����ȸ ��Ͽ� �����߽��ϴ�.");
	}

	/**
	 * ����ȸ ����
	 * @param dto
	 * @throws SQLException
	 */
	public void exhibitionUpdate(ExhibitionDTO dto) throws SQLException{
		int result = exhibitionDAO.exhibitionUpdate(dto);
		//	   System.out.println("���񽺿� ���ϵ�");
		if(result == 0) throw new DMLException("\n����ȸ ������ �����߽��ϴ�.");
	}

	/**
	 * ����ȸ ����
	 * @param exhibitionNo
	 * @throws SQLException
	 */
	public void exhibitionDelete(int exhibitionNo) throws SQLException {
		int result = exhibitionDAO.exhibitionDelete(exhibitionNo);
		if(result == 0) throw new DMLException("\n����ȸ ������ �����߽��ϴ�.");
	}

	/**
	 * ����ȸ��ȣ�� �ش��ϴ� ���ڵ� �˻�
	 * @param exhibitionNo
	 * @return
	 * @throws SQLException
	 */
	public ExhibitionDTO selectByExhibitionxNo(int exhibitionNo) throws SQLException{
		ExhibitionDTO exhibitionDTO = exhibitionDAO.exhibitionSelectByNo(exhibitionNo);
		if(exhibitionDTO == null) {
			throw new SearchNotFoundException("\n"+exhibitionNo+" ��ȣ�� �ش��ϴ� ����ȸ�� �����ϴ�.");
		}
		return exhibitionDTO;
	}


}