package kosta.mvc.exception;

import java.sql.SQLException;
/**
 * @author äâ��
 */
public class DMLException extends SQLException{
	/**
	 * ���, ����, ���� �������� ��� ����ó��
	 * */
	public DMLException() {}
	public DMLException(String message) {
		super(message);
	}
}
