package kosta.mvc.exception;

import java.sql.SQLException;
/**
 * @author äâ��
 */
public class SearchNotFoundException extends SQLException{
	/**
	 * ã�����ϴ� ������ ã�� �� ���� ��� ����ó��
	 * */
	public SearchNotFoundException() {}
	public SearchNotFoundException(String message) {
		super(message);
	}
}
