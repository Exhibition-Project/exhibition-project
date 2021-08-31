package kosta.mvc.model.dao;
//각각의 기능을 정의

import java.util.List;
import java.sql.SQLException;

import kosta.mvc.model.dto.ExhibitionDTO;
/**
 * @author 김연식
 */
public interface ExhibitionDAO {

	/**
	 * 전시회 전체 조회
	 * @return 전시회 전체조회
	 * @throws SQLException
	 */
	List<ExhibitionDTO> exhibitionSelectAll() throws SQLException;

	/**
	 * 날짜별 전시회 조회
	 * @param date
	 * @return 날짜별 전시회 리스트
	 * @throws SQLException
	 */
	List<ExhibitionDTO> exhibitionSelectByDate(String date) throws SQLException;

	/**
	 * 별점순으로 전시회 조회
	 * @return 별점순 전시회 리스트
	 * @throws SQLException
	 */
	List<ExhibitionDTO> exhibitionSelectByStars() throws SQLException;

	/**
	 * 전시회 등록
	 * @param dto
	 * @return 전시회 등록
	 * @throws SQLException
	 */
	int exhibitionInsert(ExhibitionDTO dto) throws SQLException;

	/**
	 * 전시회 수정
	 * @param dto
	 * @return 수정된 전시회 레코드
	 * @throws SQLException
	 */
	int exhibitionUpdate(ExhibitionDTO dto) throws SQLException;

	/**
	 * 전시회 삭제
	 * @param exhibitionNo
	 * @return 전시회 번호에 해당하는 레코드 삭제
	 * @throws SQLException
	 */
	int exhibitionDelete(int exhibitionNo) throws SQLException;


	/**
	 * 전시회번호에 해당하는 레코드 검색
	 * @param exhibitionNo
	 * @return 전시회 번호에 해당 레코드 
	 * @throws SQLException
	 */
	ExhibitionDTO exhibitionSelectByNo(int exhibitionNo)throws SQLException;

}
