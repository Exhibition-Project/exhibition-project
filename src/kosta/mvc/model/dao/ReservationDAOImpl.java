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
	 * 예약하기 
	 * 	1) 테이블에 insert
	 * 	2) order_line테이블에 insert
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
			
			ps.setInt(1, reservation.getMemberNo());//회원번호
			ps.setInt(2, reservation.getExhibitionNo());//전시회번호
			ps.setInt(3, getTotalAmount(reservation));//총구매금액 구하는 메소드 호출
			ps.setString(4, reservation.getRegDate());//예매할 날짜
			
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("예매가 실패했습니다");
			}else {
				int re [] = reservationLineInsert(con, reservation);//예매상세 등록하기
				for(int i : re) {
					if(i != 1) {
						con.rollback();
						throw new SQLException("예약할 수 없습니다.");
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
	 * 예약 상세등록하기
	 * */
	private int[] reservationLineInsert(Connection con, ReservationDTO reservation) throws SQLException{
		PreparedStatement ps = null;
		String sql = "insert into reservation_line values(RESERVATION_LINE_NO_SEQ.nextval, reservation_no_seq.currval, ?, ?, ?)";
		int result [] = null;
		try {
			ps = con.prepareStatement(sql);
			for(ReservationLineDTO reservationLine : reservation.getReservationLineList()) {
				ps.setString(1, reservationLine.getVisitAge());//관람연령
				ps.setInt(2, reservationLine.getTicketQty());//티켓수량
				ps.setInt(3, reservationLine.getAmount());//총가격 할인율이 적용된 가격 * 티켓수량
			}
		
		} finally {
			DBUtil.dbClose(null, ps , null);
		}
		return result;
	}
	

	/**
	 * 예약 총구매금액 구하기
	 * 전시회의 가격 price가 관람연령 adults 에 따라 10% 할인된다
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
	 * 예매내역 출력
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

				//예매번호에 해당하는 상세정보 가져오기
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
	 * 예약번호에 해당하는 예매상세 가져오기
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
