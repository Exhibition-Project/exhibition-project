package kosta.mvc.controller;
//로그인이 되면 기능에 맞는 메소드 호출

import java.sql.SQLException;

import kosta.mvc.Service.ExhibitionService;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ExhibitionController {
   //객체 생성
   ExhibitionService exhibitionService = new ExhibitionService();

   //전시회 전체 검색
//   public void exhibitionSelectAll() {
//	   	try {
//	   		List<ExhibitionDTO> list = exhibitionService.exhibitionSelectAll();
//	   		EndView.printExhibitionList(null);
//	   	}catch (SQLException e) {
//	   		FailView.errorMessage(e.getMessage());
//	   	}
//   }
   //전시회 날짜별 검색
//   public void exhibitionSelectByDate(String startDate, String endDate) {
//	   try {
//		   List<ExhibitionDTO> list = exhibitionService.exhibitionSelectByDate(startDate, endDate);
//		   EndView.printAvailableDate(startDate, endDate);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
//   }
   //전시회 등록
   public void exhibitionInsert(ExhibitionDTO dto) {
//	   try {
//		   exhibitionService.exhibitionInsert(dto);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //전시회 수정
   public void exhibitionUpdate(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionUpdate(exhibitionNo);
//	   }catch (SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   //전시회 삭제
   public void exhibitionDelete(int exhibitionNo) {
//	   try {
//		   exhibitionService.exhibitionDelete(exhibitionNo);
//	   }catch(SQLException e) {
//		   FailView.errorMessage(e.getMessage());
//	   }
   }
   
   
}   
