package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.exception.DMLException;
import kosta.mvc.model.dao.ReservationDAO;
import kosta.mvc.model.dao.ReservationDAOImpl;
import kosta.mvc.model.dto.ReservationDTO;
import kosta.mvc.model.dto.ReservationLineDTO;
/**
 * @author ������
 */
public class ReservationService {
	ReservationDAO reservationDao = new ReservationDAOImpl();
	MemberService memberService = new MemberService();
	
	/**
	 * ����ȸ �����ϱ�
	 * @param reservaton
	 * @throws Exception
	 */
	public void insertReservation(ReservationDTO reservaton) throws Exception{
		int memberNo =memberService.getSessionNo();
		
		reservaton.setMemberNo(memberNo);
		
		int result = reservationDao.reservationInsert(reservaton);
		if(result==0) throw new SQLException("�����ϱⰡ �����߽��ϴ�.");
	}
	
	/**
	 * ���ų������� 
	 * @return �α����� ȸ���� ���ų��� ����Ʈ
	 * @throws SQLException
	 */
	public List<ReservationDTO> selctReservationByMemberNo() throws SQLException{
		int memberNo = memberService.getSessionNo();
		
		List<ReservationDTO> list = reservationDao.selectReservationByMemberNo(memberNo);
		if(list==null || list.size()==0) throw new SQLException("���ų����� �����ϴ�.");
		return list;
	}
	
	/**
	 * ����ȸ ��ȣ�� ���ų��� �˻�
	 * @return ��ȣ�� �ش��ϴ� ���ų���
	 * @throws SQLException
	 */
	public List<ReservationDTO> reservationSelectAll() throws SQLException{
		List<ReservationDTO> reservationList = reservationDao.reservationSelectAll();
		if(reservationList.size()==0 || reservationList == null) throw new SQLException("���� ã���ִ� ���ų����� �������� �ʽ��ϴ�.");
		return reservationList;
	}	
	
	/**
	 * ���Ź�ȣ�� ���ų��� ��ȸ
	 * @param reservationNo
	 * @return ��ȣ�� �ش��ϴ� ���ų��� ����Ʈ
	 * @throws SQLException
	 */
	public List<ReservationLineDTO> selectByReservationNo(int reservationNo) throws SQLException{
		List<ReservationLineDTO> reservationLine  = reservationDao.selectByReservationNo(reservationNo);
		if(reservationLine == null || reservationLine.isEmpty()) {
			throw new SQLException(reservationNo + "��ȣ�� �ش��ϴ� ���ų����� �������� �ʽ��ϴ�.");
		}
		return reservationLine;
	}

	/**
	 * ���Ź�ȣ�� �������(����)
	 * @param reservationNo
	 * @throws SQLException
	 */
	public void reservationDelete(int reservationNo)throws SQLException {
		int memberNo = memberService.getSessionNo();
		int result = reservationDao.reservationDelete(memberNo, reservationNo);
		if(result == 0) throw new DMLException("���� ��ҿ� �����߽��ϴ�.");
	}


}