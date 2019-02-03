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
@Table(name="Veiculo")
public class Veiculo extends GenericEntity<Integer>{

	private static final long serialVersionUID = 4910628769581953576L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VEICULO")
	@Getter @Setter
	private Integer id;
	
	@Column(name="PLACA_VEICULO")
	@Getter @Setter
	private String placaVeiculo;
	
	@Column(name="MODELO")
	@Getter @Setter
	private String modelo;
	
	@Column(name="MARCA")
	@Getter @Setter
	private String marca;
	
	@Column(name="COR")
	@Getter @Setter
	private String cor;
	
	@Column(name="CHASSIS")
	@Getter @Setter
	private String chassis;
	
	@Column(name="RESTRICOES")
	@Getter @Setter
	private String restricoes;
	
}
