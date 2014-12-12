package modelo.persistencia;

import modelo.entidade.Pedido;

public class PedidoDao extends GenericoDao<Pedido> {
	public PedidoDao() {
		super(Pedido.class);
	}
}
