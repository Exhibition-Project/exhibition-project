package kosta.mvc.model.dao;
//������ ����� ����

import java.util.List;
import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;

public interface ExhibitionDAO {

   //����ȸ ��ü ����
   List<ExhibitionDTO> exhibitionSelectAll() throws SQLException;
   
   //����ȸ ��¥�� ����
   List<ExhibitionDTO> exhibitionSelectByDate(String startDate, String endDate) throws SQLException;
   
   //����ȸ ���
   int exhibitionInsert(ExhibitionDTO dto) throws SQLException;
   
   //����ȸ ����
   int exhibitionUpdate(int exhibitionNo) throws SQLException;
   
   //����ȸ ����
   int exhibitionDelete(int exhibitionNo) throws SQLException;
   
   
}
