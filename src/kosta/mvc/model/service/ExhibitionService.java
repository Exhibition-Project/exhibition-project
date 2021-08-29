package kosta.mvc.model.service;
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
//   public List<Exhibition> exhibitionSelectAll() throws NotFoundException, SQLException{
//      List<Exhibition> list = exhibitionDAO.exhibitionSelectAll();
//      if(list.size()==0) throw new NotFoundException("현재 찾으시는 전시회가 존재하지 않습니다.");
//      return list;
//   }
   //날짜별 검색
   public void exhibitionSelectByDate(String startDate, String endDate) throws SQLException{
      List<ExhibitionDTO> list = exhibitionDAO.exhibitionSelectByDate(startDate, endDate);
   }
   //전시회 등록
//   public void exhibitionInsert(ExhibitionDTO dto) throws SQLException{
//	  List<ExhibitionDTO> list = exhibitionDAO.exhibitionInsert(dto); 
//   }
   //전시회 수정
//   public void exhibitionUpdate(int exhibitionNo) throws SQLException{
//	   List<ExhibitionDTO> list = exhibitionDAO.exhibitionUpdate(exhibitionNo);
//   }
   //전시회 삭제
//   public void exhibitionDelete(int exhibitionNo) throws SQLException {
//	   List<ExhibitionDTO> list = exhibitionDAO.exhibitionDelete(exhibitionNo);
//   }
   
	/**
	 * 전시회번호에 해당하는 레코드 검색
	 */
	public ExhibitionDTO selectByExhibitionxNo(int exhibitionNo) throws SQLException{
		ExhibitionDTO exhibitionDTO = exhibitionDAO.exhibitionSelectByNo(exhibitionNo);
		if(exhibitionDTO == null) {
			throw new SQLException(exhibitionNo+" 번호에 해당하는 전시회는 없습니다.");
		}
		return exhibitionDTO;
	}

   
}