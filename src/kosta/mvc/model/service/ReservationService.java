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
	 * 예약하기
	 * */
	public void insertReservation(ReservationDTO reservaton) throws SQLException{
		int memberNo =memberService.getSessionNo();
		System.out.println("memberNo = " + memberNo);
		
		reservaton.setMemberNo(memberNo);
		
		int result = reservationDao.reservationInsert(reservaton);
		if(result==0) throw new SQLException("예약하기가 실패했습니다.");
	}
	
	/**
	 * 로그인 한 멤버에 맞는 예매내역보기
	 * */
	public List<ReservationDTO> selctReservationByMemberNo() throws SQLException{
		int memberNo =memberService.getSessionNo();
		
		List<ReservationDTO> list = reservationDao.selectReservationByMemberNo(memberNo);
		if(list==null || list.size()==0) throw new SQLException(memberNo+"의 예약내역이 없습니다.");
		return list;
	}
	
	/**
	 * 전시회 번호로 예매내역 검색
	 * */
	public List<ReservationDTO> reservationSelectAll() throws SQLException{
		List<ReservationDTO> reservationList = reservationDao.reservationSelectAll();
		if(reservationList.size()==0 || reservationList == null) throw new SQLException("현재 찾고있는 예매내역이 존재하지 않습니다.");
		return reservationList;
	}	
	
	/**
	 * 예매번호로 조회 
	 * */
	public List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException{
		List<ReservationLineDTO> reservationLine  = reservationDao.selectByReservationNo(reservationNo);
		if(reservationLine == null || reservationLine.isEmpty()) {
			throw new SQLException(reservationNo + "번호에 해당하는 예매내역이 존재하지 않습니다.");
		}
		return reservationLine;
	}



}