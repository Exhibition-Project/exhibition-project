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
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			sdf.setLenient(false); // 입력한 값이 설정한 형식과 다르면 오류 
			sdf.parse(reservation.getRegDate());
			reservationService.insertReservation(reservation);
			EndView.printMessage("예매에 성공하였습니다.");
		} catch (ParseException pe) {
			FailView.errorMessage("\n 관람하실 날짜는 yy-MM-dd 형식으로만 입력 가능합니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 로그인 한 멤버에 맞는 예매내역보기
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
	
	/**
	 * 예매번호로 예매취소(삭제)
	 * */
	public static void reservationDelete(int reservationNo) {
		try {
			reservationService.reservationDelete(reservationNo);
			EndView.printMessage("예매가 취소되었습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}



}
