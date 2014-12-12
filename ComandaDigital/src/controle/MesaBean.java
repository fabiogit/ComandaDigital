package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import lombok.Setter;
import modelo.entidade.Mesa;
import modelo.persistencia.MesaDao;

@ManagedBean(name = "MesaBean")
@RequestScoped
public class MesaBean{

	@Setter
	private Mesa mesa;

	public Mesa getMesa() {
		if (mesa == null) {
			mesa = new Mesa();
		}
		return mesa;
	}

	public String incluirOuAlterar() {
		MesaDao dao = new MesaDao();
		dao.salvarOuAlterar(mesa);
		return "ListaMesa.xhtml";
	}

	public String excluir(Mesa c) {
		MesaDao dao = new MesaDao();
		dao.excluir(c);
		return "ListaMesa.xhtml";
	}

	public String alterar(Mesa c) {
		mesa = c;
		return "CadastroMesa.xhtml";
	}

	public List<Mesa> listarTodos() {
		MesaDao dao = new MesaDao();
		return dao.listarTodos();
	}
	
	public List<Mesa> listarDesocupadas(){
		MesaDao dao = new MesaDao();
		return dao.listarDesocupadas();
	}

	public String novo() {
		mesa = null;
		return "CadastroMesa.xhtml";
	}
	
	public List<SelectItem> getSelectMesas() {
		List<Mesa> list = listarDesocupadas();
		List<SelectItem> itens = new ArrayList<SelectItem>(list.size());
		for (Mesa m : list) {
			itens.add(new SelectItem(m.getIdMesa(),m.getNumero().toString() + " - " + m.getCapacidade() + " Pessoas"));
		}
		return itens;
	}
}
