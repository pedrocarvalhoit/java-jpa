package br.com.academia.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.academia.modelo.Cliente;
//Classe que faz as consultas necessárias a nível de informaçóes necessárias exegidas por qualquer um
/** Criar métodos buscas */
import br.com.academia.vo.RelatorioDeClientesVo;
public class RecepcaoDao {

	EntityManager em;

	public RecepcaoDao(EntityManager em) {
		this.em = em;
	}

	public Cliente buscaFichaClientePorCpf(String cpf) {
		String jpql = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("cpf", cpf)
				.getSingleResult();
	}
	
	public List<Cliente> buscarListaDeClientes(){
		String jpql = 	"SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class)
				.getResultList();
	}
	
	/**Não funciona */
	public List<Cliente> buscarPorParametros(String nome, 
			String cpf, Long id) {
		String jpql = "SELECT c FROM Cliente c WHERE 1=1 ";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql = " AND c.nome = :nome ";
		}
		if (cpf != null) {
			jpql = " AND c.cpf = :cpf ";
		}
		if (id != null) {
			jpql = " AND c.id = :id ";
		}
		TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (cpf != null) {
			query.setParameter("cpf", cpf);
		}
		if (id != null) {
			query.setParameter("id", id);
		}
		
		return query.getResultList();
	}

}
