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
@Table(name = "unidades")
public class Unidade implements Serializable {

	private static final long serialVersionUID = 7761058738863830529L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_unidade")
	private Integer idUnidade;

	@Column(name = "descricao", nullable = false)
	private String descricao;
}
