package kosta.mvc.model.dto;

public class ReviewDTO {
	private int reviewNo; //후기번호 
	private int memberNo; //회원번호
	private int exhibitionNo; //전시회번호
	private String reviewContnet; //후기내용
	private int stars; //별점
	
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
		builder.append("후기정보 |후기번호: ");
		builder.append(reviewNo);
		builder.append("| 작성자 정보: ");
		builder.append(memberNo);
		builder.append("| 전시회 번호: ");
		builder.append(exhibitionNo);
		builder.append("| 후기 내용: ");
		builder.append(reviewContnet);
		builder.append("| 별점: ");
		builder.append(stars);
		builder.append("***");
		return builder.toString();
	}
	
}
