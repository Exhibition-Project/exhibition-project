package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
/**
 * @author 김연식
 */
public class ExhibitionController {

	private static ExhibitionService exhibitionService = new ExhibitionService();//객체 생성

	/**
	 * 전시회 전체 검색 
	 */
	public static void exhibitionSelectAll() {
		try {
			List<ExhibitionDTO> exhibitionList = exhibitionService.exhibitionSelectAll();
			EndView.printExhibitionList(exhibitionList);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전시회 날짜별 검색 
	 * @param date
	 */
	public static void exhibitionSelectByDate(String date) {
		try {
			List<ExhibitionDTO> exhibitionList = exhibitionService.exhibitionSelectByDate(date);
			EndView.printExhibitionList(exhibitionList);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전시회 별점순 조회
	 */
	public static void exhibitionSelectByStars() {
		try {
			List<ExhibitionDTO> exhibitionList = exhibitionService.exhibitionSelectByStars();
			EndView.printExhibitionListbyStars(exhibitionList);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전시회 등록
	 * @param dto
	 */
	public static void exhibitionInsert(ExhibitionDTO dto) {
		try {
			exhibitionService.exhibitionInsert(dto);
			EndView.printMessage("\n전시회가 등록되었습니다.");
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전시회 수정
	 * @param dto
	 */
	public static void exhibitionUpdate(ExhibitionDTO dto) {
		try {
			exhibitionService.exhibitionUpdate(dto);
			//		   System.out.println("컨트롤러에 리턴됨");
			EndView.printMessage("\n전시회가 수정되었습니다.");
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전시회 삭제 
	 * @param exhibitionNo
	 */
	public static void exhibitionDelete(int exhibitionNo) {
		try {
			exhibitionService.exhibitionDelete(exhibitionNo);
			EndView.printMessage("\n전시회가 삭제되었습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전시회번호에 해당하는 레코드 검색
	 * @param exhibitionNo
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