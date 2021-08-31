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
 * @author ������
 */
public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	private MemberService memberS = new MemberService();
	
	/**
	 * ����ȸ ��ȣ�� ��ȸ
	 * @throws SQLException 
	 * */
	public List<ReviewDTO> selectAllbyExhibitionNo(int exNo) throws SQLException{
		List<ReviewDTO> reviewDTO = reviewDAO.selectAllbyExhibitionNo(exNo);
		if(reviewDTO == null || reviewDTO.isEmpty()) {
			throw new SearchNotFoundException("����ȸ ��ȣ" + exNo + "�� ��ϵ� �ıⰡ �����ϴ�.");
		}
		return reviewDTO;
	}
	
	/**
	 * ����� ��ȣ�� ��ȸ (�� �ı� ����) 
	 * @return ȸ���� �ۼ��� �ı� ����Ʈ
	 * @throws SQLException
	 */
	public List<ReviewDTO> selectByMemberNo()throws SQLException{
		int memberNo = memberS.getSessionNo();
		List<ReviewDTO> dto = reviewDAO.selectByMemberNo(memberNo);

		return dto;
	}
	
	/**
	 * �ı� ��ȣ�� ��ȸ
	 * @param reviewNo
	 * @return �ش��ϴ� �ı� ����Ʈ
	 * @throws SQLException
	 */
	public ReviewDTO selectByReviewNo(int reviewNo) throws SQLException {
		ReviewDTO dto = reviewDAO.selectByReviewNo(reviewNo);
		if(dto == null) {
			throw new SearchNotFoundException(reviewNo + " ���� �ش��ϴ� �Խù��� �����ϴ�.");
		}
		
		return dto;
	}

	/**
	 * �ı� ���
	 * @param dto
	 * @throws SQLException
	 */
	public void reviewInsert(ReviewDTO dto) throws SQLException{
		dto.setMemberNo(memberS.getSessionNo());
		int result = reviewDAO.reviewInsert(dto);
		if(result == 0)throw new DMLException("�ı⸦ ����� �� �����ϴ�.");
		
	}
	
	/**
	 * �ı� ����
	 * @param dto
	 * @throws SQLException
	 */
	public void reviewUpdate(ReviewDTO dto) throws SQLException{
		dto.setMemberNo(memberS.getSessionNo());
		int result = reviewDAO.ReviewUpdate(dto);
		if(result == 0)throw new DMLException("�ı⸦ ������ �� �����ϴ�.");
	}
	
	/**
	 * �ı� ����(ȸ��)
	 * @param reviewNo
	 * @throws SQLException
	 */
	public void reviewDelete(int reviewNo) throws SQLException {
		int memberNo = memberS.getSessionNo();
		int result = reviewDAO.reviewDelete(memberNo, reviewNo);
		if(result == 0) throw new DMLException("�ı� ������ �����߽��ϴ�.");
	}
	
	/**
	 * �ı� ����(������)
	 * @param reviewNo
	 * @throws SQLException
	 */
	public void reviewDeleteAdmin(int reviewNo) throws SQLException {
		int result = reviewDAO.reviewDeleteAdmin(reviewNo);
		if(result == 0) throw new DMLException("�ı� ������ �����߽��ϴ�.");
	}

}
