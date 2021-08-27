package kosta.mvc.model.dto;

public class MemberDTO {
	private int memberNo;
	private String memberId;
	private String memberName;
	private String memberBirth;
	private String memberPass;
	
	public MemberDTO() {}

	public MemberDTO(int memberNo, String memberId, String memberName, String memberBirth, String memberPass) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberPass = memberPass;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	
}
