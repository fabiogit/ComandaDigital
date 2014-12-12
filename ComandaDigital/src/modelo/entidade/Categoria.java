package modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

	private static final long serialVersionUID = -6272767055355996295L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_categoria")
	private Integer idCategoria;

	@Column(name = "descricao", nullable = false)
	private String descricao;
}
