package kosta.mvc.controller;
//�α����� �Ǹ� ��ɿ� �´� �޼ҵ� ȣ��

import java.sql.SQLException;
import java.util.Calender;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ExhibitionController {
   //��ü ����
   static ExhibitionService exhibitionService = new ExhibitionService();

   //����ȸ ��ü �˻�
//   public static void exhibitionSelectAll() {
//	   	try {
//	   		List<ExhibitionDTO> exhibitionList = exhibitionService.exhibitionSelectAll();
//	   		EndView.printExhibition(exhibitionList);
//	   	}catch (SQLException e) {
//	   		FailView.errorMessage(e.getMessage());
//	   	}
//   }
   //����ȸ ��¥�� �˻�
//   public static void exhibitionSelectByDate(String startDate, String endDate) {
//	   try {
//		   List<ExhibitionDTO> exhibitionList = exhibitionService.exhibitionSelectByDate(startDate, endDate);
//		   EndView.printAvailableDate(startDate, endDate);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
//   }
   //����ȸ ���
   public static void exhibitionInsert(ExhibitionDTO dto) {
//	   try {
//		   exhibitionService.exhibitionInsert(dto);
//	   	   EndView.printMessage("����ȸ�� ��ϵǾ����ϴ�.");
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //����ȸ ����
   public static void exhibitionUpdate(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionUpdate(exhibitionNo);
//	       EndView.printMessage("����ȸ�� �����Ǿ����ϴ�.");
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //����ȸ ����
   public static void exhibitionDelete(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionDelete(exhibitionNo);
//	       EndView.printMessage("����ȸ�� �����Ǿ����ϴ�.");
//	   }catch(SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   
   /**
	 * ����ȸ��ȣ�� �ش��ϴ� ���ڵ� �˻�
	 */
	public static void selectByExhibitionxNo(int exhibitionNo) {
		try {
			ExhibitionDTO exhibitionDTO = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			EndView.selectByExhibitionxNo(exhibitionDTO);
		}catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

}   