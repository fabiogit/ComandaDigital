package modelo.persistencia;

import modelo.entidade.Categoria;

public class CategoriaDao extends GenericoDao<Categoria> {
	public CategoriaDao() {
		super(Categoria.class);
	}
}
