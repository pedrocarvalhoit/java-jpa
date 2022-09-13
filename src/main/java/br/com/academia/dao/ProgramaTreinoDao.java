package br.com.academia.dao;

import javax.persistence.EntityManager;

import br.com.academia.modelo.ProgramaTreino;

public class ProgramaTreinoDao {
	
	EntityManager em;

	public ProgramaTreinoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(ProgramaTreino programaTreino) {
		this.em.persist(programaTreino);
	}

}
