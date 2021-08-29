package kosta.mvc.controller;

import java.util.Calendar;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.service.ReservationService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ReservationController {
	static ReservationService reservationService = new ReservationService();
			
	/**
	 * 예약내역보기
	 * */
	public static void selectReservationByMemberId(String memberId) {
		try {
			List<ReservationDTO> reservationList = reservationService.selctReservationByMemberId(memberId);
			EndView.printReservaionByMemberId(reservationList);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 전시회 예매(전시회 번호 입력)
	 * (EndView에서 예매 가능 날짜 출력후 InputReservationOption 호출)
	 * */
	public static void InputReservationOption(int exhibitionNo) {
		try {
			EndView.printAvailableDate(null, null);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 예매하기 (날짜, 관람 연령, 티켓 수량 입력)
	 * @param ticket_qty 
	 * @param visitAge 
	 * @param reg_date 
	 * */
	public static void insertReservation(int reg_date, String visitAge, int ticket_qty) {
		try {
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
