package kosta.mvc.model.dto;
//���� �� ���� ����
public class ReservationLineDTO {
//��������
	private int reservationLineNo;
	private int reservationNo;
	private String visitAge;//��������(����, û�ҳ�, ���)
	private int ticketQty;
	private int amount;
	
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
		builder.append("ReservationLineDTO [reservationLineNo=");
		builder.append(reservationLineNo);
		builder.append(", reservationNo=");
		builder.append(reservationNo);
		builder.append(", visitAge=");
		builder.append(visitAge);
		builder.append(", ticketQty=");
		builder.append(ticketQty);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
	
   
}
