package kosta.mvc.model.service;
//����ȸ ��ü ������.

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ExhibitionDAO;
import kosta.mvc.model.dao.ExhibitionDAOImpl;
import kosta.mvc.model.dto.ExhibitionDTO;

public class ExhibitionService {
   //��ü ����
   ExhibitionDAO exhibitionDAO = new ExhibitionDAOImpl();
   //��ü �˻�
   public List<ExhibitionDTO> exhibitionSelectAll() throws SQLException{
      List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectAll();
      if(exhibitionList.size()==0) throw new SQLException("���� ã���ô� ����ȸ�� �������� �ʽ��ϴ�.");
      return exhibitionList;
   }
   //��¥�� �˻�
//   public void exhibitionSelectByDate(String startDate, String endDate) throws SQLException{
//      List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectByDate(startDate, endDate);
//		if
//   }
   //����ȸ ���
//   public void exhibitionInsert(ExhibitionDTO dto) throws SQLException{
//	  List<ExhibitionDTO> list = exhibitionDAO.exhibitionInsert(dto);
	  
//   }
   //����ȸ ����
//   public void exhibitionUpdate(int exhibitionNo) throws SQLException{
//	   List<ExhibitionDTO> list = exhibitionDAO.exhibitionUpdate(exhibitionNo);
//   }
   //����ȸ ����
//   public void exhibitionDelete(int exhibitionNo) throws SQLException {
//	   List<ExhibitionDTO> list = exhibitionDAO.exhibitionDelete(exhibitionNo);
//   }
   
	/**
	 * ����ȸ��ȣ�� �ش��ϴ� ���ڵ� �˻�
	 */
	public ExhibitionDTO selectByExhibitionxNo(int exhibitionNo) throws SQLException{
		ExhibitionDTO exhibitionDTO = exhibitionDAO.exhibitionSelectByNo(exhibitionNo);
		if(exhibitionDTO == null) {
			throw new SQLException(exhibitionNo+" ��ȣ�� �ش��ϴ� ����ȸ�� �����ϴ�.");
		}
		return exhibitionDTO;
	}

   
}