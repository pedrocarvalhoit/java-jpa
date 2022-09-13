package br.com.academia.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.academia.modelo.Cliente;

public class ListaClientesDao {
	
	EntityManager em;

	public ListaClientesDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Cliente> listaClientes(){
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}

}
