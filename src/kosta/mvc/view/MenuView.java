package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.ExhibitionController;
import kosta.mvc.controller.MemberController;
import kosta.mvc.controller.ReservationController;
import kosta.mvc.controller.ReviewController;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.session.SessionSet;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * 초기화면
	 * 로그인, 회원가입
	 * */
	public static void menu() {
		
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println("세션 값 확인 테스트 : " + ss.getSessionSet());
			
			System.out.println("1. 로그인  2. 회원가입  9. 나가기");
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
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}
		}
	}
	
	/**
	 * 회원가입
	 * */
	public static void InputInsertMember() {
		System.out.println();
		System.out.print("ID :");
		String memberId = sc.nextLine();
		System.out.print("Password : ");
		String memberPassword = sc.nextLine();
		System.out.print("이름 :");
		String memberName = sc.nextLine();
		System.out.print("생년월일 : ");
		String memberBirth = sc.nextLine();
		MemberController.inputInsertMember(memberId, memberPassword, memberName, memberBirth);
	}
	
	/**
	 * 로그인
	 * */
	public static void login() {
		
		System.out.print("ID :");
		String id = sc.nextLine();
		System.out.print("Password : ");
		String password = sc.nextLine();
		
		MemberController.login(id, password);
	}
	
	/**
	 * 로그아웃
	 * */
	public static void logout() {
		MemberController.logout();
	}
	
	//회원 메뉴/////////////////////////////////////////////////////////////////////////
	
	/**
	 * 회원 메인메뉴
	 * 마이페이지, 전시회 예매, 후기 조회, 로그아웃
	 * */
	public static void printMemberMenu() {
		SessionSet ss = SessionSet.getInstance();
		System.out.println("세션 값 확인 테스트 : " + ss.getSessionSet());
		while(true) {
			System.out.println("1. 마이페이지 2. 전시회조회 3. 전시회예매  4. 후기조회  9. 로그아웃");
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
					InputInsertReservation();
					break;
				case 4:
					InputReViewByNo();
					break;
				case 9:
					logout();
					return;
				}
			}catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}
		}
	}
	
	//마이페이지
	/**
	 * 마이페이지 메뉴
	 * 고객정보수정, 내 예매내역 조회(따로 함수 X), 내 후기관리
	 * */
	public static void printMyPage() {
		while(true) {
			System.out.println("1. 고객정보조회 2.고객정보 수정  3. 내 예매내역 조회  4. 내 후기관리  9. 상위메뉴로 이동");
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
						//은솔님 이 자리에서 예내내역 조회 컨트롤러 바로 호출하시면 됩니다.
						break;
					case 4:
						printMemberReviewMenu();
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}			
		}
	}
	
	/**
	 * 고객정보조회
	 */
	public static void selectMemberInformation() {
		MemberDTO memberDTO = MemberController.memberSelectReservation();
		System.out.println(memberDTO.toString());
	}
	
	/**
	 * 고객정보수정(이름, 생년월일 비밀번호만 변경가능)
	 * */
	public static void inputUpdateMember() {
		
		System.out.println("********* 수정할 정보 *********");
		System.out.print("이름 :");
		String memberName = sc.nextLine();
		System.out.print("생년월일 : ");
		String memberBirth = sc.nextLine();
		System.out.print("Password : ");
		String memberPassword = sc.nextLine();
		System.out.println("**************************");
		System.out.print("현재 Password를 입력하세요 : ");
		String confirmPassword = sc.nextLine();
		
		MemberController.updateMember(memberName, memberBirth, memberPassword, confirmPassword);
	}

	/**
	 * 마이페이지 내 후기관리 메뉴
	 * 내 후기 조회(따로 함수 X), 등록, 삭제
	 * */
	public static void printMemberReviewMenu() {
		while(true) {
			System.out.println("1. 내 후기 조회  2. 후기 등록  3.후기 삭제  4. 후기 수정  9. 상위 메뉴로 이동");
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
				}
			}catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}			
		}
	}
	
	/**
	 * 후기 등록
	 * */
	public static void InputInsertReview() {
		 System.out.print("\n 등록할 전시회 번호를 입력해주세요. >");
		 int exihibitionNo = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("\n 후기 내용 입력 >");
		 String reviewContnet = sc.nextLine();
		 
		 System.out.print("\n 별점을 입력해주세요. 별점은 5점 만점입니다. >");
		 int stars = Integer.parseInt(sc.nextLine());
		 
		 ReviewDTO reviewDTO = new ReviewDTO(0, 0, exihibitionNo, reviewContnet, stars);
		 ReviewController.reviewInsert(reviewDTO);
	}
	
	/**
	 * 후기 삭제
	 * */
	public static void InputDeleteReview() {
		System.out.println("삭제할 후기 번호를 입력해주세요. >");
		int no = sc.nextInt();
		ReviewController.reviewDelete(no);
		
	}
	
	/**
	 * 후기 수정
	 * */
	public static void InputUpdateReview() {
		System.out.println("수정 할 후기 번호를 입력하세요. >");
		 int no = Integer.parseInt(sc.nextLine());
		 
		 System.out.println("수정할 내용을 입력하세요. >");
		 String content = sc.nextLine();
		 
		 System.out.println("수정할 별점을 입력하세요. >");
		 int stars = Integer.parseInt(sc.nextLine());
		 
		 ReviewDTO reviewDTO = new ReviewDTO(0, 0, no, content, stars);
		 ReviewController.reviewUpdate(reviewDTO);
		 
		 
	}
	
	
	//전시회 조회	
	
	/**
	 * 전시회 조회 메뉴
	 * 전체조회(따로 함수 X), 날짜별 조회
	 * */
	public static void printExhibitionMenu() {
		while(true) {
			System.out.println("1. 전체조회  2. 날짜별조회 9. 상위메뉴로 이동");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						ExhibitionController.exhibitionSelectAll();
						break;
					case 2:
						InputExhibitionByDate();
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}			
		}
	}
	
	/**
	 * 날짜별 전시회 조회(날짜 입력)
	 * */
	public static void InputExhibitionByDate() {
		System.out.println("날짜를 입력해주세요");
		String date = sc.nextLine();
		ExhibitionController.exhibitionSelectByDate(date);
	}
	
	
	//전시회 예매
	

	/**
	 * 전시회 예매(전시회 번호 입력)
	 * (EndView에서 예매 가능 날짜 출력후 InputReservationOption 호출)
	 * */
	public static void InputInsertReservation() {
		try{
			System.out.print("예매할 전시회 번호를 입력해주세요 : ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			ReservationController.InputinsertReservation(exhibitionNo);
		
		}catch (NumberFormatException e) {
			
			System.out.println("전시회번호는 숫자만 입력해주세요.");
			System.out.println("다시 입력하시겠습니까?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				InputInsertReservation();
			}
		}
	}

	/**
	 * 예매하기 (날짜, 관람 연령, 티켓 수량 입력)
	 * */
	public static void InputReservationOption(String memberId) {
		System.out.print("예매할 날짜를 입력하세요 : ");
		String regDate = sc.nextLine();

		System.out.print("관람 연령을 입력해주세요 : ");
		String visitAge = sc.nextLine();

		System.out.print("예매할 티켓 수량을 입력해주세요 : ");
		int ticketQty = Integer.parseInt(sc.nextLine());

		ReservationDTO reservation = new ReservationDTO(0, 0, 0, 0, regDate);
		ReservationLineDTO reservationLine = new ReservationLineDTO(0, 0, visitAge, ticketQty, 0);//예매상세
	
		reservation.getReservationLineList().add(reservationLine);
		
		ReservationController.InputReservationOption(regDate, visitAge, ticketQty);
	}


	
	
	//후기 조회
	
	/**
	 * 후기 조회(전시회 번호 입력)
	 * */
	public static void InputReViewByNo() {
		System.out.print("후기를 보고 싶은 전시회 번호를 입력하세요. >");
		int exihibitionNo = Integer.parseInt(sc.nextLine());
		ReviewController reCon = new ReviewController();
		reCon.selectAllbyExhibitionNo(exihibitionNo);
		
	}
	
	
	
	//관리자 메뉴/////////////////////////////////////////////////////////////////////////	
	/**
	 * 관리자 메인메뉴
	 * 전시회 관리, 후기관리, 예매 통계, 예매 내역 조회
	 * */
	public static void printAdminMenu() {
		while(true) {
			System.out.println("1. 전시회 관리  2. 후기관리  3. 예매 통계  4. 예매 내역 조회  9.로그아웃");
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
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}
		}
	}
	
	
	//전시회 관리
	
	/**
	 * 전시회 관리메뉴
	 * 전시회 조회(회원 메소드와 동일), 등록, 수정, 삭제
	 * */
	public static void printExhibitionManagementMenu() {
		while(true) {
			System.out.println("1. 전시회 조회  2. 전시회 등록  3. 전시회 수정  4. 전시회 삭제  9. 상위메뉴로 이동");
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
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}
		}
	}
	
	/**
	 * 전시회 등록
	 * */
	public static void InputInsertExhibition() {
		try {
			System.out.print("전시회 이름 : ");
			String exhibitionName = sc.nextLine();
			System.out.print("전시회 시작일 : ");
			String startDate = sc.nextLine();
			System.out.print("전시회 종료일 : ");
			String endDate = sc.nextLine();
			System.out.print("전시회 장르 : ");
			String genre = sc.nextLine();
			System.out.print("전시회 가격 : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("전시회 장소 : ");
			String exhibitionLocation = sc.nextLine();
			ExhibitionDTO exhibitionDTO = new ExhibitionDTO(0, exhibitionName, startDate, endDate, genre, price, exhibitionLocation);
			ExhibitionController.exhibitionInsert(exhibitionDTO);
			
		}catch(NumberFormatException e) {
			System.out.println("전시회 가격은 숫자만 입력해 주세요.");
		}
	}
	
	/**
	 * 전시회 수정
	 * */
	public static void InputUpdateExhibition() {
		try {
			System.out.print("전시회 번호 : ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			System.out.print("전시회 이름 : ");
			String exhibitionName = sc.nextLine();
			System.out.print("전시회 장르 : ");
			String genre = sc.nextLine();
			System.out.print("전시회 가격 : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("전시회 장소 : ");
			String exhibitionLocation = sc.nextLine();
			ExhibitionDTO exhibitionDTO = new ExhibitionDTO(exhibitionNo, exhibitionName, null, null, genre, price, exhibitionLocation);
			ExhibitionController.exhibitionInsert(exhibitionDTO);
			
		}catch(NumberFormatException e) {
			System.out.println("전시회 번호 또는 가격은 숫자만 입력해 주세요.");
		}
	}
	
	/**
	 * 전시회 삭제
	 * */
	public static void InputDeleteExhibition() {
		try {
			System.out.print("전시회 번호 : ");
			int exhibitionNo = Integer.parseInt(sc.nextLine());
			ExhibitionController.exhibitionDelete(exhibitionNo);
		}catch(NumberFormatException e) {
			System.out.println("전시회 번호는 숫자만 입력해 주세요.");
		}
	}
	
	
	//관리자 후기관리
	
	/**
	 * 관리자 후기관리 메뉴
	 * 후기 조회(회원 메소드와 동일), 후기 삭제(회원 메소드와 동일)
	 * */
	public static void printAdminReviewMenu() {
		while(true) {
			System.out.println("1. 후기 조회  2. 후기 삭제  9. 상위메뉴로 이동");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						InputReViewByNo();
						break;
					case 2:
						InputDeleteReview(); //관리자 후기삭제를 회원의 후기삭제와 아예 다르게 만들어서 구현하는건 어떨지?
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}
		}
	}
	
	
	//예매 통계
	
	/**
	 * 예매 통계(전시회 번호 입력)
	 * */
	public static void InputStatisticsByNo() {
		
	}
	
	
	//예매내역조회
	/**
	 * 예매내역조회 메뉴
	 * 전체조회, 예매 번호로 조회
	 * */
	public static void printReservationHistoryMenu() {
		while(true) {
			System.out.println("1. 전체 조회  2. 예매 번호로 조회  9. 상위메뉴로 이동");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {			
					case 1:
						//여기서 바로 예매 내역 조회 컨트롤러 호출.(이부분도 유저의 예매 내역 조회와 구분해야할지?)
						break;
					case 2:
						 InputReservationByNo();
						break;
					case 9:
						return;
				}
			}catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 입력해주세요.");
			}
		}
	}
	
	/**
	 * 예매번호로 조회
	 * */
	public static void InputReservationByNo() {
		
	}
	
}
