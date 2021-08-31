package kosta.mvc.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			sdf.setLenient(false); // �Է��� ���� ������ ���İ� �ٸ��� ���� 
			sdf.parse(reservation.getRegDate());
			reservationService.insertReservation(reservation);
			EndView.printMessage("���ſ� �����Ͽ����ϴ�.");
		} catch (ParseException pe) {
			FailView.errorMessage("\n �����Ͻ� ��¥�� yy-MM-dd �������θ� �Է� �����մϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �α��� �� ����� �´� ���ų�������
	 * */
	public static void selectReservationByMemberNo() {
		try {
			List<ReservationDTO> reservationList = reservationService.selctReservationByMemberNo();
			EndView.printReservaionByMemberNo(reservationList);
		} catch (Exception e) {
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
	
	/**
	 * ���Ź�ȣ�� �������(����)
	 * */
	public static void reservationDelete(int reservationNo) {
		try {
			reservationService.reservationDelete(reservationNo);
			EndView.printMessage("���Ű� ��ҵǾ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}



}
