package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Setter;
import modelo.entidade.Usuario;
import modelo.persistencia.UsuarioDao;

@ManagedBean(name = "UsuarioBean")
@RequestScoped
public class UsuarioBean {

	@Setter
	private Usuario usuario;

	public Usuario getusuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public String incluirOuAlterar() {
		UsuarioDao dao = new UsuarioDao();
		dao.salvarOuAlterar(usuario);
		return "ListaUsuario.xhtml";
	}

	public String excluir(Usuario c) {
		UsuarioDao dao = new UsuarioDao();
		dao.excluir(c);
		return "ListaUsuario.xhtml";
	}

	public String alterar(Usuario c) {
		usuario = c;
		return "CadastroUsuario.xhtml";
	}

	public List<Usuario> listarTodos() {
		UsuarioDao dao = new UsuarioDao();
		return dao.listarTodos();
	}

	public String novo() {
		usuario = null;
		return "CadastroUsuario.xhtml";
	}

}
