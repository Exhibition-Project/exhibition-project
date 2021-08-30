package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;

public interface ReservationDAO {

	/**
	 * 예약하기 
	 * 	1) 테이블에 insert
	 * 	2) reservation_line테이블에 insert
	 * */
	int reservationInsert(ReservationDTO Reservation) throws SQLException;

	/**
	 * 로그인 한 멤버에 맞는 예매내역보기
	 * */
	List<ReservationDTO> selectReservationByMemberNo(int memberNo) throws SQLException;

	/**
	 * 예매내역 전체 보기 
	 * */		
	List<ReservationDTO> reservationSelectAll() throws SQLException;

	/**
	 * 예매내역으로 조회
	 * */
	List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException;

}
	

