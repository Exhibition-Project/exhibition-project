package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.Service.ReservationService;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ReservationController {
	static ReservationService reservationService = new ReservationService();
	
	/**
	 * 예약하기
	 * */
	public static void insertReservation(ReservationDTO reservation) {
		try {
			reservationService.insertReservation(reservation);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
			
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


}
