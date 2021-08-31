package kosta.mvc.model.dto;

public class ReviewDTO {
	private int reviewNo; //�ı��ȣ 
	private int memberNo; //ȸ����ȣ
	private int exhibitionNo; //����ȸ��ȣ
	private String reviewContnet; //�ı⳻��
	private int stars; //����
	
	private String exhibitionName;
	
	public ReviewDTO() {}
	
	public ReviewDTO(int reviewNo, int memberNo, int exhibitionNo, String reviewContnet, int stars) {
		super();
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.exhibitionNo = exhibitionNo;
		this.reviewContnet = reviewContnet;
		this.stars = stars;
	}

	public ReviewDTO(int reviewNo, int exhibitionNo, String exhibitionName, String reviewContnet, int stars) {
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.exhibitionNo = exhibitionNo;
		this.reviewContnet = reviewContnet;
		this.stars = stars;
		
		this.exhibitionName = exhibitionName;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getExhibitionNo() {
		return exhibitionNo;
	}

	public void setExhibitionNo(int exhibitionNo) {
		this.exhibitionNo = exhibitionNo;
	}

	public String getReviewContnet() {
		return reviewContnet;
	}

	public void setReviewContnet(String reviewContnet) {
		this.reviewContnet = reviewContnet;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getExhibitionName() {
		return exhibitionName;
	}

	public void setExhibitionName(String exhibitionName) {
		this.exhibitionName = exhibitionName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("�ı����� |�ı��ȣ: ");
		builder.append(reviewNo);
		builder.append("| �ۼ��� ����: ");
		builder.append(memberNo);
		builder.append("| ����ȸ ��ȣ: ");
		builder.append(exhibitionNo);
		builder.append("| �ı� ����: ");
		builder.append(reviewContnet);
		builder.append("| ����: ");
		builder.append(stars);
		builder.append("***");
		return builder.toString();
	}
	
}
