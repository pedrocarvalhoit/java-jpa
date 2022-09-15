package br.com.academia.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbmodalidade")
public class Modalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String local;

	public Modalidade() {
	}

	public Modalidade(String nome, String local) {
		this.nome = nome;
		this.local = local;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}

	@Override
	public String toString() {
		return " " + nome;
	}
	
	
	

}
