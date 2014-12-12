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
@Table(name = "mesas")
public class Mesa implements Serializable {

	private static final long serialVersionUID = -3769753105624548002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_mesa")
	private Integer idMesa;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "ocupada")
	private Boolean ocupada;

	@Column(name = "capacidade")
	private Integer capacidade;
}
