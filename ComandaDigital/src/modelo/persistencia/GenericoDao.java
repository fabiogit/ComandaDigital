package modelo.persistencia;

import java.util.List;

import modelo.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericoDao<Tipo> {
	
	Class<Tipo> clazz;
	
	protected GenericoDao(Class<Tipo> clazz) {
		this.clazz = clazz;
	}
	
	public void salvarOuAlterar(Tipo x) {
		//Obter uma se��o
		Session s = HibernateUtil.currentSession();
		//Abrir uma transa��o
		Transaction t = s.beginTransaction();
		//Salva o objeto
		s.saveOrUpdate(x);
		//Comitou
		t.commit();
	}
	public void excluir(Tipo x) {
		Session s = HibernateUtil.currentSession();
		Transaction t = s.beginTransaction();
		s.delete(x);
		t.commit();
	}
	@SuppressWarnings("unchecked")
	public List<Tipo> listarTodos() {
		Session s = HibernateUtil.currentSession();
		// criteria(Orientado a objeto), hql, sql(n�o orientado a objeto) s�o
		// formas de consulta do hibernate
		//class objeto q representa o metadados da classe, ele � do tipo class
		return s.createCriteria(clazz).list();
	}
	
}
