package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReviewDTO;
/**
 * @author ������
 */
public interface ReviewDAO {

	/**
	 * �ı� ����ϱ�
	 * 1) ����ڰ� ���� �Է��� �ı� ������
	 * 2) Review ���̺� insert
	 * @param review
	 * @return insert ��������
	 * @throws SQLException
	 */
	int reviewInsert(ReviewDTO review) throws SQLException;
	
	
	/**
	 * �ı⺸��(����ȸ ��ȣ�� ��ȸ)
	 * @param exibitionNo
	 * @return �ı� ����Ʈ
	 * @throws SQLException
	 */
	List<ReviewDTO> selectAllbyExhibitionNo(int exibitionNo) throws SQLException;
	
	/**
	 * �� �ı� ����
	 * 1) ���� �α��� �� ����� ��ȣ ������
	 * 2) �ı� �˻�
	 * @param memberNo
	 * @return �ı� ����Ʈ
	 * @throws SQLException
	 * */
	List<ReviewDTO> selectByMemberNo (int memberNo) throws SQLException;  
	
	/**
	 * �ı� ��ȣ�� �ش��ϴ� �ı� ����
	 * @param ReviewDTO
	 * @return update ��������
	 * @throws SQLException
	 * */
	int ReviewUpdate(ReviewDTO dto) throws SQLException;
	
	/////////////////////////////////////////////
	
	/**
	 * �ı��ȣ�� �ش��ϴ� �ı� �˻� (�����ڿ�)
	 * @param reviewNo
	 * @return �ı�
	 * @throws SQLException
	 * */
	ReviewDTO selectByReviewNo(int reviewNo) throws SQLException;

	
	/**
	 * �ı� ��ȣ�� �ش��ϴ� �ı� ���� (ȸ����)
	 * @param memberNo
	 * @param reviewNo
	 * @return delete ��������
	 * @throws SQLException
	 * */
	int reviewDelete(int memberNo, int reviewNo) throws SQLException;
	
	/**
	 * �ı� ��ȣ�� �ش��ϴ� �ı� ���� (�����ڿ�)
	 * @param reviewNo
	 * @return delete ��������
	 * @throws SQLException
	 * */
	int reviewDeleteAdmin(int reviewNo) throws SQLException;
	
	
	
	

}
