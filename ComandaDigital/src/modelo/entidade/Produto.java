package modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = -3144928500369990936L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private Integer idProduto;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "exibir_cardapio")
	private Boolean exibirCardapio;

	@ManyToOne
	@JoinColumn(name = "id_unidade", referencedColumnName = "id_unidade")
	private Unidade idUnidade;

	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria idCategoria;
}
