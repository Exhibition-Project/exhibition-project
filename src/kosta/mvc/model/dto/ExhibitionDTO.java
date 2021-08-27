package kosta.mvc.model.dto;

import java.util.List;

public class ExhibitionDTO {
	private int exhibitioNo;
	private String exhibitionName;
	private String startDate;
	private String endDate;
	private String genre;
	private int price;
	private String exhibitionLocation;
	
	private List<ReviewDTO> reviewList; //리뷰 리스트를 가지고 있을 수 있다.
	
	public ExhibitionDTO(int exhibitioNo, String exhibitionName, String startDate, String endDate, String genre,
			int price, String exhibitionLocation) {
		super();
		this.exhibitioNo = exhibitioNo;
		this.exhibitionName = exhibitionName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.genre = genre;
		this.price = price;
		this.exhibitionLocation = exhibitionLocation;
	}

	
	public int getExhibitioNo() {
		return exhibitioNo;
	}

	public void setExhibitioNo(int exhibitioNo) {
		this.exhibitioNo = exhibitioNo;
	}

	public String getExhibitionName() {
		return exhibitionName;
	}

	public void setExhibitionName(String exhibitionName) {
		this.exhibitionName = exhibitionName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExhibitionLocation() {
		return exhibitionLocation;
	}

	public void setExhibitionLocation(String exhibitionLocation) {
		this.exhibitionLocation = exhibitionLocation;
	}

	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExhibitionDTO [exhibitioNo=");
		builder.append(exhibitioNo);
		builder.append(", exhibitionName=");
		builder.append(exhibitionName);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", genre=");
		builder.append(genre);
		builder.append(", price=");
		builder.append(price);
		builder.append(", exhibitionLocation=");
		builder.append(exhibitionLocation);
		builder.append(", reviewList=");
		builder.append(reviewList);
		builder.append("]");
		return builder.toString();
	}
}
