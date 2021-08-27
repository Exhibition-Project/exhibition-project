package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.dto.StatisticsDTO;

public class EndView {
	
	/**
	 * 전시회 리스트 출력
	 * */
	public static void printExhibitionList(List<ExhibitionDTO> exhibitionList) {
		
	}
	
	/**
	 * 예매 가능 날짜 출력
	 * */
	public static void printAvailableDate(String startDate, String EndDate) {
		
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
	 * 후기 리스트 출력(순수하게 후기 리스트만 출력할지, 전시회 리스트를 받아서 전시회랑 후기 같이 출력할지?)
	 * */
	public static void printReviewList(List<ExhibitionDTO> exhibitionList) {
		
	}
	
	/**
	 * 후기 출력
	 * */
	public static void printReviewByNo(ReviewDTO reviewDTO) {
		
	}
	
	/**
	 * 예매 통계 출력
	 * */
	public static void printStatistics(StatisticsDTO statisticsDTO) {
		
	}
}
