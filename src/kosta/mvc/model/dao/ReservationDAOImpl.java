package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;

public class ReservationDAOImpl implements ReservationDAO{
	
	ReservationDAO reservationDao = new ReservationDAOImpl();
	 
	/**
	 * 예약하기 
	 * 	1) 테이블에 insert
	 * 	2) order_line테이블에 insert
	 * */
	@Override
	public int reservationInsert(ReservationDTO Reservation) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 예약내역보기
	 * */
	@Override
	public List<ReservationDTO> selctReservationByMemberId(String memberId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 예매 내역 출력
	 * */
	@Override
	public List<ReservationDTO> printReservationByNo(ReservationDTO reservationDTO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 예약 상세등록하기
	 * */


	/**
	 * 예약 총구매금액 구하기
	 * */
	
	/**
	 * 예약번호에 해당하는 주문상세 가져오기
	 * */
	
	
}
