package modelo.persistencia;

import java.util.List;

import modelo.entidade.Usuario;
import modelo.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsuarioDao extends GenericoDao<Usuario> {
	public UsuarioDao() {
		super(Usuario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> consultar(Usuario u) {
		Session s = HibernateUtil.currentSession();
		Criteria c = s.createCriteria(Usuario.class);
		c.add(Restrictions.like("login",u.getLogin()));
		c.add(Restrictions.like("senha",u.getSenha()));
		return c.list();
	}
}
