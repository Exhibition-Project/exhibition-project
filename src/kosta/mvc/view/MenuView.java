package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.ReservationController;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * �ʱ�ȭ��
	 * �α���, ȸ������
	 * */
	public static void menu() {
		
	}
	
	/**
	 * ȸ������
	 * */
	public static void InputInsertMember() {
		
	}
	
	/**
	 * �α���
	 * */
	public static void login() {
		
	}
	
	/**
	 * �α׾ƿ�
	 * */
	public static void logout() {
		
	}
	
	//ȸ�� �޴�/////////////////////////////////////////////////////////////////////////
	
	/**
	 * ȸ�� ���θ޴�
	 * ����������, ����ȸ��ȸ, ����ȸ ����, �ı� ��ȸ, �α׾ƿ�
	 * */
	public static void printMemberMenu() {
		
	}
	
	//����������
	/**
	 * ���������� �޴�
	 * ����������, �� ���ų��� ��ȸ(���� �Լ� X), �� �ı����
	 * */
	public static void printMyPage() {
		
	}
	
	/**
	 * ����������
	 * */
	public static void inputUpdateMember() {
		
	}

	/**
	 * ���������� �� �ı���� �޴�
	 * �� �ı� ��ȸ(���� �Լ� X), ���, ����
	 * */
	public static void printMemberReviewMenu() {
		
	}
	
	/**
	 * �ı� ���
	 * */
	public static void InputInsertReview() {
		
	}
	
	/**
	 * �ı� ����
	 * */
	public static void InputDeleteReview() {
		
	}
	
	
	//����ȸ ��ȸ	
	
	/**
	 * ����ȸ ��ȸ �޴�
	 * ��ü��ȸ(���� �Լ� X), ��¥�� ��ȸ
	 * */
	public static void printExhibitionMenu() {
		
	}
	
	/**
	 * ��¥�� ����ȸ ��ȸ(��¥ �Է�)
	 * */
	public static void InputExhibitionByDate() {
		
	}
	
	
	//����ȸ ����
	
	/**
	 * ����ȸ ����(����ȸ ��ȣ �Է�)
	 * (EndView���� ���� ���� ��¥ ����� InputReservationOption ȣ��)
	 * */
	public static void InputInsertReservation() {
		System.out.print("������ ����ȸ ��ȣ�� �Է����ּ��� : ");
		int exhibitionNo = Integer.parseInt(sc.nextLine());
		
		ReservationController.InputReservationOption(exhibitionNo);
	}
	
	/**
	 * �����ϱ� (��¥, ���� ����, Ƽ�� ���� �Է�)
	 * */
	public static void InputReservationOption(String memberId) {
		 System.out.print("������ ��¥�� �Է��ϼ��� : ");
		 int reg_date = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("���� ������ �Է����ּ��� : ");
		 String visitAge = sc.nextLine();
		 
		 System.out.print("������ Ƽ�� ������ �Է����ּ��� : ");
		 int ticket_qty = Integer.parseInt(sc.nextLine());
		 
		 ReservationController.insertReservation(reg_date, visitAge, ticket_qty);
		
	}
	
	
	//�ı� ��ȸ
	
	/**
	 * �ı� ��ȸ(����ȸ ��ȣ �Է�)
	 * */
	public static void InputReViewByNo() {
		
	}
	
	
	
	//������ �޴�/////////////////////////////////////////////////////////////////////////	
	/**
	 * ������ ���θ޴�
	 * ����ȸ ����, �ı����, ���� ���, ���� ���� ��ȸ
	 * */
	public static void printAdminMenu() {
		
	}
	
	
	//����ȸ ����
	
	/**
	 * ����ȸ �����޴�
	 * ����ȸ ��ȸ(ȸ�� �޼ҵ�� ����), ���, ����, ����
	 * */
	public static void printExhibitionManagementMenu() {
		
	}
	
	/**
	 * ����ȸ ���
	 * */
	public static void InputInsertExhibition() {
		
	}
	
	/**
	 * ����ȸ ����
	 * */
	public static void InputUpdateExhibition() {
		
	}
	
	/**
	 * ����ȸ ����
	 * */
	public static void InputDeleteExhibition() {
		
	}
	
	
	//������ �ı����
	
	/**
	 * ������ �ı���� �޴�
	 * �ı� ��ȸ(ȸ�� �޼ҵ�� ����), �ı� ����(ȸ�� �޼ҵ�� ����)
	 * */
	public static void printAdminReviewMenu() {
		
	}
	
	
	//���� ���
	
	/**
	 * ���� ���(����ȸ ��ȣ �Է�)
	 * */
	public static void InputStatisticsByNo() {
		
	}
	
	
	//���ų�����ȸ
	/**
	 * ���ų�����ȸ �޴�
	 * ��ü��ȸ, ���� ��ȣ�� ��ȸ
	 * */
	public static void printReservationHistoryMenu() {
		
	}
	
	/**
	 * ���Ź�ȣ�� ��ȸ
	 * */
	public static void InputReservationByNo() {
		
	}
	
}
