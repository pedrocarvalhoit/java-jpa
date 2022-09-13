package br.com.academia.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.academia.modelo.Cliente;

public class ClienteDao {
	
	EntityManager em;
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public List<Cliente> listar(){
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> buscaPeloCpf (long cpf) {
		String jpql = "SELECT c.cpf FROM Cliente WHERE c.pfc = :cpf";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("cpf", cpf)
				.getResultList();
	}
	
}
