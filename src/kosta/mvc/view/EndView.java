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
	 * �޼��� ���
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	

	/**
	 * ȸ������ ���
	 * @param memberDTO
	 */
	public static void printMemberInformation(MemberDTO memberDTO) {
		System.out.println(memberDTO.toString());
	}
	
	/**
	 * ����ȸ ����Ʈ ���
	 * @param exhibitionList
	 */
	public static void printExhibitionList(List<ExhibitionDTO> exhibitionList) {
		for(ExhibitionDTO exhibitionDTO : exhibitionList) {
			System.out.println(exhibitionDTO.toString());
		}
	}
	
	/**
	 * ����ȸ ����Ʈ ������ ���
	 * @param exhibitionList
	 */
	public static void printExhibitionListbyStars(List<ExhibitionDTO> exhibitionList) {
		for(ExhibitionDTO exhibitionDTO : exhibitionList) {
			System.out.print(exhibitionDTO);
			if(exhibitionDTO.getAvgStars() >= 0) {
				System.out.print(", ��� ���� : " + exhibitionDTO.getAvgStars());				
			}
			System.out.println();
		}
	}
	
	/**
	 * ����ȸ��ȣ�� �ش��ϴ� ����ȸ���� ��� 
	 * @param exhibitionDTO
	 */
	public static void selectByExhibitionxNo(ExhibitionDTO exhibitionDTO) {
		System.out.println(exhibitionDTO);
	}
	
	/**
	 * ���� ���� ��¥ ���
	 * @param startDate
	 * @param endDate
	 */
	public static void printAvailableDate(String startDate, String endDate) {
		System.out.println("���Ű����� ��¥��" + startDate + " ���� " + endDate + "�����Դϴ�.");//����ϰ� �����ֱ� �ʿ���
	}
	
	/**
	 * ��ü ���� ���� ����Ʈ ���
	 * @param reservationList
	 */
	public static void printReservationList(List<ReservationDTO> reservationList) {
		System.out.println("���ų��� �� " + reservationList.size() + " �� �˻��Ǿ����ϴ�.");
		System.out.println("------------------------");
		for(ReservationDTO reservation : reservationList) {
			System.out.println("���Ź�ȣ"+ reservation.getReservationNo() + " | ȸ����ȣ : "+ reservation.getMemberNo()+ "| ����ȸ��ȣ : " + reservation.getExhibitionNo() + 
					"| �ѱ��űݾ� : " + reservation.getTotalAmount() + "| ���ų�¥ : " + reservation.getRegDate());
		}
		System.out.println();
	}

	/**
	 * ���Ź�ȣ�� ���ų�����ȸ 
	 * @param reservationLineList
	 */
	public static void printReservationByNo(List<ReservationLineDTO> reservationLineList) {
		System.out.println("���ų��� �� " + reservationLineList.size() + " �� �˻��Ǿ����ϴ�.");
		System.out.println("------------------------");
		for(ReservationLineDTO reservationLine : reservationLineList) {
			System.out.println("���Ż��ڵ� : "+ reservationLine.getReservationNo() + " | ���Ź�ȣ : "+ reservationLine.getReservationNo()+ " | �������� : " + reservationLine.getVisitAge() + 
					" | Ƽ�ϼ��� : " + reservationLine.getTicketQty() + " | �ѱݾ� : " + reservationLine.getAmount());
		}
		System.out.println();
	}
	
	/**
	 * ���� ���� ����Ʈ ���
	 * @param reservationList
	 */
	public static void printReservaionByMemberNo(List<ReservationDTO> reservationList) {
		for(ReservationDTO reservaion : reservationList) {
			System.out.println(reservaion.getReservationNo()+ " | " + reservaion.getMemberNo()+ " | " + reservaion.getTotalAmount()+ " | " + reservaion.getRegDate());
			for(ReservationLineDTO reservationLine : reservaion.getReservationLineList()) {
				System.out.println("  �����Ż󼼳��� "+reservationLine);
			}
			System.out.println();
		}
	}

	/**
	 * �ı� ����Ʈ ���
	 * @param reviewList
	 */
	public static void printReviewList(List<ReviewDTO> reviewList) {
		System.out.println("�ı� �Խù���" + reviewList.size() + "�� �˻��Ǿ����ϴ�.");
		System.out.println("-------------------------------------------------------------------------------");
		for(ReviewDTO dto : reviewList) {
			System.out.println("�ı� ��ȣ : "+dto.getReviewNo()+" | ����ȸ ��ȣ : "+ dto.getExhibitionNo() + " | ����ȸ �̸� : "+ dto.getExhibitionName()+ "| �ı� ����:" + dto.getReviewContnet() + "| ����" + dto.getStars());
		}
		System.out.println();
	}
	
	/**
	 * �ı� ���
	 * @param reviewDTO
	 */
	public static void printReviewByNo(ReviewDTO reviewDTO) {
		System.out.println(reviewDTO + "\n");
	}
	
	/**
	 * �ı�� ����ȸ ����Ʈ ���� ���
	 * @param reviewList
	 * @param exhibitionDTO
	 */
	public static void printReAndEx(List<ReviewDTO> reviewList, ExhibitionDTO exhibitionDTO) {
		System.out.println("�ı� �Խù���" + reviewList.size() + "�� �˻��Ǿ����ϴ�.");
		System.out.println("------------------------");
		for(ReviewDTO dto : reviewList) {
			System.out.println(dto);
		}
		
		System.out.println("\n �ı⿡ �ش��ϴ� ����ȸ ����------------��");
		System.out.println(exhibitionDTO + "\n");
	}
	
	/**
	 * ���� ��� ���
	 * @param exhibitionDTO
	 */
	public static void printStatistics(ExhibitionDTO exhibitionDTO) {
		if(exhibitionDTO.getExhibitionName() != null) {
			System.out.println(exhibitionDTO);			
		}
		for(StatisticsDTO statisticsDTO : exhibitionDTO.getStatisticsList()) {
			System.out.println(statisticsDTO);
		}
		System.out.println("�Ⱓ �� �� �湮�� �� : " + exhibitionDTO.getStatisticsSummary().getTotalVisitors() + " ��");
		System.out.println("�Ⱓ �� �� ���� ���ͱ� : " + exhibitionDTO.getStatisticsSummary().getTotalProfits() + " ��");
	}
}
