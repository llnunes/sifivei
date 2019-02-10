package br.com.sifivei.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Cliente")
public class Cliente extends GenericEntity<Integer>{

	private static final long serialVersionUID = 7444501212723332642L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE")
	@Getter @Setter
	private Integer id;
		
	@Column(name="CPF")
	@Getter @Setter
	private String cpf;
	
	@Column(name="NOME")
	@Getter @Setter
	private String nome;
	
	@Column(name="RG")
	@Getter @Setter
	private String rg;

	@Column(name="CEP")
	@Getter @Setter
	private String cep;
	
	@Column(name="ENDERECO")
	@Getter @Setter
	private String endereco;
		
	@Column(name="MUNICIPIO")
	@Getter @Setter
	private String municipio;
	
	@Column(name="UF")
	@Getter @Setter
	private String uf;
	
	@Column(name="VL_RENDA")
	@Getter @Setter
	private BigDecimal valorRenda;	

}
