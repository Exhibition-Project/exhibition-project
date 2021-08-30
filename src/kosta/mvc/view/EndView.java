package kosta.mvc.view;

import java.util.List;
import java.util.Map;

import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.dto.StatisticsDTO;
import kosta.mvc.model.service.ExhibitionService;

public class EndView {
	
	/**
	 * 메시지 출력
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * 회원정보 출력
	 */
	public static void printMemberInformation(MemberDTO memberDTO) {
		System.out.println(memberDTO.toString());
	}
	
	/**
	 * 전시회 리스트 출력
	 * */
	public static void printExhibitionList(List<ExhibitionDTO> exhibitionList) {
		for(ExhibitionDTO exhibitionDTO : exhibitionList) {
			System.out.println(exhibitionDTO);
		}
	}
	
	
	/**
	 * 전시회번호에 해당하는 전시회정보 출력 
	 * */
	public static void selectByExhibitionxNo(ExhibitionDTO exhibitionDTO) {
//		System.out.println("selectByExhibitionxNo");
		System.out.println(exhibitionDTO);
	}
	
	/**
	 * 예매 가능 날짜 출력
	 * */
	public static void printAvailableDate(String startDate, String endDate) {
		System.out.println("예매가능한 날짜는" + startDate + "부터" + endDate + "까지입니다.");
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
		System.out.println("후기 게시물이" + reviewList.size() + "개 검색되었습니다.");
		System.out.println("------------------------");
		for(ReviewDTO dto : reviewList) {
			System.out.println("전시회 번호 : "+ dto.getExhibitionNo() + " | 전시회 이름 : "+ dto.getExhibitionName()+ "| 후기 내용:" + dto.getReviewContnet() + "| 별점" + dto.getStars());
		}
		System.out.println();
	}
	
	/**
	 * 후기 출력
	 * */
	public static void printReviewByNo(ReviewDTO reviewDTO) {
		System.out.println(reviewDTO + "\n");
	}
	
	/**
	 * 후기와 전시회 리스트 동시 출력
	 * */
	public static void printReAndEx(List<ReviewDTO> reviewList, ExhibitionDTO exhibitionDTO) {
		System.out.println("후기 게시물이" + reviewList.size() + "개 검색되었습니다.");
		System.out.println("------------------------");
		for(ReviewDTO dto : reviewList) {
			System.out.println(dto);
		}
		
		System.out.println("\n 후기에 해당하는 전시회 정보------------↓");
		System.out.println(exhibitionDTO + "\n");
	}
	
	/**
	 * 예매 통계 출력
	 * */
	public static void printStatistics(StatisticsDTO statisticsDTO) {
		
	}


}
