package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;
import modelo.entidade.Usuario;
import modelo.persistencia.UsuarioDao;

@ManagedBean(name = "AcessoBean")
@SessionScoped
public class AcessoBean {
	@Setter
	@Getter
	private Usuario usuarioSessao = new Usuario();

	public String logar() {
		UsuarioDao dao = new UsuarioDao();
		if (dao.consultar(usuarioSessao).isEmpty()) {
			return "index.xhtml";
		}
		return "nada";
	}
	
	public boolean confere(){
		UsuarioDao dao = new UsuarioDao();
		return !dao.consultar(usuarioSessao).isEmpty();
	}
}
