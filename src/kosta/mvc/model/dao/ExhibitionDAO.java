package kosta.mvc.model.dao;
//������ ����� ����

import java.util.List;
import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;
/**
 * @author �迬��
 */
public interface ExhibitionDAO {

	/**
	 * ����ȸ ��ü ��ȸ
	 * @return ����ȸ ��ü��ȸ
	 * @throws SQLException
	 */
	List<ExhibitionDTO> exhibitionSelectAll() throws SQLException;

	/**
	 * ��¥�� ����ȸ ��ȸ
	 * @param date
	 * @return ��¥�� ����ȸ ����Ʈ
	 * @throws SQLException
	 */
	List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException;

	/**
	 * ���������� ����ȸ ��ȸ
	 * @return ������ ����ȸ ����Ʈ
	 * @throws SQLException
	 */
	List<ExhibitionDTO> exhibitionSelectByStars() throws SQLException;

	/**
	 * ����ȸ ���
	 * @param dto
	 * @return ����ȸ ���
	 * @throws SQLException
	 */
	int exhibitionInsert(ExhibitionDTO dto) throws SQLException;

	/**
	 * ����ȸ ����
	 * @param dto
	 * @return ������ ����ȸ ���ڵ�
	 * @throws SQLException
	 */
	int exhibitionUpdate(ExhibitionDTO dto) throws SQLException;

	/**
	 * ����ȸ ����
	 * @param exhibitionNo
	 * @return ����ȸ ��ȣ�� �ش��ϴ� ���ڵ� ����
	 * @throws SQLException
	 */
	int exhibitionDelete(int exhibitionNo) throws SQLException;


	/**
	 * ����ȸ��ȣ�� �ش��ϴ� ���ڵ� �˻�
	 * @param exhibitionNo
	 * @return ����ȸ ��ȣ�� �ش� ���ڵ� 
	 * @throws SQLException
	 */
	ExhibitionDTO exhibitionSelectByNo(int exhibitionNo)throws SQLException;

}
