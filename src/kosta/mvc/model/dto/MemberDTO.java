package kosta.mvc.model.dto;

public class MemberDTO {
	private int memberNo;
	private String memberId;
	private String memberName;
	private String memberBirth;
	private String memberPass;
	
	public MemberDTO() {}
	
	public MemberDTO(String memberName, String memberBirth, String memberPass) {
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberPass = memberPass;
	}

	public MemberDTO(String memberId, String memberName, String memberBirth, String memberPass) {
		this(memberName, memberBirth, memberPass);
		this.memberId = memberId;
	}
	
	public MemberDTO(int memberNo, String memberId, String memberName, String memberBirth, String memberPass) {
		this(memberId, memberName, memberBirth, memberPass);
		this.memberNo = memberNo;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(">> 회원 정보");
		builder.append("\nID : ");
		builder.append(memberId);
		builder.append("\nmemberPass : ");
		builder.append(memberPass);
		builder.append("\nmemberName : ");
		builder.append(memberName);
		builder.append("\nmemberBirth : ");
		builder.append(memberBirth);
		return builder.toString();
	}
}
