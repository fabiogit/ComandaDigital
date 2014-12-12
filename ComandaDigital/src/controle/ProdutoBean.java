package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Setter;
import modelo.entidade.Categoria;
import modelo.entidade.Produto;
import modelo.entidade.Unidade;
import modelo.persistencia.ProdutoDao;

@ManagedBean(name = "ProdutoBean")
@RequestScoped
public class ProdutoBean {
	@Setter
	private Produto produto;
	
	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
			produto.setIdUnidade(new Unidade());
			produto.setIdCategoria(new Categoria());
		}
		return produto;
	}

	public String incluirOuAlterar() {
		ProdutoDao dao = new ProdutoDao();
		dao.salvarOuAlterar(produto);
		return "ListaProduto.xhtml";
	}

	public String excluir(Produto p) {
		ProdutoDao dao = new ProdutoDao();
		dao.excluir(p);
		return "ListaProduto.xhtml";
	}

	public String alterar(Produto p) {
		produto = p;
		return "CadastroProduto.xhtml";
	}

	public List<Produto> listarTodos() {
		ProdutoDao dao = new ProdutoDao();
		return dao.listarTodos();
	}
	
	public String novo() {
		produto = null;
		return "CadastroProduto.xhtml";
	}
}
