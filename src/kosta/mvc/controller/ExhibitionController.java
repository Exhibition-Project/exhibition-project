package kosta.mvc.controller;
//�α����� �Ǹ� ��ɿ� �´� �޼ҵ� ȣ��

import kosta.mvc.Service.ExhibitionService;
import kosta.mvc.model.dto.ExhibitionDTO;

public class ExhibitionController {
   //��ü ����
   ExhibitionService exhibitionService = new ExhibitionService();

   //����ȸ ��ü �˻�
   public void exhibitionSelectAll() {}
   //����ȸ ��¥�� �˻�
   public void exhibitionSelectByDate(String startDate, String endDate) {}
   //����ȸ ���
   public void exhibitionInsert(ExhibitionDTO dto) {}
   //����ȸ ����
   public void exhibitionUpdate(int exhibitionNo) {}
   //����ȸ ����
   public void exhibitionDelete(int exhibitionNo) {}
   
   
}   
