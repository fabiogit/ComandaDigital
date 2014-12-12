package modelo.persistencia;

import java.util.List;

import modelo.entidade.Mesa;
import modelo.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class MesaDao extends GenericoDao<Mesa> {
	public MesaDao() {
		super(Mesa.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> listarDesocupadas() {
		Session s = HibernateUtil.currentSession();
		Criteria c = s.createCriteria(Mesa.class);
		c.add(Restrictions.like("ocupada", false));
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> buscar(Mesa x) {
		Session s = HibernateUtil.currentSession();
		Criteria c = s.createCriteria(Mesa.class);
		c.add(Restrictions.eq("idMesa", x.getIdMesa()));
		return c.list();
	}
}
