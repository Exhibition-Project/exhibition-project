package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.DMLException;
import kosta.mvc.model.dao.ReservationDAO;
import kosta.mvc.model.dao.ReservationDAOImpl;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
/**
 * @author 박은솔
 */
public class ReservationService {
	ReservationDAO reservationDao = new ReservationDAOImpl();
	MemberService memberService = new MemberService();
	
	/**
	 * 전시회 예매하기
	 * @param reservaton
	 * @throws Exception
	 */
	public void insertReservation(ReservationDTO reservaton) throws Exception{
		int memberNo =memberService.getSessionNo();
		
		reservaton.setMemberNo(memberNo);
		
		int result = reservationDao.reservationInsert(reservaton);
		if(result==0) throw new SQLException("예매하기가 실패했습니다.");
	}
	
	/**
	 * 예매내역보기 
	 * @return 로그인한 회원의 예매내역 리스트
	 * @throws SQLException
	 */
	public List<ReservationDTO> selctReservationByMemberNo() throws SQLException{
		int memberNo = memberService.getSessionNo();
		
		List<ReservationDTO> list = reservationDao.selectReservationByMemberNo(memberNo);
		if(list==null || list.size()==0) throw new SQLException("예매내역이 없습니다.");
		return list;
	}
	
	/**
	 * 전시회 번호로 예매내역 검색
	 * @return 번호에 해당하는 예매내역
	 * @throws SQLException
	 */
	public List<ReservationDTO> reservationSelectAll() throws SQLException{
		List<ReservationDTO> reservationList = reservationDao.reservationSelectAll();
		if(reservationList.size()==0 || reservationList == null) throw new SQLException("현재 찾고있는 예매내역이 존재하지 않습니다.");
		return reservationList;
	}	
	
	/**
	 * 예매번호로 예매내역 조회
	 * @param reservationNo
	 * @return 번호에 해당하는 예매내역 리스트
	 * @throws SQLException
	 */
	public List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException{
		List<ReservationLineDTO> reservationLine  = reservationDao.selectByReservationNo(reservationNo);
		if(reservationLine == null || reservationLine.isEmpty()) {
			throw new SQLException(reservationNo + "번호에 해당하는 예매내역이 존재하지 않습니다.");
		}
		return reservationLine;
	}

	/**
	 * 예매번호로 예매취소(삭졔)
	 * @param reservationNo
	 * @throws SQLException
	 */
	public void reservationDelete(int reservationNo)throws SQLException {
		int memberNo = memberService.getSessionNo();
		int result = reservationDao.reservationDelete(memberNo, reservationNo);
		if(result == 0) throw new DMLException("예매 취소에 실패했습니다.");
	}


}