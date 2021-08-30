package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;

public interface ReservationDAO {

	/**
	 * �����ϱ� 
	 * 	1) ���̺� insert
	 * 	2) reservation_line���̺� insert
	 * */
	int reservationInsert(ReservationDTO Reservation) throws SQLException;

	/**
	 * ���೻������
	 * */
	List<ReservationDTO> selectReservationByMemberId(int memberNo) throws SQLException;
			
}
	

