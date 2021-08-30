package kosta.mvc.controller;

import java.util.Calendar;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.model.service.ReservationService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class ReservationController {
	private static ReservationService reservationService = new ReservationService();
	private static ExhibitionService exhibitionService = new ExhibitionService();

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
	public static void InputinsertReservation(int exhibitionNo) {
		try {
			//3�� ����ȸ��ȣ�� �ش��ϴ� ����ȸ ���ڵ� ã��
//			ExhibitionDTO exDto = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			//3	�� 55ȸ �ѱ��̼���ȸ��	21/09/09	21/09/17	ȸȭ	1000	�Ѱ����̼���
			System.out.println(exhibitionNo);
//			EndView.printAvailableDate(exDto.getStartDate(), exDto.getEndDate());//���Ű����� ��¥ ���
//			gitignore �׽�Ʈ
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * �����ϱ� (��¥, ���� ����, Ƽ�� ���� �Է�)
	 * */
	public static void InputReservationOption(String regDate, String visitAge, int ticketQty) {
		try {
			reservationService.InputReservationOption(regDate, visitAge, ticketQty);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
