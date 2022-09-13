package br.com.academia.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbprograma")
public class ProgramaTreino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double duracaoMinutos;
	@ManyToOne
	private Modalidade modalidade;

	public ProgramaTreino() {

	}

	public ProgramaTreino(String nome, double duracaoMinutos,  Modalidade modalidade) {
		this.nome = nome;
		this.duracaoMinutos = duracaoMinutos;
		this.modalidade = modalidade;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getDuracaoMinutos() {
		return duracaoMinutos;
	}


	public Modalidade getModalidade() {
		return modalidade;
	}
	
	@Override
	public String toString() {
		return String.format("Treino: " + this.nome + " - > O programa consiste em fazer o treino de " + this.modalidade.getNome() + ", com duração de: "
				+ this.duracaoMinutos);
	}

}
