package br.com.academia.modelo;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbcliente")
public class Cliente {

	@Id
	private long cpf;
	private String nome;
//	private int idade = nascimento.until(LocalDate.now()).getYears();
	private String nivelDeAtividade;
	@OneToOne
	private Modalidade modalidade;
	@OneToOne
	private ProgramaTreino programa;

	public Cliente() {

	}

	public Cliente(long cpf, String nome, String nivelDeAtividade, Modalidade modalidade, ProgramaTreino programa) {
		this.cpf = cpf;
		this.nome = nome;
		this.modalidade = modalidade;
		this.nivelDeAtividade = nivelDeAtividade;
		this.programa = programa;
	}

	public long getId() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public String getNivelDeAtividade() {
		return nivelDeAtividade;
	}

	public long getCpf() {
		return cpf;
	}

	public ProgramaTreino getPrograma() {
		return programa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
