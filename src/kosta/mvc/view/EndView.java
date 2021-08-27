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
	 * �޽��� ���
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * ����ȸ ����Ʈ ���
	 * */
	public static void printExhibitionList(List<ExhibitionDTO> exhibitionList) {
		
	}
	
	/**
	 * ���� ���� ��¥ ���
	 * */
	public static void printAvailableDate(String startDate, String EndDate) {
		//����ȸ ��ȣ�� �ش��ϴ� ����ȸã��
//		ExhibitionDTO exhibition = ExhibitionService.exhibitionSelectByexhibitionNo(exhibitionNo);
		// 1 ����ȸ�̸� 2021-06-10 
	}
	
	/**
	 * ���� ���� ����Ʈ ���
	 * */
	public static void printReservationList(List<ReservationDTO> reservationList) {
		
	}
	
	/**
	 * ���� ���� ���
	 * */
	public static void printReservationByNo(ReservationDTO reservationDTO) {
		
	}
	
	/**
	 * ���ų��� �󼼺���
	 * */
	public static void printReservaionByMemberId(List<ReservationDTO> reservationList) {
		for(ReservationDTO reservaion : reservationList) {
			System.out.println(reservaion.getReservationNo()+ " | " + reservaion.getMemberNo()+ " | " + reservaion.getTotalAmount()+ " | " + reservaion.getRegDate());
			for(ReservationLineDTO reservationLine : reservaion.getReservationLineList()) {
				System.out.println("  �� "+reservationLine);
			}
			System.out.println();
		}
	}
	/**
	 * �ı� ����Ʈ ���(�����ϰ� �ı� ����Ʈ�� �������, ����ȸ ����Ʈ�� �޾Ƽ� ����ȸ�� �ı� ���� �������?)
	 * */
	public static void printReviewList(List<ReviewDTO> reviewList) {
		
	}
	
	/**
	 * �ı� ���
	 * */
	public static void printReviewByNo(ReviewDTO reviewDTO) {
		
	}
	
	/**
	 * �ı�� ����ȸ ����Ʈ ���� ���
	 * */
	public static void printReAndEx(List<ExhibitionDTO> exhibitionDTO, List<ReviewDTO> reviewDTO) {
		
	}
	
	/**
	 * ���� ��� ���
	 * */
	public static void printStatistics(StatisticsDTO statisticsDTO) {
		
	}


}
