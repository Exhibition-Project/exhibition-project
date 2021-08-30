package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReservationDAO;
import kosta.mvc.model.dao.ReservationDAOImpl;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;

public class ReservationService {
	ReservationDAO reservationDao = new ReservationDAOImpl();
	MemberService memberService = new MemberService();
	
	/**
	 * �����ϱ�
	 * */
	public void insertReservation(ReservationDTO reservaton) throws SQLException{
		int memberNo =memberService.getSessionNo();
		System.out.println("memberNo = " + memberNo);
		
		reservaton.setMemberNo(memberNo);
		
		int result = reservationDao.reservationInsert(reservaton);
		if(result==0) throw new SQLException("�����ϱⰡ �����߽��ϴ�.");
	}
	
	/**
	 * �α��� �� ����� �´� ���ų�������
	 * */
	public List<ReservationDTO> selctReservationByMemberNo() throws SQLException{
		int memberNo =memberService.getSessionNo();
		
		List<ReservationDTO> list = reservationDao.selectReservationByMemberNo(memberNo);
		if(list==null || list.size()==0) throw new SQLException(memberNo+"�� ���೻���� �����ϴ�.");
		return list;
	}
	
	/**
	 * ����ȸ ��ȣ�� ���ų��� �˻�
	 * */
	public List<ReservationDTO> reservationSelectAll() throws SQLException{
		List<ReservationDTO> reservationList = reservationDao.reservationSelectAll();
		if(reservationList.size()==0 || reservationList == null) throw new SQLException("���� ã���ִ� ���ų����� �������� �ʽ��ϴ�.");
		return reservationList;
	}	
	
	/**
	 * ���Ź�ȣ�� ��ȸ 
	 * */
	public List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException{
		List<ReservationLineDTO> reservationLine  = reservationDao.selectByReservationNo(reservationNo);
		if(reservationLine == null || reservationLine.isEmpty()) {
			throw new SQLException(reservationNo + "��ȣ�� �ش��ϴ� ���ų����� �������� �ʽ��ϴ�.");
		}
		return reservationLine;
	}



}