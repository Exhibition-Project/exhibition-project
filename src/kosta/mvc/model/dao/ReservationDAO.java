package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;

public interface ReservationDAO {

	/**
	 * �����ϱ� 
	 * 	1) ���̺� insert
	 * 	2) reservation_line���̺� insert
	 * */
	int reservationInsert(ReservationDTO Reservation) throws SQLException;

	/**
	 * �α��� �� ����� �´� ���ų�������
	 * */
	List<ReservationDTO> selectReservationByMemberNo(int memberNo) throws SQLException;

	/**
	 * ���ų��� ��ü ���� 
	 * */		
	List<ReservationDTO> reservationSelectAll() throws SQLException;

	/**
	 * ���ų������� ��ȸ
	 * */
	List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException;

}
	

