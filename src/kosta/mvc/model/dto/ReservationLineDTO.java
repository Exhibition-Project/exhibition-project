package kosta.mvc.model.dto;

public class ReservationLineDTO {
	private int reservationLineNo; //예매상세번호
	private int reservationNo; //예매번호
	private String visitAge;//관람연령(성인, 청소년, 어린이)
	private int ticketQty; //티켓수량
	private int amount; //금액
	
	public ReservationLineDTO() {}
	
	public ReservationLineDTO(int reservationLineNo, int reservationNo, String visitAge, int ticketQty, int amount) {
		super();
		this.reservationLineNo = reservationLineNo;
		this.reservationNo = reservationNo;
		this.visitAge = visitAge;
		this.ticketQty = ticketQty;
		this.amount = amount;
	}

	public int getReservationLineNo() {
		return reservationLineNo;
	}

	public void setReservationLineNo(int reservationLineNo) {
		this.reservationLineNo = reservationLineNo;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getVisitAge() {
		return visitAge;
	}

	public void setVisitAge(String visitAge) {
		this.visitAge = visitAge;
	}

	public int getTicketQty() {
		return ticketQty;
	}

	public void setTicketQty(int ticketQty) {
		this.ticketQty = ticketQty;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| 예매상세번호: ");
		builder.append(reservationLineNo);
		builder.append(" | 예매번호:");
		builder.append(reservationNo);
		builder.append(" | 관람연령: ");
		builder.append(visitAge);
		builder.append(" | 티켓수량: ");
		builder.append(ticketQty);
		builder.append(" | 총 결제금액: ");
		builder.append(amount);
		builder.append("원");
		return builder.toString();
	}
	
	
   
}
