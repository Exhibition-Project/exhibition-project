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
	 * �޽��� ���
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * ȸ������ ���
	 */
	public static void printMemberInformation(MemberDTO memberDTO) {
		System.out.println(memberDTO.toString());
	}
	
	/**
	 * ����ȸ ����Ʈ ���
	 * */
	public static void printExhibitionList(List<ExhibitionDTO> exhibitionList) {
		for(ExhibitionDTO exhibitionDTO : exhibitionList) {
			System.out.println(exhibitionDTO.toString());
		}
	}
	
	/**
	 * ����ȸ ����Ʈ ������ ���
	 * */
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
	 * */
	public static void selectByExhibitionxNo(ExhibitionDTO exhibitionDTO) {
		System.out.println(exhibitionDTO);
	}
	
	/**
	 * ���� ���� ��¥ ���
	 * */
	public static void printAvailableDate(String startDate, String endDate) {
		System.out.println("���Ű����� ��¥��" + startDate + " ���� " + endDate + "�����Դϴ�.");//����ϰ� �����ֱ� �ʿ���
	}
	
	/**
	 * ��ü ���� ���� ����Ʈ ���
	 * */
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
	 * ���Ź�ȣ�� ��ȸ 
	 * */
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
	 * */
	public static void printReservaionByMemberId(List<ReservationDTO> reservationList) {
		for(ReservationDTO reservaion : reservationList) {
			System.out.println(reservaion.getReservationNo()+ " | " + reservaion.getMemberNo()+ " | " + reservaion.getTotalAmount()+ " | " + reservaion.getRegDate());
			for(ReservationLineDTO reservationLine : reservaion.getReservationLineList()) {
				System.out.println("  �����Ż󼼳��� "+reservationLine);
			}
			System.out.println();
		}
	}
	/**
	 * �ı� ����Ʈ ���(�����ϰ� �ı� ����Ʈ�� �������, ����ȸ ����Ʈ�� �޾Ƽ� ����ȸ�� �ı� ���� �������?)
	 * */
	public static void printReviewList(List<ReviewDTO> reviewList) {
		System.out.println("�ı� �Խù���" + reviewList.size() + "�� �˻��Ǿ����ϴ�.");
		System.out.println("-------------------------------------------------------------------------------");
		for(ReviewDTO dto : reviewList) {
			System.out.println("����ȸ ��ȣ : "+ dto.getExhibitionNo() + " | ����ȸ �̸� : "+ dto.getExhibitionName()+ "| �ı� ����:" + dto.getReviewContnet() + "| ����" + dto.getStars());
		}
		System.out.println();
	}
	
	/**
	 * �ı� ���
	 * */
	public static void printReviewByNo(ReviewDTO reviewDTO) {
		System.out.println(reviewDTO + "\n");
	}
	
	/**
	 * �ı�� ����ȸ ����Ʈ ���� ���
	 * */
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
	 * */
	public static void printStatistics(ExhibitionDTO exhibitionDTO) {
		System.out.println(exhibitionDTO);
		for(StatisticsDTO statisticsDTO : exhibitionDTO.getStatisticsList()) {
			System.out.println(statisticsDTO);
		}
	}

}
