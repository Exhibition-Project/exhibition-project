package kosta.mvc.exception;

import java.sql.SQLException;

/**
 * ã�����ϴ� ������ ã�� �� ���� ���
 * */
public class SearchNotFoundException extends SQLException{
	public SearchNotFoundException() {}
	public SearchNotFoundException(String message) {
		super(message);
	}
}
