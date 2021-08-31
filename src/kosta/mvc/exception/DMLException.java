package kosta.mvc.exception;

import java.sql.SQLException;
/**
 * @author 채창완
 */
public class DMLException extends SQLException{
	/**
	 * 등록, 수정, 삭제 실패했을 경우 예외처리
	 * */
	public DMLException() {}
	public DMLException(String message) {
		super(message);
	}
}
