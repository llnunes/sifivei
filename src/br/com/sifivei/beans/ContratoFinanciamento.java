package br.com.sifivei.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ContratoFinanciamento")
public class ContratoFinanciamento extends GenericEntity<Integer>{

	private static final long serialVersionUID = -1626890941409935512L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FINANCIAMENTO")
	@Getter @Setter
	private Integer id;
		
	@Column(name="NUM_FINANCIAMENTO")
	@Getter @Setter
	private Integer numeroFinanciamento;
	
	@JoinColumn(referencedColumnName="ID_CLIENTE", name="ID_CLIENTE")
	@ManyToOne
	@Getter @Setter
	private Cliente cliente;
	
	@JoinColumn(referencedColumnName="ID_VEICULO", name="ID_VEICULO")	
	@Getter @Setter
	private Veiculo veiculo;
	
	@Column(name="VALOR_BEM")
	@Getter @Setter
	private BigDecimal valorBem;
	
	@Column(name="VALOR_ENTRADA")
	@Getter @Setter
	private BigDecimal valorEntrada;
	
	@Column(name="NUMERO_PARCELAS")
	@Getter @Setter
	private Integer numeroParcelas;
	
	@Column(name="DATA_APROVACAO")
	@Getter @Setter
	private Date dataAprovacao;
	
	@Column(name="DATA_QUITACAO")
	@Getter @Setter
	private Date dataQuitacao;
	
	@Column(name="TAXA_JUROS")
	@Getter @Setter
	private Double taxaJuros;
}
