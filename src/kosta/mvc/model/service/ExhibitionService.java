package kosta.mvc.model.service;
//전시회 객체 꺼내옴.
import kosta.mvc.exception.SearchNotFoundException;
import kosta.mvc.exception.DMLException;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ExhibitionDAO;
import kosta.mvc.model.dao.ExhibitionDAOImpl;
import kosta.mvc.model.dto.ExhibitionDTO;
/**
 * @author 김연식
 */
public class ExhibitionService {

	ExhibitionDAO exhibitionDAO = new ExhibitionDAOImpl();//객체 생성

	/**
	 * 전시회 전체 검색
	 * @return 전체 전시회 리스트
	 * @throws SQLException
	 */
	public List<ExhibitionDTO> exhibitionSelectAll() throws SQLException{
		List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectAll();
		if(exhibitionList.size()==0 || exhibitionList == null) throw new SearchNotFoundException("\n현재 찾으시는 전시회가 존재하지 않습니다.");
		return exhibitionList;
	}

	/**
	 * 날짜별 전시회 검색
	 * @param date
	 * @return 날짜에 해당하는 전시회 리스트
	 * @throws SQLException
	 */
	public List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException{
		List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectByDate(date);
		if(exhibitionList.size()==0 || exhibitionList == null) throw new SearchNotFoundException("\n찾으시는 날짜에 열리는 전시회가 없습니다.");
		return exhibitionList;
	}

	/**
	 * 별점순 전시회 검색
	 * @return 높은 별점에 해당하는 리스트부터 출력하는 메소드
	 * @throws SQLException
	 */
	public List<ExhibitionDTO> exhibitionSelectByStars() throws SQLException{
		List<ExhibitionDTO> exhibitionList = exhibitionDAO.exhibitionSelectByStars();
		if(exhibitionList.size()==0 || exhibitionList == null) throw new SearchNotFoundException("\n찾으시는 전시회가 존재하지 않습니다.");
		return exhibitionList;
	}

	/**
	 * 전시회 등록
	 * @param dto
	 * @throws SQLException
	 */
	public void exhibitionInsert(ExhibitionDTO dto) throws SQLException{
		int result = exhibitionDAO.exhibitionInsert(dto);
		if(result == 0) throw new DMLException("\n전시회 등록에 실패했습니다.");
	}

	/**
	 * 전시회 수정
	 * @param dto
	 * @throws SQLException
	 */
	public void exhibitionUpdate(ExhibitionDTO dto) throws SQLException{
		int result = exhibitionDAO.exhibitionUpdate(dto);
		//	   System.out.println("서비스에 리턴됨");
		if(result == 0) throw new DMLException("\n전시회 수정에 실패했습니다.");
	}

	/**
	 * 전시회 삭제
	 * @param exhibitionNo
	 * @throws SQLException
	 */
	public void exhibitionDelete(int exhibitionNo) throws SQLException {
		int result = exhibitionDAO.exhibitionDelete(exhibitionNo);
		if(result == 0) throw new DMLException("\n전시회 삭제에 실패했습니다.");
	}

	/**
	 * 전시회번호에 해당하는 레코드 검색
	 * @param exhibitionNo
	 * @return
	 * @throws SQLException
	 */
	public ExhibitionDTO selectByExhibitionxNo(int exhibitionNo) throws SQLException{
		ExhibitionDTO exhibitionDTO = exhibitionDAO.exhibitionSelectByNo(exhibitionNo);
		if(exhibitionDTO == null) {
			throw new SearchNotFoundException("\n"+exhibitionNo+" 번호에 해당하는 전시회는 없습니다.");
		}
		return exhibitionDTO;
	}


}