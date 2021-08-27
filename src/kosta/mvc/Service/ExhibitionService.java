package kosta.mvc.Service;
//전시회 객체 꺼내옴.

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ExhibitionDAO;
import kosta.mvc.model.dao.ExhibitionDAOImpl;
import kosta.mvc.model.dto.ExhibitionDTO;

public class ExhibitionService {
   //객체 생성
   ExhibitionDAO exhibitionDAO = new ExhibitionDAOImpl();
   //전체 검색
   public void exhibitionSelectAll() throws SQLException{
      
   }
   //날짜별 검색
   public void exhibitionSelectByDate(String startDate, String endDate) throws SQLException{
      
   }
   //전시회 등록
   public void exhibitionInsert(ExhibitionDTO dto) throws SQLException{
   }
   //전시회 수정
   public void exhibitionUpdate(int exhibitionNo) throws SQLException{
   }
   //전시회 삭제
   public void exhibitionDelete(int exhibitionNo) throws SQLException {
   }
   

   
}
