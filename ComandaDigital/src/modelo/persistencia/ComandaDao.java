package modelo.persistencia;

import java.util.List;

import modelo.entidade.Comanda;
import modelo.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ComandaDao extends GenericoDao<Comanda> {
	public ComandaDao() {
		super(Comanda.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Comanda> listarAbertas() {
		Session s = HibernateUtil.currentSession();
		Criteria c = s.createCriteria(Comanda.class);
		c.add(Restrictions.like("statusComanda", true));
		return c.list();
	}
}
