package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.model.service.ReservationService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;

public class ReservationController {
	private static ReservationService reservationService = new ReservationService();
	private static ExhibitionService exhibitionService = new ExhibitionService();


	/**
	 * ����ȸ ����(����ȸ ��ȣ �Է�)
	 * (EndView���� ���� ���� ��¥ ����� InputReservationOption ȣ��)
	 * */
	public static void inputinsertReservation(int exhibitionNo) {
		try {
			ExhibitionDTO exhibition = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			EndView.printAvailableDate(exhibition.getStartDate(), exhibition.getEndDate());//���Ű����� ��¥ ���
			MenuView.inputReservationOption(exhibitionNo);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �����ϱ� (��¥, ���� ����, Ƽ�� ���� �Է�)
	 * */
	public static void inputReservationOption(ReservationDTO reservation) {
		try {
			reservationService.insertReservation(reservation);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �α��� �� ����� �´� ���ų�������
	 * */
	public static void selectReservationByMemberId() {
		try {
			List<ReservationDTO> reservationList = reservationService.selctReservationByMemberNo();
			EndView.printReservaionByMemberId(reservationList);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	

	/**
	 * ���ų��� ��ü �˻�
	 * */
	public static void reservationSelectAll() {
		try {
			List<ReservationDTO> reservationList = reservationService.reservationSelectAll();
			EndView.printReservationList(reservationList);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���Ź�ȣ�� ��ȸ 
	 * */
	public static void selectByReservationNo(int reservationNo) {
		try {
			List<ReservationLineDTO> reservationLine = reservationService.selectByReservationNo(reservationNo);
			EndView.printReservationByNo(reservationLine);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	


}
