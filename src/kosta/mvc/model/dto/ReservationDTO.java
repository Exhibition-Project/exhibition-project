package kosta.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ReservationDTO {
	private int reservationNo; //���Ź�ȣ 
	private int memberNo; //ȸ����ȣ
	private int ExhibitionNo; //����ȸ��ȣ
	private int totalAmount; //�ѱݾ�
	private String regDate; //���� ��¥ 
	
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
