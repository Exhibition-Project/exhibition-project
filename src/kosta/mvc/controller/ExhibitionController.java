package kosta.mvc.controller;
//로그인이 되면 기능에 맞는 메소드 호출

import kosta.mvc.Service.ExhibitionService;
import kosta.mvc.model.dto.ExhibitionDTO;

public class ExhibitionController {
   //객체 생성
   ExhibitionService exhibitionService = new ExhibitionService();

   //전시회 전체 검색
   public void exhibitionSelectAll() {}
   //전시회 날짜별 검색
   public void exhibitionSelectByDate(String startDate, String endDate) {}
   //전시회 등록
   public void exhibitionInsert(ExhibitionDTO dto) {}
   //전시회 수정
   public void exhibitionUpdate(int exhibitionNo) {}
   //전시회 삭제
   public void exhibitionDelete(int exhibitionNo) {}
   
   
}   
