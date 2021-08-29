package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReservationDAO;
import kosta.mvc.model.dao.ReservationDAOImpl;
import kosta.mvc.model.dto.ReservationDTO;

public class ReservationService {
	ReservationDAO reservationDao = new ReservationDAOImpl();
	
	/**
	 * 예약하기
	 * */
	public void insertReservation(ReservationDTO reservaton) throws SQLException{
		int result = reservationDao.reservationInsert(reservaton);
		if(result==0) throw new SQLException("예약하기가 실패했습니다.");
	}
	
	/**
	 * 예약내역보기
	 * */
	public List<ReservationDTO> selctReservationByMemberId(String memberId) throws SQLException{
		List<ReservationDTO> list = reservationDao.selectReservationByMemberId(memberId);
		if(list==null || list.size()==0) throw new SQLException(memberId+"의 예약내역이 없습니다.");
		return list;
	}

	/**
	 * 예약하기
	 * */
	public void InputReservationOption(String regDate, String visitAge, int ticketQty)throws SQLException {

		
	}
}