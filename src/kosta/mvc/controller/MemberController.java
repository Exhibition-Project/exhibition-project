package kosta.mvc.controller;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.model.service.MemberService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;

public class MemberController {
	static MemberService memberService = new MemberService();
	

	/**
	 * 로그인
	 */
	public static void login(String id, String password) {
		
		try {
			MemberDTO memberDTO = memberService.login(id, password);
			EndView.printMessage("\n로그인이 완료되었습니다.");
			if (memberDTO.getMemberNo() == 0) {
				MenuView.printAdminMenu(); 
			} else {
				MenuView.printMemberMenu();
			}
		} catch (Exception e) {
			FailView.errorMessage("\n로그인에 실패하였습니다.");
		}
	}

	/**
	 * 로그아웃
	 */
	public static void logout() {
		memberService.logout();
		EndView.printMessage("\n로그아웃이 완료되었습니다.");
	}

	/**
	 * 회원가입
	 */
	public static void inputInsertMember(String memberId, String memberPassword, String memberName,
			String memberBirth) {
		try {
			
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			  sdf.setLenient(false); // 입력한 값이 설정한 형식과 다르면 오류 
			  sdf.parse(memberBirth);

			int count = memberService.getMemberId(memberId);
			if (count > 0) {
				throw new Exception("\n이미 등록된 회원ID입니다.");
			}
			MemberDTO memberDTO = new MemberDTO(memberId, memberName, memberBirth, memberPassword);
			int result = memberService.insertMembership(memberDTO);
			if (result == 0) {
				throw new Exception("\n회원등록에 실패하였습니다.");
			}
			EndView.printMessage("\n회원등록에 성공했습니다.");
		} catch (ParseException pe) {
			FailView.errorMessage("\n생년월일은 yyyymmdd 형식으로만 입력 가능합니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 고객정보조회
	 */
	public static MemberDTO memberSelectReservation() {
		MemberDTO memberDTO = memberService.memberSelectReservation();
		EndView.printMemberInformation(memberDTO);
		return memberDTO;
	}

	/**
	 * 고객정보수정
	 */
	public static void updateMember(String memberName, String memberBirth, String memberPassword, String confirmPassword) {
		try {
			if (memberService.checkPassword(confirmPassword) == 0) {
				throw new Exception("\n현재 비밀번호가 일치하지 않습니다.");
			}
			MemberDTO updateMemberDTO = new MemberDTO(memberName, memberBirth, memberPassword); // 변경된 정보를 저장하는 dto
			
			int result = memberService.updateMember(confirmPassword, updateMemberDTO);
			if (result == 0) {
				throw new Exception("\n고객정보수정에 실패했습니다.");
			}
			System.out.println("\n수정에 성공하였습니다.");
		} catch (Exception e) {
			FailView.errorMessage("\n수정에 실패하였습니다.");
		}

	}

}

