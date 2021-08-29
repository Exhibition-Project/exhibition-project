package kosta.mvc.session;
//�α��� �� ����� ����

import java.util.HashSet;
import java.util.Set;

/**
 * �̱��� ���� ����
 * */
public class SessionSet {
	
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
