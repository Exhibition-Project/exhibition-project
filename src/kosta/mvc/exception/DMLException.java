package kosta.mvc.exception;

import java.sql.SQLException;

/**
 * ���, ����, ���� �������� ���
 * */
public class DMLException extends SQLException{
	public DMLException() {}
	public DMLException(String message) {
		super(message);
	}
}
