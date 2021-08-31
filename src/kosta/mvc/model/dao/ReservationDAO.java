package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
/**
 * @author 박은솔
 */
public interface ReservationDAO {

	/**
	 * 예약하기 
	 * 	1) 테이블에 insert
	 * 	2) reservation_line테이블에 insert
	 * @param Reservation
	 * @return 전시회 예약된 레코드 
	 * @throws Exception
	 */
	int reservationInsert(ReservationDTO Reservation) throws Exception;

	/**
	 * 로그인 한 회원에 맞는 예매내역보기
	 * @param memberNo
	 * @return 해당 회원의 예매내역
	 * @throws SQLException
	 */
	List<ReservationDTO> selectReservationByMemberNo(int memberNo) throws SQLException;

	/**
	 * 예매내역 전체 검색
	 * @return 예매내역 전체 리스트 
	 * @throws SQLException
	 */
	List<ReservationDTO> reservationSelectAll() throws SQLException;

	/**
	 * 예매번호로 예매내역 조회
	 * @param reservationNo
	 * @return 예매번호에 해당하는 예매내역
	 * @throws SQLException
	 */
	List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException;

	/**
	 * 예매내역 취소(삭제)
	 * @param reservationNo
	 * @return 예매번호에 해당하는 예매내역 레코드 삭제
	 * @throws SQLException
	 */
	int reservationDelete(int memberNo, int reservationNo) throws SQLException;
}
	

