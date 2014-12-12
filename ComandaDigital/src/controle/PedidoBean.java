package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Setter;
import modelo.entidade.Comanda;
import modelo.entidade.Pedido;
import modelo.persistencia.PedidoDao;

@ManagedBean(name = "PedidoBean")
@RequestScoped
public class PedidoBean {
	@Setter
	private Pedido pedido;
	
	public Pedido getPedido() {
		if (pedido == null) {
			pedido = new Pedido(null, null, true, new Comanda());
		}
		return pedido;
	}

	public String incluirOuAlterar() {
		PedidoDao dao = new PedidoDao();
		dao.salvarOuAlterar(pedido);
		return "ListaProduto.xhtml";
	}

	public String excluir(Pedido p) {
		PedidoDao dao = new PedidoDao();
		dao.excluir(p);
		return "ListaProduto.xhtml";
	}

	public String alterar(Pedido p) {
		pedido = p;
		return "CadastroProduto.xhtml";
	}

	public List<Pedido> listarTodos() {
		PedidoDao dao = new PedidoDao();
		return dao.listarTodos();
	}
	
	public String novo() {
		pedido = null;
		return "CadastroProduto.xhtml";
	}
	
	
	
}
