package kosta.mvc.model.dto;

public class DiscountDTO {
	private String visitAge;//��������
	private int discountRate;//������
	
	public DiscountDTO() {}

	public DiscountDTO(String visitAge, int discountRate) {
		super();
		this.visitAge = visitAge;
		this.discountRate = discountRate;
	}

	public String getVisitAge() {
		return visitAge;
	}

	public void setVisitAge(String visitAge) {
		this.visitAge = visitAge;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "DiscountDTO [visitAge=" + visitAge + ", discountRate=" + discountRate + "]";
	}
	
	
}
