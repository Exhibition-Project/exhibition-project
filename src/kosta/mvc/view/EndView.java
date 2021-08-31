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
	 * 메세지 출력
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	

	/**
	 * 회원정보 출력
	 * @param memberDTO
	 */
	public static void printMemberInformation(MemberDTO memberDTO) {
		System.out.println(memberDTO.toString());
	}
	
	/**
	 * 전시회 리스트 출력
	 * @param exhibitionList
	 */
	public static void printExhibitionList(List<ExhibitionDTO> exhibitionList) {
		for(ExhibitionDTO exhibitionDTO : exhibitionList) {
			System.out.println(exhibitionDTO.toString());
		}
	}
	
	/**
	 * 전시회 리스트 별점순 출력
	 * @param exhibitionList
	 */
	public static void printExhibitionListbyStars(List<ExhibitionDTO> exhibitionList) {
		for(ExhibitionDTO exhibitionDTO : exhibitionList) {
			System.out.print(exhibitionDTO);
			if(exhibitionDTO.getAvgStars() >= 0) {
				System.out.print(", 평균 별점 : " + exhibitionDTO.getAvgStars());				
			}
			System.out.println();
		}
	}
	
	/**
	 * 전시회번호에 해당하는 전시회정보 출력 
	 * @param exhibitionDTO
	 */
	public static void selectByExhibitionxNo(ExhibitionDTO exhibitionDTO) {
		System.out.println(exhibitionDTO);
	}
	
	/**
	 * 예매 가능 날짜 출력
	 * @param startDate
	 * @param endDate
	 */
	public static void printAvailableDate(String startDate, String endDate) {
		System.out.println("예매가능한 날짜는" + startDate + " 부터 " + endDate + "까지입니다.");//깔끔하게 보여주기 필요함
	}
	
	/**
	 * 전체 예매 내역 리스트 출력
	 * @param reservationList
	 */
	public static void printReservationList(List<ReservationDTO> reservationList) {
		System.out.println("예매내역 총 " + reservationList.size() + " 건 검색되었습니다.");
		System.out.println("------------------------");
		for(ReservationDTO reservation : reservationList) {
			System.out.println("예매번호"+ reservation.getReservationNo() + " | 회원번호 : "+ reservation.getMemberNo()+ "| 전시회번호 : " + reservation.getExhibitionNo() + 
					"| 총구매금액 : " + reservation.getTotalAmount() + "| 예매날짜 : " + reservation.getRegDate());
		}
		System.out.println();
	}

	/**
	 * 예매번호로 예매내역조회 
	 * @param reservationLineList
	 */
	public static void printReservationByNo(List<ReservationLineDTO> reservationLineList) {
		System.out.println("예매내역 총 " + reservationLineList.size() + " 건 검색되었습니다.");
		System.out.println("------------------------");
		for(ReservationLineDTO reservationLine : reservationLineList) {
			System.out.println("예매상세코드 : "+ reservationLine.getReservationNo() + " | 예매번호 : "+ reservationLine.getReservationNo()+ " | 관람연령 : " + reservationLine.getVisitAge() + 
					" | 티켓수량 : " + reservationLine.getTicketQty() + " | 총금액 : " + reservationLine.getAmount());
		}
		System.out.println();
	}
	
	/**
	 * 예매 내역 리스트 출력
	 * @param reservationList
	 */
	public static void printReservaionByMemberNo(List<ReservationDTO> reservationList) {
		for(ReservationDTO reservaion : reservationList) {
			System.out.println(reservaion.getReservationNo()+ " | " + reservaion.getMemberNo()+ " | " + reservaion.getTotalAmount()+ " | " + reservaion.getRegDate());
			for(ReservationLineDTO reservationLine : reservaion.getReservationLineList()) {
				System.out.println("  ▶예매상세내역 "+reservationLine);
			}
			System.out.println();
		}
	}

	/**
	 * 후기 리스트 출력
	 * @param reviewList
	 */
	public static void printReviewList(List<ReviewDTO> reviewList) {
		System.out.println("후기 게시물이" + reviewList.size() + "개 검색되었습니다.");
		System.out.println("-------------------------------------------------------------------------------");
		for(ReviewDTO dto : reviewList) {
			System.out.println("후기 번호 : "+dto.getReviewNo()+" | 전시회 번호 : "+ dto.getExhibitionNo() + " | 전시회 이름 : "+ dto.getExhibitionName()+ "| 후기 내용:" + dto.getReviewContnet() + "| 별점" + dto.getStars());
		}
		System.out.println();
	}
	
	/**
	 * 후기 출력
	 * @param reviewDTO
	 */
	public static void printReviewByNo(ReviewDTO reviewDTO) {
		System.out.println(reviewDTO + "\n");
	}
	
	/**
	 * 후기와 전시회 리스트 동시 출력
	 * @param reviewList
	 * @param exhibitionDTO
	 */
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
	 * @param exhibitionDTO
	 */
	public static void printStatistics(ExhibitionDTO exhibitionDTO) {
		if(exhibitionDTO.getExhibitionName() != null) {
			System.out.println(exhibitionDTO);			
		}
		for(StatisticsDTO statisticsDTO : exhibitionDTO.getStatisticsList()) {
			System.out.println(statisticsDTO);
		}
		System.out.println("기간 내 총 방문자 수 : " + exhibitionDTO.getStatisticsSummary().getTotalVisitors() + " 명");
		System.out.println("기간 내 총 예매 수익금 : " + exhibitionDTO.getStatisticsSummary().getTotalProfits() + " 원");
	}
}
