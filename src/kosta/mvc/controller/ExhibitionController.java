package kosta.mvc.controller;
//로그인이 되면 기능에 맞는 메소드 호출

import java.sql.SQLException;
import java.util.Calender;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ExhibitionController {
   //객체 생성
   static ExhibitionService exhibitionService = new ExhibitionService();

   //전시회 전체 검색
//   public static void exhibitionSelectAll() {
//	   	try {
//	   		List<ExhibitionDTO> exhibitionList = exhibitionService.exhibitionSelectAll();
//	   		EndView.printExhibition(exhibitionList);
//	   	}catch (SQLException e) {
//	   		FailView.errorMessage(e.getMessage());
//	   	}
//   }
   //전시회 날짜별 검색
//   public static void exhibitionSelectByDate(String startDate, String endDate) {
//	   try {
//		   List<ExhibitionDTO> exhibitionList = exhibitionService.exhibitionSelectByDate(startDate, endDate);
//		   EndView.printAvailableDate(startDate, endDate);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
//   }
   //전시회 등록
   public static void exhibitionInsert(ExhibitionDTO dto) {
//	   try {
//		   exhibitionService.exhibitionInsert(dto);
//	   	   EndView.printMessage("전시회가 등록되었습니다.");
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //전시회 수정
   public static void exhibitionUpdate(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionUpdate(exhibitionNo);
//	       EndView.printMessage("전시회가 수정되었습니다.");
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //전시회 삭제
   public static void exhibitionDelete(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionDelete(exhibitionNo);
//	       EndView.printMessage("전시회가 삭제되었습니다.");
//	   }catch(SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   
   /**
	 * 전시회번호에 해당하는 레코드 검색
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