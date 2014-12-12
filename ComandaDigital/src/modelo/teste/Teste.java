package modelo.teste;

import java.util.List;

import modelo.entidade.Usuario;
import modelo.persistencia.UsuarioDao;

public class Teste {
	public static void main(String[] args) {
		Usuario u = new Usuario(null, "admin", "admin");
		UsuarioDao dao = new UsuarioDao();
		List<Usuario> usuarios = dao.consultar(u);
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuario encontrado");
		} else {
			for (Usuario c : usuarios) {
				System.out.println(c.getLogin());
			}
		}
	}
}
