package kosta.mvc.controller;
//�α����� �Ǹ� ��ɿ� �´� �޼ҵ� ȣ��

import java.sql.SQLException;

import kosta.mvc.Service.ExhibitionService;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ExhibitionController {
   //��ü ����
   ExhibitionService exhibitionService = new ExhibitionService();

   //����ȸ ��ü �˻�
//   public void exhibitionSelectAll() {
//	   	try {
//	   		List<ExhibitionDTO> list = exhibitionService.exhibitionSelectAll();
//	   		EndView.printExhibitionList(null);
//	   	}catch (SQLException e) {
//	   		FailView.errorMessage(e.getMessage());
//	   	}
//   }
   //����ȸ ��¥�� �˻�
//   public void exhibitionSelectByDate(String startDate, String endDate) {
//	   try {
//		   List<ExhibitionDTO> list = exhibitionService.exhibitionSelectByDate(startDate, endDate);
//		   EndView.printAvailableDate(startDate, endDate);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
//   }
   //����ȸ ���
   public void exhibitionInsert(ExhibitionDTO dto) {
//	   try {
//		   exhibitionService.exhibitionInsert(dto);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //����ȸ ����
   public void exhibitionUpdate(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionUpdate(exhibitionNo);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //����ȸ ����
   public void exhibitionDelete(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionDelete(exhibitionNo);
//	   }catch(SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   
   
}   
