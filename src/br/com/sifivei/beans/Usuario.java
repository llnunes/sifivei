package br.com.sifivei.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Usuario")
public class Usuario extends GenericEntity<Integer>{

	private static final long serialVersionUID = -7993962811757588079L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	@Getter @Setter
	private Integer id;
	
	@Column(name="LOGIN")
	@Getter @Setter
	private String login;
	
	@Column(name="NOME")
	@Getter @Setter
	private String nome;
	
	@Column(name="SEXO")
	@Getter @Setter
	private String sexo;
	
	@Column(name="SENHA")
	@Getter @Setter
	private String senha;

}
