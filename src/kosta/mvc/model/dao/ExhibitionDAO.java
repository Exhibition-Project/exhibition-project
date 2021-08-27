package kosta.mvc.model.dao;
//������ ����� ����

import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;

public interface ExhibitionDAO {

   //����ȸ ���
   int exhibitionInsert(ExhibitionDTO dto);
   
   //����ȸ ��ü ����
   List<ExhibitionDTO> exhibitionSelectAll();
   
   //����ȸ ��¥ ����
   List<ExhibitionDTO> exhibitionSelectByDate(String startDate, String endDate);
   
   //����ȸ ����
   int exhibitionUpdate(int exhibitionNo);
   
   //����ȸ ����
   int exhibitionDelete(int exhibitionNo);
   
   
}
