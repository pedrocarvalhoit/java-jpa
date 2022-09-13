package br.com.academia.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.academia.dao.ClienteDao;
import br.com.academia.dao.ListaClientesDao;
import br.com.academia.dao.ModalidadeDao;
import br.com.academia.dao.ProgramaTreinoDao;
import br.com.academia.modelo.Cliente;
import br.com.academia.modelo.Modalidade;
import br.com.academia.modelo.ProgramaTreino;
import br.com.academia.util.JpaUtil;

public class Rascunho {
	
	public static void main(String[] args) {
		
		Modalidade musculacao = new Modalidade("Musculação", "Ginásio");
		Modalidade corridaIndoor = new Modalidade("Corrida Indoor", "Passadeira");
		
		Cliente pedro = new Cliente();
		pedro.setNome("Pedro");
		
		EntityManager em = JpaUtil.getEntityManager();
		
		ModalidadeDao modalidadeDAO = new ModalidadeDao(em);
		ClienteDao clienteDAO = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		modalidadeDAO.cadastrar(musculacao);
		modalidadeDAO.cadastrar(corridaIndoor);
		
		clienteDAO.cadastrar(pedro);
		
		em.getTransaction().commit();
		em.close();
		System.out.println(pedro.getNivelDeAtividade());
	
	
		
	}

}
