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
	static MemberService memberService = new MemberService(); // static���� ���� ���..

	/**
	 * �α���
	 */
	public static boolean login(String id, String password) {
		try {
			MemberDTO memberDTO = memberService.login(id, password);
			if (memberDTO == null) {
//				throw new Exception("��ϵ��� ���� ������Դϴ�.");
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
	 * �α׾ƿ�
	 */
	public static void logout() {
	}

	/**
	 * ȸ������
	 */
	public static void inputInsertMember(String memberId, String memberPassword, String memberName,
			String memberBirth) {
		try {
			
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			  sdf.setLenient(false); // �Է��� ���� ������ ���İ� �ٸ��� ���� 
			  sdf.parse(memberBirth);

			int count = memberService.getMemberId(memberId);
			if (count > 0) {
				throw new Exception("�̹� ��ϵ� ȸ��ID�Դϴ�.");
			}
			MemberDTO memberDTO = new MemberDTO(memberId, memberName, memberBirth, memberPassword);
			int result = memberService.insertMembership(memberDTO);
			if (result == 0) {
				throw new Exception("ȸ����Ͽ� �����Ͽ����ϴ�.");
			}
			EndView.printMessage("ȸ����Ͽ� �����߽��ϴ�.");
		} catch (ParseException pe) {
			FailView.errorMessage("��������� yyyymmdd �������θ� �Է� �����մϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ��������ȸ
	 */
	public static MemberDTO memberSelectReservation() {
		MemberDTO memberDTO = memberService.memberSelectReservation();
		// EndView�� ������ ����� â�� �ʿ���.
//		EndView.printMemberInformation(memberDTO);
		return memberDTO; // �信 �α��ε� ������ ��.
	}

	/**
	 * ����������
	 */
	public static void updateMember(MemberDTO memberDTO, String memberName, String memberBirth, String memberPassword, String confirmPassword) {
		try {
			if (!memberDTO.getMemberPass().equals(confirmPassword)) {
				throw new Exception("���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
			MemberDTO updateMemberDTO = new MemberDTO(memberName, memberBirth, memberPassword); // ����� ������ �����ϴ� dto
			
			int result = memberService.updateMember(memberDTO, updateMemberDTO);
			if (result == 0) {
				throw new Exception("������������ �����߽��ϴ�.");
			}
			System.out.println("������ �����Ͽ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}

