package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.ExhibitionController;
import kosta.mvc.controller.MemberController;
import kosta.mvc.controller.ReservationController;
import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * �ʱ�ȭ��
	 * �α���, ȸ������
	 * */
	public static void menu() {
		
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println("���� �� Ȯ�� �׽�Ʈ : " + ss.getSessionSet());
			
			System.out.println("1. �α���  2. ȸ������  9. ������");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					login();
					break;
				case 2:
					InputInsertMember();
					break;
				case 9:
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
		System.out.println();
		System.out.print("ID :");
		String memberId = sc.nextLine();
		System.out.print("Password : ");
		String memberPassword = sc.nextLine();
		System.out.print("�̸� :");
		String memberName = sc.nextLine();
		System.out.print("������� : ");
		String memberBirth = sc.nextLine();
		MemberController.inputInsertMember(memberId, memberPassword, memberName, memberBirth);
	}
	
	/**
	 * �α���
	 * */
	public static void login() {
		
		System.out.print("ID :");
		String id = sc.nextLine();
		System.out.print("Password : ");
		String password = sc.nextLine();
		
		MemberController.login(id, password);
	}
	
	/**
	 * �α׾ƿ�
	 * */
	public static void logout() {
		MemberController.logout();
	}
	
	//ȸ�� �޴�/////////////////////////////////////////////////////////////////////////
	
	/**
	 * ȸ�� ���θ޴�
	 * ����������, ����ȸ ����, �ı� ��ȸ, �α׾ƿ�
	 * */
	public static void printMemberMenu() {
		SessionSet ss = SessionSet.getInstance();
		System.out.println("���� �� Ȯ�� �׽�Ʈ : " + ss.getSessionSet());
		while(true) {
			System.out.println("1. ���������� 2. ����ȸ����  3. �ı���ȸ  9. �α׾ƿ�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					printMyPage();
					break;
				case 2:
					InputInsertReservation();
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
	public static void printMyPage() {
		while(true) {
			System.out.println("1. ��������ȸ 2.������ ����  3. �� ���ų��� ��ȸ  4. �� �ı����  9. �����޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						selectMemberInformation();
						break;
					case 2:
						inputUpdateMember();
						break;
					case 3:
						//���ִ� �� �ڸ����� �������� ��ȸ ��Ʈ�ѷ� �ٷ� ȣ���Ͻø� �˴ϴ�.
						break;
					case 4:
						printMemberReviewMenu();
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
	 * ��������ȸ
	 */
	public static void selectMemberInformation() {
		MemberDTO memberDTO = MemberController.memberSelectReservation();
		System.out.println(memberDTO.toString());
	}
	
	/**
	 * ����������(�̸�, ������� ��й�ȣ�� ���氡��)
	 * */
	public static void inputUpdateMember() {
		
		System.out.println("********* ������ ���� *********");
		System.out.print("�̸� :");
		String memberName = sc.nextLine();
		System.out.print("������� : ");
		String memberBirth = sc.nextLine();
		System.out.print("Password : ");
		String memberPassword = sc.nextLine();
		System.out.println("**************************");
		System.out.print("���� Password�� �Է��ϼ��� : ");
		String confirmPassword = sc.nextLine();
		
		MemberController.updateMember(memberName, memberBirth, memberPassword, confirmPassword);
	}

	/**
	 * ���������� �� �ı���� �޴�
	 * �� �ı� ��ȸ(���� �Լ� X), ���, ����
	 * */
	public static void printMemberReviewMenu() {
		while(true) {
			System.out.println("1. �� �ı� ��ȸ  2. �ı� ���  3.�ı� ����  9. ���� �޴��� �̵�");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						//���⼭ �ٷ� �ı� ��ȸ�ϴ� ��Ʈ�ѷ� ȣ��
						break;
					case 2:
						InputInsertReview();
						break;
					case 3:
						InputDeleteReview();
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
	public static void InputInsertReservation() {
		try{
			System.out.print("������ ����ȸ ��ȣ�� �Է����ּ��� : ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			ExhibitionController.selectByExhibitionxNo(exhibitionNo);
		}catch (NumberFormatException e) {
			System.out.println("����ȸ��ȣ�� ���ڸ� �Է����ּ���.");
			System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				InputInsertReservation();
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
						InputDeleteReview(); //������ �ı������ ȸ���� �ı������ �ƿ� �ٸ��� ���� �����ϴ°� ���?
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
