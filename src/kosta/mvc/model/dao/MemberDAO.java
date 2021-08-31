package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.MemberDTO;
/**
 * @author �ڼ���
 */
public interface MemberDAO {

	/**
	 * �α���
	 * @param id
	 * @param password
	 * @return ȸ�� �α���
	 * @throws SQLException
	 */
	public MemberDTO login(String id, String password) throws SQLException;

	/**
	 * ȸ�� �ߺ���ȸ
	 * @param id
	 * @return ȸ�� �ߺ�üũ
	 */
	public int getMemberId(String id);

	/**
	 * ȸ������
	 * @param memberDTO
	 * @return ȸ������
	 * @throws SQLException
	 */
	public int insertMembership(MemberDTO memberDTO) throws SQLException;

	/**
	 * ȸ������ ����
	 * @param sessionNo
	 * @param updatememDto
	 * @return ������ ȸ������ ���ڵ�
	 * @throws SQLException
	 */
	public int updateMember(int sessionNo, MemberDTO updatememDto) throws SQLException;

	/**
	 * ȸ������ ��ȸ
	 * @param memberNo
	 * @param memberID
	 * @return ȸ������ ��ȸ
	 * @throws SQLException
	 */
	public MemberDTO selectMemberInformation(int memberNo, String memberID) throws SQLException;

	/**
	 * ���� ��й�ȣ üũ
	 * @param sessionNo
	 * @param confirmPassword
	 * @return
	 * @throws SQLException
	 */
	public int checkPassword(int sessionNo, String confirmPassword) throws SQLException;

}
