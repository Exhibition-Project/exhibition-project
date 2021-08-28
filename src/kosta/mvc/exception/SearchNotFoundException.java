package kosta.mvc.exception;

import java.sql.SQLException;

/**
 * 찾고자하는 정보를 찾을 수 없는 경우
 * */
public class SearchNotFoundException extends SQLException{
	public SearchNotFoundException() {}
	public SearchNotFoundException(String message) {
		super(message);
	}
}
