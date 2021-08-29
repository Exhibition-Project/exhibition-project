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
	
	/**
	 * �����ϱ� (��¥, ���� ����, Ƽ�� ���� �Է�)
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
