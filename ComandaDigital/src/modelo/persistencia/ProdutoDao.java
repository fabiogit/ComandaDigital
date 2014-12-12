package modelo.persistencia;

import modelo.entidade.Produto;

public class ProdutoDao extends GenericoDao<Produto> {
	public ProdutoDao() {
		super(Produto.class);
	}
}
