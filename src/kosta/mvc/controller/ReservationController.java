package kosta.mvc.controller;

import java.util.Calendar;
import java.util.List;

import jdk.internal.org.jline.reader.impl.history.DefaultHistory;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.service.ExhibitionService;
import kosta.mvc.model.service.ReservationService;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;
import sun.security.pkcs11.wrapper.CK_SESSION_INFO;

public class ReservationController {
	private static ReservationService reservationService = new ReservationService();
	private static ExhibitionService exhibitionService = new ExhibitionService();

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
	public static void InputinsertReservation(int exhibitionNo ) {
		try {
			//1번 전시회번호에 해당하는 전시회 레코드 찾기
			ExhibitionDTO exhibition = exhibitionService.selectByExhibitionxNo(exhibitionNo);
			//1	카게에 거장 후지시로 세이지 빛과 그림자의 판타지 전	21/06/10	21/10/12	회화	1000	한가람미술관
			
//			System.out.println("exDto**** = "+exDto);
			EndView.printAvailableDate(exhibition.getStartDate(), exhibition.getEndDate());//예매가능한 날짜 출력
			
			MenuView.InputReservationOption(exhibitionNo);

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 예매하기 (날짜, 관람 연령, 티켓 수량 입력)
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
