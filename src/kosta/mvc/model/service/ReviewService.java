package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.DMLException;
import kosta.mvc.exception.SearchNotFoundException;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.service.MemberService;
import kosta.mvc.session.Session;
/**
 * @author 현지윤
 */
public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	private MemberService memberS = new MemberService();
	
	/**
	 * 전시회 번호로 조회
	 * @throws SQLException 
	 * */
	public List<ReviewDTO> selectAllbyExhibitionNo(int exNo) throws SQLException{
		List<ReviewDTO> reviewDTO = reviewDAO.selectAllbyExhibitionNo(exNo);
		if(reviewDTO == null || reviewDTO.isEmpty()) {
			throw new SearchNotFoundException("전시회 번호" + exNo + "에 등록된 후기가 없습니다.");
		}
		return reviewDTO;
	}
	
	/**
	 * 사용자 번호로 조회 (내 후기 보기) 
	 * @return 회원이 작성한 후기 리스트
	 * @throws SQLException
	 */
	public List<ReviewDTO> selectByMemberNo()throws SQLException{
		int memberNo = memberS.getSessionNo();
		List<ReviewDTO> dto = reviewDAO.selectByMemberNo(memberNo);

		return dto;
	}
	
	/**
	 * 후기 번호로 조회
	 * @param reviewNo
	 * @return 해당하는 후기 리스트
	 * @throws SQLException
	 */
	public ReviewDTO selectByReviewNo(int reviewNo) throws SQLException {
		ReviewDTO dto = reviewDAO.selectByReviewNo(reviewNo);
		if(dto == null) {
			throw new SearchNotFoundException(reviewNo + " 번에 해당하는 게시물이 없습니다.");
		}
		
		return dto;
	}

	/**
	 * 후기 등록
	 * @param dto
	 * @throws SQLException
	 */
	public void reviewInsert(ReviewDTO dto) throws SQLException{
		dto.setMemberNo(memberS.getSessionNo());
		int result = reviewDAO.reviewInsert(dto);
		if(result == 0)throw new DMLException("후기를 등록할 수 없습니다.");
		
	}
	
	/**
	 * 후기 수정
	 * @param dto
	 * @throws SQLException
	 */
	public void reviewUpdate(ReviewDTO dto) throws SQLException{
		dto.setMemberNo(memberS.getSessionNo());
		int result = reviewDAO.ReviewUpdate(dto);
		if(result == 0)throw new DMLException("후기를 수정할 수 없습니다.");
	}
	
	/**
	 * 후기 삭제(회원)
	 * @param reviewNo
	 * @throws SQLException
	 */
	public void reviewDelete(int reviewNo) throws SQLException {
		int memberNo = memberS.getSessionNo();
		int result = reviewDAO.reviewDelete(memberNo, reviewNo);
		if(result == 0) throw new DMLException("후기 삭제에 실패했습니다.");
	}
	
	/**
	 * 후기 삭제(관리자)
	 * @param reviewNo
	 * @throws SQLException
	 */
	public void reviewDeleteAdmin(int reviewNo) throws SQLException {
		int result = reviewDAO.reviewDeleteAdmin(reviewNo);
		if(result == 0) throw new DMLException("후기 삭제에 실패했습니다.");
	}

}
