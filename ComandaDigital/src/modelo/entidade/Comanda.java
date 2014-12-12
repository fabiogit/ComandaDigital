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
@Table(name = "comandas")
public class Comanda implements Serializable {

	private static final long serialVersionUID = 6671752551350528491L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_comanda")
	private Integer idComanda;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_comanda", nullable = false)
	private Date dataHoraComanda;

	@Column(name = "sub_total")
	private Double subTotal;

	@Column(name = "chave_acesso", nullable = false)
	private String chaveAcesso;
	
	@Column(name = "status_comanda")
	private Boolean statusComanda;

	@ManyToOne
	@JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
	private Mesa idMesa;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario idUsuario;
}
