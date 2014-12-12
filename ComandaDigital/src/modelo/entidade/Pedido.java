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
@Table(name = "pedidos")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -8970332021873430397L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "observacoes")
	private String observacoes;

	@Column(name = "status_pedido")
	private Boolean statusPedido;

	@ManyToOne
	@JoinColumn(name = "id_comanda", referencedColumnName = "id_comanda")
	private Comanda idComanda;
}
