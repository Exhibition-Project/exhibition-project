package kosta.mvc.view;

import java.util.List;

import kosta.mvc.Service.ExhibitionService;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.dto.StatisticsDTO;

public class EndView {
	
	/**
	 * 메시지 출력
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * 전시회 리스트 출력
	 * */
	public static void printExhibitionList(List<ExhibitionDTO> exhibitionList) {
		
	}
	
	/**
	 * 예매 가능 날짜 출력
	 * */
	public static void printAvailableDate(String startDate, String EndDate) {
		//전시회 번호에 해당하는 전시회찾기
//		ExhibitionDTO exhibition = ExhibitionService.exhibitionSelectByexhibitionNo(exhibitionNo);
		// 1 전시회이름 2021-06-10 
	}
	
	/**
	 * 예매 내역 리스트 출력
	 * */
	public static void printReservationList(List<ReservationDTO> reservationList) {
		
	}
	
	/**
	 * 예매 내역 출력
	 * */
	public static void printReservationByNo(ReservationDTO reservationDTO) {
		
	}
	
	/**
	 * 예매내역 상세보기
	 * */
	public static void printReservaionByMemberId(List<ReservationDTO> reservationList) {
		for(ReservationDTO reservaion : reservationList) {
			System.out.println(reservaion.getReservationNo()+ " | " + reservaion.getMemberNo()+ " | " + reservaion.getTotalAmount()+ " | " + reservaion.getRegDate());
			for(ReservationLineDTO reservationLine : reservaion.getReservationLineList()) {
				System.out.println("  ▶ "+reservationLine);
			}
			System.out.println();
		}
	}
	/**
	 * 후기 리스트 출력(순수하게 후기 리스트만 출력할지, 전시회 리스트를 받아서 전시회랑 후기 같이 출력할지?)
	 * */
	public static void printReviewList(List<ReviewDTO> reviewList) {
		
	}
	
	/**
	 * 후기 출력
	 * */
	public static void printReviewByNo(ReviewDTO reviewDTO) {
		
	}
	
	/**
	 * 후기와 전시회 리스트 동시 출력
	 * */
	public static void printReAndEx(List<ExhibitionDTO> exhibitionDTO, List<ReviewDTO> reviewDTO) {
		
	}
	
	/**
	 * 예매 통계 출력
	 * */
	public static void printStatistics(StatisticsDTO statisticsDTO) {
		
	}


}
