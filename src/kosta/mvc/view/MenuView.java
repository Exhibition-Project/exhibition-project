package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.ExhibitionController;
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
		while(true) {
			System.out.println("1. �α���  2. ȸ������  9. ������");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					login();
					break;
				case 2:
					logout();
					break;
				case 3:
					System.exit(1);
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}
		}
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
	 * ����������, ����ȸ ����, �ı� ��ȸ, �α׾ƿ�
	 * */
	public static void printMemberMenu(String memberId) {
		while(true) {
			System.out.println("1. ���������� 2. ����ȸ����  3. �ı���ȸ  9. �α׾ƿ�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				
				case 1:
					printMyPage(memberId);
					break;
				case 2:
					InputInsertReservation(memberId);
					break;
				case 3:
					InputReViewByNo();
					break;
				case 9:
					logout();
					return;
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}
		}
	}
	
	//����������
	/**
	 * ���������� �޴�
	 * ����������, �� ���ų��� ��ȸ(���� �Լ� X), �� �ı����
	 * */
	public static void printMyPage(String memberId) {
		while(true) {
			System.out.println("1. ����������  2. �� ���ų��� ��ȸ  3. �� �ı����  9. �����޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						inputUpdateMember(memberId);
						break;
					case 2:
						//���ִ� �� �ڸ����� �������� ��ȸ ��Ʈ�ѷ� �ٷ� ȣ���Ͻø� �˴ϴ�.
						break;
					case 3:
						printMemberReviewMenu(memberId);
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}			
		}
	}
	
	/**
	 * ����������
	 * */
	public static void inputUpdateMember(String memberId) {
		
	}

	/**
	 * ���������� �� �ı���� �޴�
	 * �� �ı� ��ȸ(���� �Լ� X), ���, ����
	 * */
	public static void printMemberReviewMenu(String memberId) {
		while(true) {
			System.out.println("1. �� �ı� ��ȸ  2. �ı� ���  3.�ı� ����  9. ���� �޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						//���⼭ �ٷ� �ı� ��ȸ�ϴ� ��Ʈ�ѷ� ȣ��
						break;
					case 2:
						InputInsertReview(memberId);
						break;
					case 3:
						InputDeleteReview(memberId);
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}			
		}
	}
	
	/**
	 * �ı� ���
	 * */
	public static void InputInsertReview(String memberId) {
		
	}
	
	/**
	 * �ı� ����
	 * */
	public static void InputDeleteReview(String memberId) {
		
	}
	
	
	//����ȸ ��ȸ	
	
	/**
	 * ����ȸ ��ȸ �޴�
	 * ��ü��ȸ(���� �Լ� X), ��¥�� ��ȸ
	 * */
	public static void printExhibitionMenu() {
		while(true) {
			System.out.println("1. ��ü��ȸ  2. ��¥����ȸ 9. �����޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						//���⼭ �ٷ� ��ü��ȸ�ϴ� ��Ʈ�ѷ� ȣ��
						break;
					case 2:
						InputExhibitionByDate();
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}			
		}
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
	public static void InputInsertReservation(String memberId) {
		try{
			System.out.print("������ ����ȸ ��ȣ�� �Է����ּ��� : ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());

//			ExhibitionController.selectByExhibitionxNo(exhibitionNo);
		}catch (NumberFormatException e) {
			System.out.println("����ȸ��ȣ�� ���ڸ� �Է����ּ���.");
			System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				InputInsertReservation(memberId);
			}
		}
	}

	/**
	 * �����ϱ� (��¥, ���� ����, Ƽ�� ���� �Է�)
	 * */
	public static void InputReservationOption(String memberId) {
		System.out.print("������ ��¥�� �Է��ϼ��� : ");
		String regDate = sc.nextLine();

		System.out.print("���� ������ �Է����ּ��� : ");
		String visitAge = sc.nextLine();

		System.out.print("������ Ƽ�� ������ �Է����ּ��� : ");
		int ticketQty = Integer.parseInt(sc.nextLine());

		ReservationDTO reservation = new ReservationDTO(0, 0, 0, 0, regDate);
		ReservationLineDTO reservationLine = new ReservationLineDTO(0, 0, visitAge, ticketQty, 0);//���Ż�
	
		reservation.getReservationLineList().add(reservationLine);
		
		ReservationController.InputReservationOption(regDate, visitAge, ticketQty);
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
		while(true) {
			System.out.println("1. ����ȸ ����  2. �ı����  3. ���� ���  4. ���� ���� ��ȸ  9.�α׾ƿ�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						printExhibitionManagementMenu();
						break;
					case 2:
						printAdminReviewMenu();
						break;
					case 3:
						InputStatisticsByNo();
						break;
					case 4:
						printReservationHistoryMenu();
						break;
					case 9:
						logout();
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}
		}
	}
	
	
	//����ȸ ����
	
	/**
	 * ����ȸ �����޴�
	 * ����ȸ ��ȸ(ȸ�� �޼ҵ�� ����), ���, ����, ����
	 * */
	public static void printExhibitionManagementMenu() {
		while(true) {
			System.out.println("1. ����ȸ ��ȸ  2. ����ȸ ���  3. ����ȸ ����  4. ����ȸ ����  9. �����޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
				case 1:
					printExhibitionMenu();
					break;
				case 2:
					InputInsertExhibition();
					break;
				case 3:
					InputUpdateExhibition();
					break;
				case 4:
					InputDeleteExhibition();
					break;
				case 9:
					return;
				
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}
		}
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
		while(true) {
			System.out.println("1. �ı� ��ȸ  2. �ı� ����  9. �����޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						InputReViewByNo();
						break;
					case 2:
						InputDeleteReview("admin"); //������ �ı������ ȸ���� �ı������ �ƿ� �ٸ��� ���� �����ϴ°� ���?
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}
		}
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
		while(true) {
			System.out.println("1. ��ü ��ȸ  2. ���� ��ȣ�� ��ȸ  9. �����޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						//���⼭ �ٷ� ���� ���� ��ȸ ��Ʈ�ѷ� ȣ��.(�̺κе� ������ ���� ���� ��ȸ�� �����ؾ�����?)
						break;
					case 2:
						 InputReservationByNo();
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			}
		}
	}
	
	/**
	 * ���Ź�ȣ�� ��ȸ
	 * */
	public static void InputReservationByNo() {
		
	}
	
}
