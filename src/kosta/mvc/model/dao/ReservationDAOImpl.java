package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;

public class ReservationDAOImpl implements ReservationDAO{
	
	ReservationDAO reservationDao = new ReservationDAOImpl();
	 
	/**
	 * �����ϱ� 
	 * 	1) ���̺� insert
	 * 	2) order_line���̺� insert
	 * */
	@Override
	public int reservationInsert(ReservationDTO Reservation) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ���೻������
	 * */
	@Override
	public List<ReservationDTO> selctReservationByMemberId(String memberId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���� ���� ���
	 * */
	@Override
	public List<ReservationDTO> printReservationByNo(ReservationDTO reservationDTO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���� �󼼵���ϱ�
	 * */


	/**
	 * ���� �ѱ��űݾ� ���ϱ�
	 * */
	
	/**
	 * �����ȣ�� �ش��ϴ� �ֹ��� ��������
	 * */
	
	
}
