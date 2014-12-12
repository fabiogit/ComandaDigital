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
@Table(name = "caixas")
public class Caixa implements Serializable {

	private static final long serialVersionUID = 2763120239209021550L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_caixa")
	private Integer idCaixa;

	@Column(name = "saldo_inicial")
	private Double saldoInicial;

	@Column(name = "saldo_atual")
	private Double saldoAtual;
}
