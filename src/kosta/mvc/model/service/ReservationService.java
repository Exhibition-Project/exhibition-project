package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReservationDAO;
import kosta.mvc.model.dao.ReservationDAOImpl;
import kosta.mvc.model.dto.ReservationDTO;

public class ReservationService {
	ReservationDAO reservationDao = new ReservationDAOImpl();
	
	/**
	 * �����ϱ�
	 * */
	public void insertReservation(ReservationDTO reservaton) throws SQLException{
		int result = reservationDao.reservationInsert(reservaton);
		if(result==0) throw new SQLException("�����ϱⰡ �����߽��ϴ�.");
	}
	
	/**
	 * ���೻������
	 * */
	public List<ReservationDTO> selctReservationByMemberId(String memberId) throws SQLException{
		List<ReservationDTO> list = reservationDao.selectReservationByMemberId(memberId);
		if(list==null || list.size()==0) throw new SQLException(memberId+"�� ���೻���� �����ϴ�.");
		return list;
	}

	/**
	 * �����ϱ�
	 * */
	public void InputReservationOption(String regDate, String visitAge, int ticketQty)throws SQLException {

		
	}
}