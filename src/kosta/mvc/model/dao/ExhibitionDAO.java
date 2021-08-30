package kosta.mvc.model.dao;
//각각의 기능을 정의

import java.util.List;
import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;

public interface ExhibitionDAO {

   //전시회 전체 보기
   List<ExhibitionDTO> exhibitionSelectAll() throws SQLException;
   
   //전시회 날짜별 보기
   List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException;
   
   //전시회 별점별 보기
   List<ExhibitionDTO> exhibitionSelectByStars(int stars) throws SQLException;
   
   //전시회 등록
   int exhibitionInsert(ExhibitionDTO dto) throws SQLException;
   
   //전시회 수정
   int exhibitionUpdate(ExhibitionDTO dto) throws SQLException;
   
   //전시회 삭제
   int exhibitionDelete(int exhibitionNo) throws SQLException;

	/**
	 * 전시회번호에 해당하는 레코드 검색
	 * select exhibition_no, exhibition_name, start_date, end_date, genre, price, exhibition_loc from exhibition where exhibition_no = ?	 
	 * */
	ExhibitionDTO exhibitionSelectByNo(int exhibitionNo)throws SQLException;
  
}
