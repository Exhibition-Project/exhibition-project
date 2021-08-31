package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
/**
 * @author ������
 */
public interface ReservationDAO {

	/**
	 * �����ϱ� 
	 * 	1) ���̺� insert
	 * 	2) reservation_line���̺� insert
	 * @param Reservation
	 * @return ����ȸ ����� ���ڵ� 
	 * @throws Exception
	 */
	int reservationInsert(ReservationDTO Reservation) throws Exception;

	/**
	 * �α��� �� ȸ���� �´� ���ų�������
	 * @param memberNo
	 * @return �ش� ȸ���� ���ų���
	 * @throws SQLException
	 */
	List<ReservationDTO> selectReservationByMemberNo(int memberNo) throws SQLException;

	/**
	 * ���ų��� ��ü �˻�
	 * @return ���ų��� ��ü ����Ʈ 
	 * @throws SQLException
	 */
	List<ReservationDTO> reservationSelectAll() throws SQLException;

	/**
	 * ���Ź�ȣ�� ���ų��� ��ȸ
	 * @param reservationNo
	 * @return ���Ź�ȣ�� �ش��ϴ� ���ų���
	 * @throws SQLException
	 */
	List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException;

	/**
	 * ���ų��� ���(����)
	 * @param reservationNo
	 * @return ���Ź�ȣ�� �ش��ϴ� ���ų��� ���ڵ� ����
	 * @throws SQLException
	 */
	int reservationDelete(int memberNo, int reservationNo) throws SQLException;
}
	

