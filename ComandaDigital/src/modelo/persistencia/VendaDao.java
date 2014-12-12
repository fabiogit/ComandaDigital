package modelo.persistencia;

import modelo.entidade.Venda;

public class VendaDao extends GenericoDao<Venda> {
	public VendaDao() {
		super(Venda.class);
	}
}
