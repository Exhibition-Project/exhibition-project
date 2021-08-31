package kosta.mvc.exception;

import java.sql.SQLException;
/**
 * @author 채창완
 */
public class SearchNotFoundException extends SQLException{
	/**
	 * 찾고자하는 정보를 찾을 수 없는 경우 예외처리
	 * */
	public SearchNotFoundException() {}
	public SearchNotFoundException(String message) {
		super(message);
	}
}
