package kosta.mvc.model.dao;
//������ ����� ����

import java.util.List;
import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;

public interface ExhibitionDAO {

   //����ȸ ��ü ����
   List<ExhibitionDTO> exhibitionSelectAll() throws SQLException;
   
   //����ȸ ��¥�� ����
   List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException;
   
   //����ȸ ������ ����
   List<ExhibitionDTO> exhibitionSelectByStars(int stars) throws SQLException;
   
   //����ȸ ���
   int exhibitionInsert(ExhibitionDTO dto) throws SQLException;
   
   //����ȸ ����
   int exhibitionUpdate(ExhibitionDTO dto) throws SQLException;
   
   //����ȸ ����
   int exhibitionDelete(int exhibitionNo) throws SQLException;

	/**
	 * ����ȸ��ȣ�� �ش��ϴ� ���ڵ� �˻�
	 * select exhibition_no, exhibition_name, start_date, end_date, genre, price, exhibition_loc from exhibition where exhibition_no = ?	 
	 * */
	ExhibitionDTO exhibitionSelectByNo(int exhibitionNo)throws SQLException;
  
}
