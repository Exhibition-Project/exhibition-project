package kosta.mvc.Service;
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
   public void exhibitionSelectAll() throws SQLException{
      
   }
   //��¥�� �˻�
   public void exhibitionSelectByDate(String startDate, String endDate) throws SQLException{
      
   }
   //����ȸ ���
   public void exhibitionInsert(ExhibitionDTO dto) throws SQLException{
   }
   //����ȸ ����
   public void exhibitionUpdate(int exhibitionNo) throws SQLException{
   }
   //����ȸ ����
   public void exhibitionDelete(int exhibitionNo) throws SQLException {
   }
   

   
}
