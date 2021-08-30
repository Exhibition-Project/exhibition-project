package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;

public interface ReservationDAO {

	/**
	 * 예약하기 
	 * 	1) 테이블에 insert
	 * 	2) reservation_line테이블에 insert
	 * */
	int reservationInsert(ReservationDTO Reservation) throws SQLException;

	/**
	 * 예약내역보기
	 * */
	List<ReservationDTO> selectReservationByMemberId(int memberNo) throws SQLException;
			
}
	

