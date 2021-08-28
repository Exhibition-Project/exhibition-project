package kosta.mvc.model.dao;
//각각의 기능을 정의

import java.util.List;
import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;

public interface ExhibitionDAO {

   //전시회 전체 보기
   List<ExhibitionDTO> exhibitionSelectAll() throws SQLException;
   
   //전시회 날짜별 보기
   List<ExhibitionDTO> exhibitionSelectByDate(String startDate, String endDate) throws SQLException;
   
   //전시회 등록
   int exhibitionInsert(ExhibitionDTO dto) throws SQLException;
   
   //전시회 수정
   int exhibitionUpdate(int exhibitionNo) throws SQLException;
   
   //전시회 삭제
   int exhibitionDelete(int exhibitionNo) throws SQLException;
   
   
}
