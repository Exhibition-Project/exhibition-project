package kosta.mvc.session;

import java.util.HashSet;
import java.util.Set;
/**
 * @author 채창완
 */
public class SessionSet {
	/**
	 * 로그인 된 사용자 저장(싱글톤 패턴 적용)
	 * */
	private static SessionSet ss = new SessionSet();
	private Set<Session> set;
	
	private SessionSet() {
		this.set = new HashSet<Session>();
	}
	

	public static SessionSet getInstance() {
		return ss;
	}
	
	/**
	 * 로그인된 아이디로 세션 찾기
	 * @param sessionId
	 * @return session
	 */
	public Session get(String sessionId) {//로그인된 아이디를 들고와서 객체 찾기
		for(Session session : set) {
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
	
	
	public Set<Session> getSessionSet() {
		return set;
	}
	
	/**
	 * 로그인시 세션 목록에 사용자 추가
	 * @param session 
	 * */
	public void addSession(Session session) {
		set.add(session);
	}
	
	/**
	 * 로그아웃시 세션 목록 집합에서 삭제
	 * @param session
	 * */
	public void removeSession(Session session) {
		set.remove(session);
	}
	
}
