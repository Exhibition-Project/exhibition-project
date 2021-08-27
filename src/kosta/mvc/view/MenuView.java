package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.ReservationController;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;

public class MenuView {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * 초기화면
	 * 로그인, 회원가입
	 * */
	public static void menu() {
		
	}
	
	/**
	 * 회원가입
	 * */
	public static void InputInsertMember() {
		
	}
	
	/**
	 * 로그인
	 * */
	public static void login() {
		
	}
	
	/**
	 * 로그아웃
	 * */
	public static void logout() {
		
	}
	
	//회원 메뉴/////////////////////////////////////////////////////////////////////////
	
	/**
	 * 회원 메인메뉴
	 * 마이페이지, 전시회조회, 전시회 예매, 후기 조회, 로그아웃
	 * */
	public static void printMemberMenu() {
		
	}
	
	//마이페이지
	/**
	 * 마이페이지 메뉴
	 * 고객정보수정, 내 예매내역 조회(따로 함수 X), 내 후기관리
	 * */
	public static void printMyPage() {
		
	}
	
	/**
	 * 고객정보수정
	 * */
	public static void inputUpdateMember() {
		
	}

	/**
	 * 마이페이지 내 후기관리 메뉴
	 * 내 후기 조회(따로 함수 X), 등록, 삭제
	 * */
	public static void printMemberReviewMenu() {
		
	}
	
	/**
	 * 후기 등록
	 * */
	public static void InputInsertReview() {
		
	}
	
	/**
	 * 후기 삭제
	 * */
	public static void InputDeleteReview() {
		
	}
	
	
	//전시회 조회	
	
	/**
	 * 전시회 조회 메뉴
	 * 전체조회(따로 함수 X), 날짜별 조회
	 * */
	public static void printExhibitionMenu() {
		
	}
	
	/**
	 * 날짜별 전시회 조회(날짜 입력)
	 * */
	public static void InputExhibitionByDate() {
		
	}
	
	
	//전시회 예매
	
	/**
	 * 전시회 예매(전시회 번호 입력)
	 * (EndView에서 예매 가능 날짜 출력후 InputReservationOption 호출)
	 * */
	public static void InputInsertReservation() {
		System.out.print("예매할 전시회 번호를 입력해주세요 : ");
		int exhibitionNo = Integer.parseInt(sc.nextLine());
		
		ReservationController.InputReservationOption(exhibitionNo);
	}
	
	/**
	 * 예매하기 (날짜, 관람 연령, 티켓 수량 입력)
	 * */
	public static void InputReservationOption(String memberId) {
		 System.out.print("예매할 날짜를 입력하세요 : ");
		 int reg_date = Integer.parseInt(sc.nextLine());
		 
		 System.out.print("관람 연령을 입력해주세요 : ");
		 String visitAge = sc.nextLine();
		 
		 System.out.print("예매할 티켓 수량을 입력해주세요 : ");
		 int ticket_qty = Integer.parseInt(sc.nextLine());
		 
		 ReservationController.insertReservation(reg_date, visitAge, ticket_qty);
		
	}
	
	
	//후기 조회
	
	/**
	 * 후기 조회(전시회 번호 입력)
	 * */
	public static void InputReViewByNo() {
		
	}
	
	
	
	//관리자 메뉴/////////////////////////////////////////////////////////////////////////	
	/**
	 * 관리자 메인메뉴
	 * 전시회 관리, 후기관리, 예매 통계, 예매 내역 조회
	 * */
	public static void printAdminMenu() {
		
	}
	
	
	//전시회 관리
	
	/**
	 * 전시회 관리메뉴
	 * 전시회 조회(회원 메소드와 동일), 등록, 수정, 삭제
	 * */
	public static void printExhibitionManagementMenu() {
		
	}
	
	/**
	 * 전시회 등록
	 * */
	public static void InputInsertExhibition() {
		
	}
	
	/**
	 * 전시회 수정
	 * */
	public static void InputUpdateExhibition() {
		
	}
	
	/**
	 * 전시회 삭제
	 * */
	public static void InputDeleteExhibition() {
		
	}
	
	
	//관리자 후기관리
	
	/**
	 * 관리자 후기관리 메뉴
	 * 후기 조회(회원 메소드와 동일), 후기 삭제(회원 메소드와 동일)
	 * */
	public static void printAdminReviewMenu() {
		
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
		
	}
	
	/**
	 * 예매번호로 조회
	 * */
	public static void InputReservationByNo() {
		
	}
	
}
