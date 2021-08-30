package kosta.mvc.session;

import java.util.Map;

/**
 * �α��� �� ����� ����
 * */
public class Session {
	private int sessionNo;
	private String sessionId;
	private Map<String,Object> attributes; //��ٱ���

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


	//�߰�
	public void setAttribute(String name, Object value) {//cart , Map<Exhibition, Integer>
		attributes.put(name,value);//"cart" , Map<Exhibition, ����>
	}

	//��ȸ(Map�� key�� �ش��ϴ� value ã��)
	public Object getAttribute(String name) {//cart
		return attributes.get(name);
	}

	//����(��ٱ��ϸ� ���� ����Ѵ�)
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
