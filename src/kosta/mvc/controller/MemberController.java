package kosta.mvc.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.model.service.MemberService;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;

public class MemberController {
	static MemberService memberService = new MemberService(); // static쓸지 말지 고민..

	/**
	 * 로그인
	 */
	public static boolean login(String id, String password) {
		try {
			MemberDTO memberDTO = memberService.login(id, password);
			if (memberDTO == null) {
//				throw new Exception("등록되지 않은 사용자입니다.");
				return false;
			}
			Session session = new Session(memberDTO.getMemberNo(), memberDTO.getMemberId());
			SessionSet sessionSet = SessionSet.getInstance();
			Set<Session> set = sessionSet.getSessionSet();
			set.add(session);

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return true;
	}

	/**
	 * 로그아웃
	 */
	public static void logout() {
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
				throw new Exception("이미 등록된 회원ID입니다.");
			}
			MemberDTO memberDTO = new MemberDTO(memberId, memberName, memberBirth, memberPassword);
			int result = memberService.insertMembership(memberDTO);
			if (result == 0) {
				throw new Exception("회원등록에 실패하였습니다.");
			}
			EndView.printMessage("회원등록에 성공했습니다.");
		} catch (ParseException pe) {
			FailView.errorMessage("생년월일은 yyyymmdd 형식으로만 입력 가능합니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 고객정보조회
	 */
	public static MemberDTO memberSelectReservation() {
		MemberDTO memberDTO = memberService.memberSelectReservation();
		// EndView에 고객정보 출력할 창이 필요함.
//		EndView.printMemberInformation(memberDTO);
		return memberDTO; // 뷰에 로그인된 정보를 줌.
	}

	/**
	 * 고객정보수정
	 */
	public static void updateMember(MemberDTO memberDTO, String memberName, String memberBirth, String memberPassword, String confirmPassword) {
		try {
			if (!memberDTO.getMemberPass().equals(confirmPassword)) {
				throw new Exception("현재 비밀번호가 일치하지 않습니다.");
			}
			MemberDTO updateMemberDTO = new MemberDTO(memberName, memberBirth, memberPassword); // 변경된 정보를 저장하는 dto
			
			int result = memberService.updateMember(memberDTO, updateMemberDTO);
			if (result == 0) {
				throw new Exception("고객정보수정에 실패했습니다.");
			}
			System.out.println("수정에 성공하였습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}

