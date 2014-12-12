package modelo.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	//Configura��es do session-factory localizada no hinernat.cfg.xml
	private static final SessionFactory sessionFactory;
	private static AnnotationConfiguration cfg;
	
	static {
		System.out.println("Carregando hibernate.cfg.xml.");
		/* Configura��o do hibernate atrav�s do hibernate.cfg.xml */
		cfg = new AnnotationConfiguration();
		cfg.configure();
		
		/* Cria��o da fabrica de sessoes */
		sessionFactory = cfg.buildSessionFactory();
	}
	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		if (s != null && s.isOpen()) s.close();
		
		if (s == null || !s.isOpen()) {
			if (sessionFactory != null) {
				s = sessionFactory.openSession();
			}
    		session.set(s);
		}
		return s;
	}
	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null) {
			s.close();
		}
	}
	
}
