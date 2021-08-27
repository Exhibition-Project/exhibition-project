package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.Service.ReservationService;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ReservationController {
	static ReservationService reservationService = new ReservationService();
	
	/**
	 * �����ϱ�
	 * */
	public static void insertReservation(ReservationDTO reservation) {
		try {
			reservationService.insertReservation(reservation);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
			
	/**
	 * ���೻������
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
	 * ����ȸ ����(����ȸ ��ȣ �Է�)
	 * (EndView���� ���� ���� ��¥ ����� InputReservationOption ȣ��)
	 * */
	public static void InputReservationOption(int exhibitionNo) {
		try {
			EndView.printAvailableDate(null, null);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}


}
