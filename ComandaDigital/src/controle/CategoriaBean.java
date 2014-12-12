package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import lombok.Setter;
import modelo.entidade.Categoria;
import modelo.persistencia.CategoriaDao;

@ManagedBean(name = "CategoriaBean")
@RequestScoped
public class CategoriaBean {
	@Setter
	private Categoria categoria;

	public Categoria getCategoria() {
		if (categoria == null) {
			categoria = new Categoria();
		}
		return categoria;
	}

	public String incluirOuAlterar() {
		CategoriaDao dao = new CategoriaDao();
		dao.salvarOuAlterar(categoria);
		return "ListaCategoria.xhtml";
	}

	public String excluir(Categoria c) {
		CategoriaDao dao = new CategoriaDao();
		dao.excluir(c);
		return "ListaCategoria.xhtml";
	}

	public String alterar(Categoria c) {
		categoria = c;
		return "CadastroCategoria.xhtml";
	}

	public List<Categoria> listarTodos() {
		CategoriaDao dao = new CategoriaDao();
		return dao.listarTodos();
	}

	public List<SelectItem> getSelectCategorias() {
		List<Categoria> list = listarTodos();
		List<SelectItem> itens = new ArrayList<SelectItem>(list.size());
		for (Categoria c : list) {
			itens.add(new SelectItem(c.getIdCategoria(), c.getDescricao()));
		}
		return itens;
	}

	public String novo() {
		categoria = null;
		return "CadastroCategoria.xhtml";
	}
}
