package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.ExhibitionController;
import kosta.mvc.controller.MemberController;
import kosta.mvc.controller.ReservationController;
import kosta.mvc.controller.ReviewController;
import kosta.mvc.controller.StatisticsController;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.model.dto.ReviewDTO;
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
			System.out.println("----------------------------");
			System.out.println("1. �α���  2. ȸ������  9. ������");
			System.out.println("----------------------------");
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
				default:
					System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
			}
		}
	}
	
	/**
	 * ȸ������
	 * */
	public static void InputInsertMember() {
		System.out.println(">> ȸ������ �����Է�");
		System.out.print("ID :");
		String memberId = sc.nextLine();
		System.out.print("Password : ");
		String memberPassword = sc.nextLine();
		System.out.print("�̸� :");
		String memberName = sc.nextLine();
		System.out.print("�������(yyyy/mm/dd) : ");
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
		while(true) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. ���������� 2. ����ȸ��ȸ 3. ����ȸ����  4. �ı���ȸ  9. �α׾ƿ�");
			System.out.println("--------------------------------------------------------");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					printMyPage();
					break;
				case 2:
					printExhibitionMenu();
					break;
				case 3:
					inputInsertReservation();
					break;
				case 4:
					InputReViewByNo();
					break;
				case 9:
					logout();
					return;
				default:
					System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
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
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("1. ��������ȸ 2. ������ ����  3. �� ���ų��� ��ȸ  4. �� �ı����  9. �����޴��� �̵�");
			System.out.println("-------------------------------------------------------------------------");
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
						ReservationController.selectReservationByMemberId();
						break;
					case 4:
						printMemberReviewMenu();
						break;
					case 9:
						return;
					default:
						System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
			}			
		}
	}
	
	/**
	 * ��������ȸ
	 */
	public static void selectMemberInformation() {
		MemberDTO memberDTO = MemberController.memberSelectReservation();
	}
	
	/**
	 * ����������(�̸�, ������� ��й�ȣ�� ���氡��)
	 * */
	public static void inputUpdateMember() {
		
		System.out.println(">> ������ ����");
		System.out.print("�̸� :");
		String memberName = sc.nextLine();
		System.out.print("�������(yyyy/mm/dd)): ");
		String memberBirth = sc.nextLine();
		System.out.print("Password : ");
		String memberPassword = sc.nextLine();
		System.out.println("\n>> ��й�ȣ Ȯ��");
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
			System.out.println("-----------------------------------------------------------------");
			System.out.println("1. �� �ı� ��ȸ  2. �ı� ���  3.�ı� ����  4. �ı� ����  9. ���� �޴��� �̵�");
			System.out.println("-----------------------------------------------------------------");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						ReviewController.reviewSelectByReviewNo();
						break;
					case 2:
						InputInsertReview();
						break;
					case 3:
						InputDeleteReview();
						break;
					case 4:
						InputUpdateReview();
						break;
					case 9:
						return;
					default:
						System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
			}			
		}
	}
	
	/**
	 * �ı� ���
	 * */
	public static void InputInsertReview() {
		 System.out.print("����� ����ȸ ��ȣ�� �Է��ϼ���. -> ");
		 int exihibitionNo = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("�ı� ������ �Է��ϼ���. ->");
		 String reviewContnet = sc.nextLine();
		 
		 System.out.print("������ �Է��ϼ���.(������ 5�� �����Դϴ�.) -> ");
		 int stars = Integer.parseInt(sc.nextLine());
		 
		 ReviewDTO reviewDTO = new ReviewDTO(0, 0, exihibitionNo, reviewContnet, stars);
		 ReviewController.reviewInsert(reviewDTO);
	}
	/**
	 * �ı� ����
	 * */
	public static void InputDeleteReview() {
		System.out.print("������ �ı� ��ȣ�� �Է��ϼ���. -> ");
		int no = Integer.parseInt(sc.nextLine());
		ReviewController.reviewDelete(no);
		
	}
	
	/**
	 * �ı� ����
	 * */
	public static void InputUpdateReview() {
		System.out.print("������ �ı� ��ȣ�� �Է��ϼ���. -> ");
		 int no = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("������ ������ �Է��ϼ���. -> ");
		 String content = sc.nextLine();
		 
		 System.out.print("������ ������ �Է��ϼ���. -> ");
		 int stars = Integer.parseInt(sc.nextLine());
		 
		 ReviewDTO reviewDTO = new ReviewDTO(no, 0, 0, content, stars);
		 ReviewController.reviewUpdate(reviewDTO);
		 
	}
	
	
	//����ȸ ��ȸ	
	
	/**
	 * ����ȸ ��ȸ �޴�
	 * ��ü��ȸ(���� �Լ� X), ��¥�� ��ȸ
	 * */
	public static void printExhibitionMenu() {
		while(true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. ��ü��ȸ  2. ��¥����ȸ  3. ���� ������ ��ȸ 9. �����޴��� �̵�");
			System.out.println("-------------------------------------------------------");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						ExhibitionController.exhibitionSelectAll();
						break;
					case 2:
						inputExhibitionByDate();
						break;
					case 3:
						ExhibitionController.exhibitionSelectByStars();
						break;
					case 9:
						return;
					default:
						System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
			}			
		}
	}
	
	/**
	 * ��¥�� ����ȸ ��ȸ(��¥ �Է�)
	 * */
	public static void inputExhibitionByDate() {
		System.out.print("����ȸ�� �����ϰ� ���� ��¥�� �Է��ϼ���.(yyyymmdd) -> ");
		String date = sc.nextLine();
		ExhibitionController.exhibitionSelectByDate(date);
	}
	
	
	//����ȸ ����
	/**
	 * ����ȸ ����(����ȸ ��ȣ �Է�)
	 * (EndView���� ���� ���� ��¥ ����� InputReservationOption ȣ��)
	 * */
	public static void inputInsertReservation() {
		try{
			System.out.print("������ ����ȸ ��ȣ�� �Է��ϼ���. -> ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			ReservationController.inputinsertReservation(exhibitionNo );
		}catch (NumberFormatException e) {
			System.out.print("����ȸ��ȣ�� ���ڸ� �Է��ϼ���. -> ");
			System.out.print("�ٽ� �Է��Ͻðڽ��ϱ�?(yes|no) -> ");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputInsertReservation();
			}
		}
	}

	/**
	 * �����ϱ� (��¥, ���� ����, Ƽ�� ���� �Է�)
	 * */
	public static void inputReservationOption(int exhibitionNo ) {
		try{
			System.out.print("��¥�� �Է��ϼ���(yyyy-MM-dd) -> ");
			String regDate = sc.nextLine();

			System.out.print("���� ������ �Է��ϼ��� (adults, youth, kids) -> ");
			String visitAge = sc.nextLine();

			System.out.print("������ Ƽ�� ������ �Է��ϼ��� -> ");
			int ticketQty = Integer.parseInt(sc.nextLine());

			ReservationDTO reservation = new ReservationDTO(0, 0, exhibitionNo , 0, regDate); //���񽺿� ���� memberNo �ֱ� 
			ReservationLineDTO reservationLine = new ReservationLineDTO(0, 0, visitAge, ticketQty, 0);//���Ż�

			reservation.getReservationLineList().add(reservationLine);

			ReservationController.inputReservationOption(reservation);
		}catch(Exception e){
			System.out.print("�ٽ� �Է��Ͻðڽ��ϱ�?(yes|no) -> ");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputReservationOption(exhibitionNo);
			}
		}
	}


	
	
	//�ı� ��ȸ
	
	/**
	 * �ı� ��ȸ(����ȸ ��ȣ �Է�)
	 * */
	public static void InputReViewByNo() {
		System.out.print("�ı⸦ ���� ���� ����ȸ ��ȣ�� �Է��ϼ���. -> ");
		int exihibitionNo = Integer.parseInt(sc.nextLine());
		ReviewController reCon = new ReviewController();
		reCon.selectAllbyExhibitionNo(exihibitionNo);
		
	}
	
	
	
	//������ �޴�/////////////////////////////////////////////////////////////////////////	
	/**
	 * ������ ���θ޴�
	 * ����ȸ ����, �ı����, ���� ���, ���� ���� ��ȸ
	 * */
	public static void printAdminMenu() {
		while(true) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1. ����ȸ ����  2. �ı����  3. ���� ���  4. ���� ���� ��ȸ  9.�α׾ƿ�");
			System.out.println("-------------------------------------------------------------");
			
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
					default:
						System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
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
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1. ����ȸ ��ȸ  2. ����ȸ ���  3. ����ȸ ����  4. ����ȸ ����  9. �����޴��� �̵�");
			System.out.println("---------------------------------------------------------------------");
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
				default:
					System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
					break;
				
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
			}
		}
	}
	
	/**
	 * ����ȸ ���
	 * */
	public static void InputInsertExhibition() {
		try {
			System.out.print("����ȸ �̸� : ");
			String exhibitionName = sc.nextLine();
			System.out.print("����ȸ ������(yyyymmdd) : ");
			String startDate = sc.nextLine();
			System.out.print("����ȸ ������(yyyymmdd) : ");
			String endDate = sc.nextLine();
			System.out.print("����ȸ �帣 : ");
			String genre = sc.nextLine();
			System.out.print("����ȸ ���� : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("����ȸ ��� : ");
			String exhibitionLocation = sc.nextLine();
			ExhibitionDTO exhibitionDTO = new ExhibitionDTO(0, exhibitionName, startDate, endDate, genre, price, exhibitionLocation);
			ExhibitionController.exhibitionInsert(exhibitionDTO);
			
		}catch(NumberFormatException e) {
			System.out.println("\n����ȸ ������ ���ڸ� �Է��ϼ���.");
		}
	}
	
	/**
	 * ����ȸ ����
	 * */
	public static void InputUpdateExhibition() {
		try {
			System.out.print("����ȸ ��ȣ : ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			System.out.print("����ȸ �̸� : ");
			String exhibitionName = sc.nextLine();
			System.out.print("����ȸ �帣 : ");
			String genre = sc.nextLine();
			System.out.print("����ȸ ���� : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("����ȸ ��� : ");
			String exhibitionLocation = sc.nextLine();
			ExhibitionDTO exhibitionDTO = new ExhibitionDTO(exhibitionNo, exhibitionName, null, null, genre, price, exhibitionLocation);
			ExhibitionController.exhibitionUpdate(exhibitionDTO);
			
		}catch(NumberFormatException e) {
			System.out.println("\n����ȸ ��ȣ �Ǵ� ������ ���ڸ� �Է��ϼ���.");
		}
	}
	
	/**
	 * ����ȸ ����
	 * */
	public static void InputDeleteExhibition() {
		try {
			System.out.print("������ ����ȸ ��ȣ : ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			ExhibitionController.exhibitionDelete(exhibitionNo);
		}catch(NumberFormatException e) {
			System.out.println("\n����ȸ ��ȣ�� ���ڸ� �Է��ϼ���.");
		}
	}
	
	
	//������ �ı����
	
	/**
	 * ������ �ı���� �޴�
	 * �ı� ��ȸ(ȸ�� �޼ҵ�� ����), �ı� ����(ȸ�� �޼ҵ�� ����)
	 * */
	public static void printAdminReviewMenu() {
		while(true) {
			System.out.println("---------------------------------------");
			System.out.println("1. �ı� ��ȸ  2. �ı� ����  9. �����޴��� �̵�");
			System.out.println("---------------------------------------");
			
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
					default:
						System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
						break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
			}
		}
	}
	
	
	//���� ���
	
	/**
	 * ���� ���(����ȸ ��ȣ �Է�)
	 * */
	public static void InputStatisticsByNo() {
		try {
			System.out.print("��ȸ�� ����ȸ ��ȣ�� �Է��ϼ��� -> ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			System.out.print("�������� �Է��ϼ���(yyyymmdd) -> ");
			String firstDate = sc.nextLine();
			System.out.print("�������� �Է��ϼ���(yyyymmdd) -> ");
			String lastDate = sc.nextLine();
			StatisticsController.selectStatisticsByNo(exhibitionNo, firstDate, lastDate);
		
		}catch (NumberFormatException e) {
			System.out.println("����ȸ ��ȣ�� ���ڸ� �Է��ϼ���.");
		}
	}
	
	
	//���ų�����ȸ
	/**
	 * ���ų�����ȸ �޴�
	 * ��ü��ȸ, ���� ��ȣ�� ��ȸ
	 * */
	public static void printReservationHistoryMenu() {
		while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("1. ��ü ��ȸ  2. ���� ��ȣ�� ��ȸ  9. �����޴��� �̵�");
			System.out.println("--------------------------------------------");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
				case 1:
					ReservationController.reservationSelectAll();//���� ���� ��ȸ ��Ʈ�ѷ� ȣ��.
					break;
				case 2:
					inputReservationByNo();
					break;
				case 9:
					return;
				default:
					System.out.println("\n�޴��� �ش��ϴ� ���ڸ� �Է��ϼ���.");
					break;
				}
			}catch (NumberFormatException e) {
				System.out.println("\n�޴��� ���ڸ� �Է��ϼ���.");
			}
		}
	}
	
	/**
	 * ���Ź�ȣ�� ��ȸ
	 * */
	public static void inputReservationByNo() {
		System.out.println("���Ź�ȣ�� �Է��ϼ��� -> ");
		int reservationNo = Integer.parseInt(sc.nextLine());
		ReservationController controller = new ReservationController();
		controller.selectByReservationNo(reservationNo);
	}


}
