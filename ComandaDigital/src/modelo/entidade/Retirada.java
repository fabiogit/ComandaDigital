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
@Table(name = "retiradas")
public class Retirada implements Serializable {

	private static final long serialVersionUID = 4356216880434933564L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_retirada")
	private Integer idRetirada;

	@Column(name = "motivo", nullable = false)
	private String motivo;

	@Column(name = "valor_retirada", nullable = false)
	private Double valorRetirada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_retirada", nullable = false)
	private Date dataHoraRetirada;
	
	@ManyToOne
	@JoinColumn(name = "id_caixa", referencedColumnName = "id_caixa")
	private Caixa idCaixa;
}
