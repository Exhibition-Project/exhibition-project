package kosta.mvc.controller;

import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.model.service.ReservationService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;

public class ReservationController {
	private static ReservationService reservationService = new ReservationService();
	private static ExhibitionService exhibitionService = new ExhibitionService();

	/**
	 * ���೻������
	 * */
	public static void selectReservationByMemberId() {
		try {
			List<ReservationDTO> reservationList = reservationService.selctReservationByMemberNo();
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
			//1�� ����ȸ��ȣ�� �ش��ϴ� ����ȸ ���ڵ� ã��
			ExhibitionDTO exhibition = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			//1	ī�Կ� ���� �����÷� ������ ���� �׸����� ��Ÿ�� ��	21/06/10	21/10/12	ȸȭ	1000	�Ѱ����̼���
			
//			System.out.println("exDto**** = "+exDto);
			EndView.printAvailableDate(exhibition.getStartDate(), exhibition.getEndDate());//���Ű����� ��¥ ���
			
			MenuView.InputReservationOption(exhibitionNo);

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * �����ϱ� (��¥, ���� ����, Ƽ�� ���� �Է�)
	 * */
	public static void InputReservationOption(ReservationDTO reservation) {
		try {
			reservationService.insertReservation(reservation);
			
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

}
