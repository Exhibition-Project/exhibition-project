package kosta.mvc.session;

import java.util.HashSet;
import java.util.Set;
/**
 * @author äâ��
 */
public class SessionSet {
	/**
	 * �α��� �� ����� ����(�̱��� ���� ����)
	 * */
	private static SessionSet ss = new SessionSet();
	private Set<Session> set;
	
	private SessionSet() {
		this.set = new HashSet<Session>();
	}
	
	/**
	 * SessionSet ��ü ��� �޼ҵ� 
	 * */
	public static SessionSet getInstance() {
		return ss;
	}
	
	/**
	 * ����� ã��
	 * */
	public Session get(String sessionId) {//�α��ε� ���̵� ���ͼ� ��ü ã��
		for(Session session : set) {
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
	
	
	/**
	 * ���� ��� ���� ��� �޼ҵ� 
	 * */
	public Set<Session> getSessionSet() {
		return set;
	}
	
	/**
	 * �α��ν� ���� ��Ͽ� ����� �߰�
	 * */
	public void addSession(Session session) {
		set.add(session);
	}
	
	/**
	 * �α׾ƿ��� ���� ��� ���տ��� ����
	 * */
	public void removeSession(Session session) {
		set.remove(session);
	}
	
}
