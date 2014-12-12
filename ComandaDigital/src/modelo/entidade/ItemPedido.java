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
@Table(name = "itens_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = -6824774245348802523L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_item_pedido")
	private Integer idItemPedido;

	@Column(name = "quantidade", nullable = false)
	private Double quantidade;

	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;

	@Column(name = "status_item")
	private Boolean statusItem;

	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
	private Pedido idPedido;

	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
	private Produto idProduto;
}
