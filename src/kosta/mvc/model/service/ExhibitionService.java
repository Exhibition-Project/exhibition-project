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
      if(exhibitionList.size()==0 || exhibitionList == null) throw new SQLException("���� ã���ô� ����ȸ�� �������� �ʽ��ϴ�.");
      return exhibitionList;
   }
   //��¥�� �˻�
   public List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException{
      List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectByDate(date);
      if(exhibitionList.size()==0 || exhibitionList == null) throw new SQLException("ã���ô� ��¥�� ������ ����ȸ�� �����ϴ�.");
      return exhibitionList;
   }
   //����ȸ ���
   public void exhibitionInsert(ExhibitionDTO dto) throws SQLException{
	  int result = exhibitionDAO.exhibitionInsert(dto);
	  if(result == 0) throw new SQLException("����ȸ ��Ͽ� �����߽��ϴ�.");
   }
   //����ȸ ����
   public void exhibitionUpdate(ExhibitionDTO dto) throws SQLException{
	   int result = exhibitionDAO.exhibitionUpdate(dto);
	   if(result == 0) throw new SQLException("����ȸ ������ �����߽��ϴ�.");
   }
   //����ȸ ����
   public void exhibitionDelete(int exhibitionNo) throws SQLException {
	   int result = exhibitionDAO.exhibitionDelete(exhibitionNo);
	   if(result == 0) throw new SQLException("����ȸ ������ �����߽��ϴ�.");
   }
   
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