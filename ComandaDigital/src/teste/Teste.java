package teste;

import java.util.List;

import modelo.entidade.Mesa;
import modelo.persistencia.MesaDao;



public class Teste {

	public static void main(String[] args) {
			MesaDao dao = new MesaDao();
			Mesa m = new Mesa(1, 1, false, 4);
			List<Mesa> lista = dao.buscar(m);
			lista.get(0).setOcupada(false);
			dao.salvarOuAlterar(lista.get(0));
			
		}
	}
