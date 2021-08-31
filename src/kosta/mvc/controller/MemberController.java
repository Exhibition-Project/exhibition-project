package kosta.mvc.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import kosta.mvc.model.dto.MemberDTO;
import kosta.mvc.model.service.MemberService;
import kosta.mvc.view.EndView;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;
/**
 * @author �ڼ���
 */
public class MemberController {
	static MemberService memberService = new MemberService();
	
	/**
	 * �α���
	 * @param id
	 * @param password
	 */
	public static void login(String id, String password) {
		
		try {
			MemberDTO memberDTO = memberService.login(id, password);
			EndView.printMessage("\n�α����� �Ϸ�Ǿ����ϴ�.");
			if (memberDTO.getMemberNo() == 0) {
				MenuView.printAdminMenu(); 
			} else {
				MenuView.printMemberMenu();
			}
		} catch (Exception e) {
			FailView.errorMessage("\n�α��ο� �����Ͽ����ϴ�.");
		}
	}

	/**
	 * �α׾ƿ�
	 */
	public static void logout() {
		memberService.logout();
		EndView.printMessage("\n�α׾ƿ��� �Ϸ�Ǿ����ϴ�.");
	}

	/**
	 * ȸ������
	 * @param memberId
	 * @param memberPassword
	 * @param memberName
	 * @param memberBirth
	 */
	public static void inputInsertMember(String memberId, String memberPassword, String memberName, String memberBirth) {
		try {
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			  sdf.setLenient(false); // �Է��� ���� ������ ���İ� �ٸ��� ���� 
			  sdf.parse(memberBirth);

			int count = memberService.getMemberId(memberId);
			if (count > 0) {
				throw new Exception("\n�̹� ��ϵ� ȸ��ID�Դϴ�.");
			}
			MemberDTO memberDTO = new MemberDTO(memberId, memberName, memberBirth, memberPassword);
			int result = memberService.insertMembership(memberDTO);
			if (result == 0) {
				throw new Exception("\nȸ����Ͽ� �����Ͽ����ϴ�.");
			}
			EndView.printMessage("\nȸ����Ͽ� �����߽��ϴ�.");
		} catch (ParseException pe) {
			FailView.errorMessage("\n��������� yyyymmdd �������θ� �Է� �����մϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ȸ������ ��ȸ
	 * @return ȸ������
	 */
	public static MemberDTO memberSelectReservation() {
		MemberDTO memberDTO = null;
		try {
			memberDTO = memberService.memberSelectReservation();
			EndView.printMemberInformation(memberDTO);
			
		} catch (SQLException e) {
			System.out.println("\nȸ��������ȸ�� �����Ͽ����ϴ�.");
		}
		return memberDTO;
	}

	/**
	 * ȸ������ ����
	 * @param memberName
	 * @param memberBirth
	 * @param memberPassword
	 * @param confirmPassword
	 */
	public static void updateMember(String memberName, String memberBirth, String memberPassword, String confirmPassword) {
		try {
			if (memberService.checkPassword(confirmPassword) == 0) {
				throw new Exception("\n���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
			MemberDTO updateMemberDTO = new MemberDTO(memberName, memberBirth, memberPassword); // ����� ������ �����ϴ� dto
			
			int result = memberService.updateMember(confirmPassword, updateMemberDTO);
			if (result == 0) {
				throw new Exception("\n������������ �����߽��ϴ�.");
			}
			System.out.println("\n������ �����Ͽ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage("\n������ �����Ͽ����ϴ�.");
		}
	}

}

