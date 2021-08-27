package kosta.mvc.model.dao;
//각각의 기능을 정의

import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;

public interface ExhibitionDAO {

   //전시회 등록
   int exhibitionInsert(ExhibitionDTO dto);
   
   //전시회 전체 보기
   List<ExhibitionDTO> exhibitionSelectAll();
   
   //전시회 날짜 보기
   List<ExhibitionDTO> exhibitionSelectByDate(String startDate, String endDate);
   
   //전시회 수정
   int exhibitionUpdate(int exhibitionNo);
   
   //전시회 삭제
   int exhibitionDelete(int exhibitionNo);
   
   
}
