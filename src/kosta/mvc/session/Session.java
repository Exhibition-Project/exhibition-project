package kosta.mvc.session;

import java.util.Map;

/**
 * 로그인 된 사용자 저장
 * */
public class Session {
	private int sessionNo;
	private String sessionId;
	private Map<String,Object> attributes; //장바구니

	public Session() {}
	public Session(int sessionNo, String sessionId) {
		super();
		this.sessionNo = sessionNo;
		this.sessionId = sessionId;
	}

	public int getSessionNo() {
		return sessionNo;
	}

	public void setSessionNo(int sessionNo) {
		this.sessionNo = sessionNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}


	//추가
	public void setAttribute(String name, Object value) {//cart , Map<Exhibition, Integer>
		attributes.put(name,value);//"cart" , Map<Exhibition, 수량>
	}

	//조회(Map에 key에 해당하는 value 찾기)
	public Object getAttribute(String name) {//cart
		return attributes.get(name);
	}

	//제거(장바구니를 비울대 사용한다)
	public void removeAttribute(String name) {//cart
		attributes.remove(name);
	}


	@Override
	public int hashCode() {
		return sessionId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof Session) {
			Session session = (Session)obj;
			if(this.sessionId.equals(session.sessionId)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Session [sessionNo=");
		builder.append(sessionNo);
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append("]");
		return builder.toString();
	}

}
