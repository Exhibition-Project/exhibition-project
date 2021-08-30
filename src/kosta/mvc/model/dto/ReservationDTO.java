package kosta.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

//예매 정보 저장
public class ReservationDTO {
	private int reservationNo;
	private int memberNo;
	private int ExhibitionNo;
	private int totalAmount;
	private String regDate; //예매할 날짜 
	
	private List<ReservationLineDTO> reservationLineList = new ArrayList<ReservationLineDTO>();
	
	public ReservationDTO() {}
	
	public ReservationDTO(int reservationNo, int memberNo, int exhibitionNo, int totalAmount, String regDate) {
		super();
		this.reservationNo = reservationNo;
		this.memberNo = memberNo;
		ExhibitionNo = exhibitionNo;
		this.totalAmount = totalAmount;
		this.regDate = regDate;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getExhibitionNo() {
		return ExhibitionNo;
	}

	public void setExhibitionNo(int exhibitionNo) {
		ExhibitionNo = exhibitionNo;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public List<ReservationLineDTO> getReservationLineList() {
		return reservationLineList;
	}

	public void setReservationLineList(List<ReservationLineDTO> reservationLineList) {
		this.reservationLineList = reservationLineList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationDTO [reservationNo=");
		builder.append(reservationNo);
		builder.append(", memberNo=");
		builder.append(memberNo);
		builder.append(", ExhibitionNo=");
		builder.append(ExhibitionNo);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", reservationLineList=");
		builder.append(reservationLineList);
		builder.append("]");
		return builder.toString();
	}	
	
	
}
