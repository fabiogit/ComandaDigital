package modelo.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vendas")
public class Venda implements Serializable {

	private static final long serialVersionUID = -1576432088229438079L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_venda")
	private Integer idVenda;

	@Column(name = "acrescimo")
	private Double acrescimo;

	@Column(name = "desconto")
	private Double desconto;

	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_venda", nullable = false)
	private Date dataHoraVenda;

	@ManyToOne
	@JoinColumn(name = "id_comanda", referencedColumnName = "id_comanda")
	private Comanda idComanda;

	@ManyToOne
	@JoinColumn(name = "id_forma_pagamento", referencedColumnName = "id_forma_pagamento")
	private FormaPagamento idFormaPagamento;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario idUsuario;
	
	@ManyToOne
	@JoinColumn(name = "id_caixa", referencedColumnName = "id_caixa")
	private Caixa id_caixa;
}
