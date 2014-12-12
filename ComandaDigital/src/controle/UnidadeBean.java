package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import lombok.Setter;
import modelo.entidade.Unidade;
import modelo.persistencia.UnidadeDao;

@ManagedBean(name = "UnidadeBean")
@RequestScoped
public class UnidadeBean {
	@Setter
	private Unidade unidade;

	public Unidade getUnidade() {
		if (unidade == null) {
			unidade = new Unidade();
		}
		return unidade;
	}

	public String incluirOuAlterar() {
		UnidadeDao dao = new UnidadeDao();
		dao.salvarOuAlterar(unidade);
		return "ListaUnidade.xhtml";
	}

	public String excluir(Unidade u) {
		UnidadeDao dao = new UnidadeDao();
		dao.excluir(u);
		return "ListaUnidade.xhtml";
	}

	public String alterar(Unidade u) {
		unidade = u;
		return "CadastroUnidade.xhtml";
	}

	public List<Unidade> listarTodos() {
		UnidadeDao dao = new UnidadeDao();
		return dao.listarTodos();
	}

	public List<SelectItem> getSelectUnidades() {
		List<Unidade> list = listarTodos();
		List<SelectItem> itens = new ArrayList<SelectItem>(list.size());
		for (Unidade u : list) {
			itens.add(new SelectItem(u.getIdUnidade(), u.getDescricao()));
		}
		return itens;
	}

	public String novo() {
		unidade = null;
		return "CadastroUnidade.xhtml";
	}
}
