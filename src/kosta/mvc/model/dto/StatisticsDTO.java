package kosta.mvc.model.dto;

public class StatisticsDTO {
	private int totalVisitors;
	private int totalProfits;
	
	public StatisticsDTO() {}

	public StatisticsDTO(int totalVisitors, int totalProfits) {
		super();
		this.totalVisitors = totalVisitors;
		this.totalProfits = totalProfits;
	}

	public int getTotalVisitors() {
		return totalVisitors;
	}

	public void setTotalVisitors(int totalVisitors) {
		this.totalVisitors = totalVisitors;
	}

	public int getTotalProfits() {
		return totalProfits;
	}

	public void setTotalProfits(int totalProfits) {
		this.totalProfits = totalProfits;
	}
	
	
}