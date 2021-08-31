package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.DiscountDTO;
import kosta.mvc.model.dto.ExhibitionDTO;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.util.DBUtil;

public class ReservationDAOImpl implements ReservationDAO{
	private Properties proFile = DBUtil.getProFile();

	ExhibitionDAO exhibitionDao = new ExhibitionDAOImpl();

	/**
	 * �����ϱ� 
	 * 	1) ���̺� insert
	 * 	2) reservaion_line���̺� insert
	 * */
	@Override
	public int reservationInsert(ReservationDTO reservation) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("reservation.insert");
		int result = 0;
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date regdate = sdf.parse(reservation.getRegDate());
		int exhibitionNo = reservation.getExhibitionNo();
		Date startDate = sdf.parse(exhibitionDao.exhibitionSelectByNo(exhibitionNo).getStartDate());
		Date endDate = sdf.parse(exhibitionDao.exhibitionSelectByNo(exhibitionNo).getEndDate());

		if(regdate.compareTo(startDate) < 0 || regdate.compareTo(endDate) > 0) {
			throw new Exception("����ȸ �Ⱓ�� �´� ��¥�� �Է����ּ���.");
		}
			
			
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
	 * ����� ����ϱ�
	 * */
	private int[] reservationLineInsert(Connection con, ReservationDTO reservation) throws SQLException{
		PreparedStatement ps = null;
		String sql = proFile.getProperty("reservation_line.insert");
		int result [] = null;
		try {
			ps = con.prepareStatement(sql);
			for(ReservationLineDTO reservationLine : reservation.getReservationLineList()) {
				
				ps.setString(1, reservationLine.getVisitAge());//��������
				ps.setInt(2, reservationLine.getTicketQty());//Ƽ�ϼ���
				ps.setInt(3, reservationLine.getAmount());//�Ѱ��� �������� ����� ���� * Ƽ�ϼ���
				
				ps.addBatch();
				ps.clearParameters();
			}
			
			result = ps.executeBatch();
		
		} finally {
			DBUtil.dbClose(null, ps , null);
		}
		return result;
	}
	
	
	/**
	 * ���� �ѱ��űݾ� ���ϱ�
	 * ����ȸ�� ���� price�� �������� adults �� ���� 10% ���εȴ�
	 * */
	public int getTotalAmount(ReservationDTO reservation) throws SQLException {          
		List<ReservationLineDTO> reservationLineList = reservation.getReservationLineList();
		ExhibitionDTO exhibition = exhibitionDao.exhibitionSelectByNo(reservation.getExhibitionNo());
		int price = exhibition.getPrice();//����ȸ����
		int total = 0;
		for(ReservationLineDTO line : reservationLineList) {
			
			// ���ɿ� �ش��ϴ� ������ �˻��ϱ� select visit_age, discount_rate from discount where visit_age = ?;
			String visitAge = line.getVisitAge();
			// �������ɿ� �ش��ϴ� ������ �����ͼ� ���
			int discountRate = this.getDiscount(visitAge);
			System.out.println("Ƽ�ϼ��� : "+ line.getTicketQty() +" | ������ "+discountRate + " % | " + price+ "��");
			int amount = (int)((price - price * discountRate * 0.01) * line.getTicketQty());
			total += amount;
			line.setAmount(amount);
		}
		System.out.println("�� ���űݾ� = " + total);
		return total;
	}
	
	
	/**
	 * �������ɿ� �ش��ϴ� ������ ��������
	 * */ 
	public int getDiscount(String visitAge)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select discount_rate from discount where visit_age = ?";
		int discountRate = 0;
		try {
			con = DBUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setString(1, visitAge);
			rs = ps.executeQuery(); 
		     if(rs.next()) {
		    	 discountRate = rs.getInt(1);
		     }
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return discountRate;
	}
	

	/**
	 * �α��� �� ����� �´� ���ų��� ���
	 * */
	@Override
	public List<ReservationDTO> selectReservationByMemberNo(int memberNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql = proFile.getProperty("reservation.selectByMemberNo");
		List<ReservationDTO> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setInt(1, memberNo);
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				ReservationDTO reservation  = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));

				//���Ź�ȣ�� �ش��ϴ� ������ ��������
				List<ReservationLineDTO> reservationLineList = selectReservationLine(con, reservation.getReservationNo());
				
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
	private List<ReservationLineDTO> selectReservationLine(Connection con, int reservationNo) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("reservation_line.selectByReservationNo");
		List<ReservationLineDTO> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, reservationNo);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				ReservationLineDTO reservationLine = new ReservationLineDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)); 
				list.add(reservationLine);
			}
		} finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return list;
	}

	
	/**
	 * ���ų��� ��ü �˻�
	 * */
	@Override
	public List<ReservationDTO> reservationSelectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReservationDTO> reservationList = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("reservation.selectAll"));
			rs = ps.executeQuery();

			while(rs.next()) {
				ReservationDTO reservationDTO = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				reservationList.add(reservationDTO);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return reservationList;
	}

	/**
	 * ���Ź�ȣ�� ��ȸ
	 * */
	@Override
	public List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReservationLineDTO> reservationLineList = new ArrayList<ReservationLineDTO>();
		String sql = proFile.getProperty("reservation_line.selectByReservationNo");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reservationNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservationLineDTO reservationLineDTO = new ReservationLineDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				reservationLineList.add(reservationLineDTO);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return reservationLineList;
	}



	/**
	 * ���� ���(����)
	 * 	1) ���Ż� reservation_line.delete
	 * 	2) reservation.delete
	 * */
	@Override
	public int reservationDelete(int reservationNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("reservation.delete");
		int result = 0;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);

				int re = reservationLineDelete(con, reservationNo);//���Ż� �����ϱ�
				 if(re==0) {
						con.rollback();
						throw new SQLException("���Ÿ� ����� �� �����ϴ�.");
				 }else {
					ps = con.prepareStatement(sql);
					ps.setInt(1, reservationNo);
					result = ps.executeUpdate();
					if(result==0) {
						con.rollback();
						throw new SQLException("������Ұ� �����߽��ϴ�");
					}		
				 }
				
				con.commit();
			
		}finally {
			con.commit();
			DBUtil.dbClose(con, ps, null);
		}
		
		return result;
	}

	/**
	 * ����� �����ϱ�
	 * */
	private int reservationLineDelete(Connection con, int reservationNo) throws SQLException{
		PreparedStatement ps = null;
		String sql = proFile.getProperty("reservation_line.delete");
		int result  = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, reservationNo);
			
			result = ps.executeUpdate();

		} finally {
			DBUtil.dbClose(null, ps , null);
		}
		return result;
	}


}