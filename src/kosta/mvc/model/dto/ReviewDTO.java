package kosta.mvc.model.dto;

public class ReviewDTO {
	private int reviewNo;
	private int memberNo;
	private int exhibitionNo;
	private String reviewContnet;
	private int stars;
	
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
		builder.append("ReviewDTO [reviewNo=");
		builder.append(reviewNo);
		builder.append(", memberNo=");
		builder.append(memberNo);
		builder.append(", exhibitionNo=");
		builder.append(exhibitionNo);
		builder.append(", reviewContnet=");
		builder.append(reviewContnet);
		builder.append(", stars=");
		builder.append(stars);
		builder.append("]");
		return builder.toString();
	}
	
}
