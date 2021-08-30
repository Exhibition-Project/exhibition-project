package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.ReservationDAO;
import kosta.mvc.model.dao.ReservationDAOImpl;
import kosta.mvc.model.dto.ReservationDTO;

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
	 * ���೻������
	 * */
	public List<ReservationDTO> selectReservationByMemberNo() throws SQLException{
		int memberNo =memberService.getSessionNo();
		
		List<ReservationDTO> list = reservationDao.selectReservationByMemberNo(memberNo);
		if(list==null || list.size()==0) throw new SQLException(memberNo+"�� ���೻���� �����ϴ�.");
		return list;
	}

		
}