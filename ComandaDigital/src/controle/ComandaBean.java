package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import lombok.Setter;
import modelo.entidade.Comanda;
import modelo.entidade.Mesa;
import modelo.entidade.Usuario;
import modelo.persistencia.ComandaDao;
import modelo.persistencia.MesaDao;

@ManagedBean(name = "ComandaBean")
@RequestScoped
public class ComandaBean {

	@Setter
	private Comanda comanda;
	
	public Comanda getComanda() {
		if (comanda == null) {
			comanda = new Comanda(null, null, null, geraChave(), true, new Mesa(), new Usuario(1, null, null));
		}
		return comanda;
	}
	
	public String incluirOuAlterar() {
		ComandaDao dao = new ComandaDao();
		dao.salvarOuAlterar(comanda);
		tornaMesaOcupada(comanda.getIdMesa(), true);
		return "ListaComanda.xhtml";
	}

	public String excluir(Comanda c) {
		tornaMesaOcupada(c.getIdMesa(), false);
		ComandaDao dao = new ComandaDao();
		dao.excluir(c);
		return "ListaComanda.xhtml";
	}

	public String alterar(Comanda c) {
		comanda = c;
		return "CadastroComanda.xhtml";
	}

	public List<Comanda> listarTodos() {
		ComandaDao dao = new ComandaDao();
		return dao.listarTodos();
	}
	
	public List<Comanda> listarAbertas() {
		ComandaDao dao = new ComandaDao();
		return dao.listarAbertas();
	}

	public String novo() {
		comanda = null;
		return "CadastroComanda.xhtml";
	}
	
	public String geraChave(){
		Integer i = (int) (1000 + Math.random() * 8999);
		return i.toString();
	}
	
	public void tornaMesaOcupada(Mesa m,boolean b){
		MesaDao dao = new MesaDao();
		List<Mesa> lista = dao.buscar(m);
		lista.get(0).setOcupada(b);
		dao.salvarOuAlterar(lista.get(0));
	}
	
	public List<SelectItem> getSelectComandas() {
		List<Comanda> list = listarAbertas();
		List<SelectItem> itens = new ArrayList<SelectItem>(list.size());
		for (Comanda c : list) {
			itens.add(new SelectItem(c.getIdComanda(),"Cod: " + c.getIdComanda().toString() +" - Mesa: " + c.getIdMesa().getNumero()));
		}
		return itens;
	}
}
