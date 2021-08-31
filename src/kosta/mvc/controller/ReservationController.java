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
	 * 전시회 예매(전시회 번호 입력)
	 * (EndView에서 예매 가능 날짜 출력후 InputReservationOption 호출)
	 * */
	public static void inputinsertReservation(int exhibitionNo) {
		try {
			ExhibitionDTO exhibition = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			EndView.printAvailableDate(exhibition.getStartDate(), exhibition.getEndDate());//예매가능한 날짜 출력
			MenuView.inputReservationOption(exhibitionNo);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 예매하기 (날짜, 관람 연령, 티켓 수량 입력)
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
	 * 로그인 한 멤버에 맞는 예매내역보기
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
	 * 예매내역 전체 검색
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
	 * 예매번호로 조회 
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
