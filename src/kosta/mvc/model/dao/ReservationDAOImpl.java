package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.util.DBUtil;

public class ReservationDAOImpl implements ReservationDAO{
	
	ReservationDAO reservationDao = new ReservationDAOImpl();
	ExhibitionDAO exhibitionDao = new ExhibitionDAOImpl();
	 
	/**
	 * �����ϱ� 
	 * 	1) ���̺� insert
	 * 	2) order_line���̺� insert
	 * */
	@Override
	public int reservationInsert(ReservationDTO reservation) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql="=insert into reservation values(RESERVATION_NO_SEQ.nextval, ?, ?, ?, ?)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, reservation.getMemberNo());//ȸ����ȣ
			ps.setInt(2, reservation.getExhibitionNo());//����ȸ��ȣ
			ps.setInt(3, getTotalAmount(reservation));//�ѱ��űݾ� ���ϴ� �޼ҵ� ȣ��
			ps.setString(4, reservation.getRegDate());//������ ��¥
			
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("���Ű� �����߽��ϴ�");
			}else {
				int re [] = reservationLineInsert(con, reservation);//���Ż� ����ϱ�
				for(int i : re) {
					if(i != 1) {
						con.rollback();
						throw new SQLException("������ �� �����ϴ�.");
					}
				}
				con.commit();
			}
		}finally {
			con.commit();
			DBUtil.dbClose(con, ps, null);
		}
		return result;
	}


	/**
	 * ���� �󼼵���ϱ�
	 * */
	private int[] reservationLineInsert(Connection con, ReservationDTO reservation) throws SQLException{
		PreparedStatement ps = null;
		String sql = "insert into reservation_line values(RESERVATION_LINE_NO_SEQ.nextval, reservation_no_seq.currval, ?, ?, ?)";
		int result [] = null;
		try {
			ps = con.prepareStatement(sql);
			for(ReservationLineDTO reservationLine : reservation.getReservationLineList()) {
				ps.setString(1, reservationLine.getVisitAge());//��������
				ps.setInt(2, reservationLine.getTicketQty());//Ƽ�ϼ���
				ps.setInt(3, reservationLine.getAmount());//�Ѱ��� �������� ����� ���� * Ƽ�ϼ���
			}
		
		} finally {
			DBUtil.dbClose(null, ps , null);
		}
		return result;
	}
	

	/**
	 * ���� �ѱ��űݾ� ���ϱ�
	 * ����ȸ�� ���� price�� �������� adults �� ���� 10% ���εȴ�
	 * @param reservation 
	 * @param Visitors 
	 * */
	public int getTotalAmount(ReservationDTO reservation) throws SQLException {              
		int result = 0;
//		
//		if(visitAge.equals("adults")) {
//			result = (int)(price * 0.90);
//		}else if(visitAge.equals("youth")) {
//			result = (int)(price * 0.70);
//		}else if(visitAge.equals("kids")) {
//			result = (int)(price * 0.50);
//		}
//	
		return result;
	}
	

	/**
	 * ���ų��� ���
	 * */
	@Override
	public List<ReservationDTO> selectReservationByMemberId(String memberId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReservationDTO> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps= con.prepareStatement("select reservation_line_no, reservation_no, visit_age, ticket_qty, amount from reservation_line where reservation_no = ?");
			ps.setString(1, memberId);
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				ReservationDTO reservation  = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));

				//���Ź�ȣ�� �ش��ϴ� ������ ��������
				List<ReservationLineDTO> reservationLineList = selectReservationLine(reservation.getReservationNo());

				reservation.setReservationLineList(reservationLineList);
				list.add(reservation);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	/**
	 * �����ȣ�� �ش��ϴ� ���Ż� ��������
	 * */
	private List<ReservationLineDTO> selectReservationLine(int reservationNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select reservation_line_no, reservation_no, visit_age, ticket_qty, amount from reservation_line where reservation_no = ?";
		List<ReservationLineDTO> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reservationNo);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				ReservationLineDTO reservationLine = new ReservationLineDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)); 
				list.add(reservationLine);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return null;
	}
}
