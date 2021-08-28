package kosta.mvc.exception;

import java.sql.SQLException;

/**
 * 등록, 수정, 삭제 실패했을 경우
 * */
public class DMLException extends SQLException{
	public DMLException() {}
	public DMLException(String message) {
		super(message);
	}
}
