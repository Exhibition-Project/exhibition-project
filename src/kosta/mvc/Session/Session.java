package kosta.mvc.Session;
/**
 * 로그인 된 사용자 저장
 * */
public class Session {
	private int sessionNo;
	private String sessionId;
	
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
