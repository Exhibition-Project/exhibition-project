package kosta.mvc.model.dto;

public class StatisticsDTO {
	private String date;
	private int totalVisitors;
	private int totalProfits;
	
	public StatisticsDTO() {}

	public StatisticsDTO(int totalVisitors, int totalProfits) {
		super();
		this.totalVisitors = totalVisitors;
		this.totalProfits = totalProfits;
	}
	
	public StatisticsDTO(int totalVisitors, int totalProfits, String date) {
		this(totalVisitors, totalProfits);
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatisticsDTO [date=");
		builder.append(date);
		builder.append(", totalVisitors=");
		builder.append(totalVisitors);
		builder.append(", totalProfits=");
		builder.append(totalProfits);
		builder.append("]");
		return builder.toString();
	}
}