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

public class ListaClientes {
	
	public static void main(String[] args) {
		
		Modalidade musculacao = new Modalidade("Musculação", "Ginásio");
		Modalidade corridaIndoor = new Modalidade("Corrida Indoor", "Passadeira");
		ProgramaTreino musculacaoIntermediario1 = new ProgramaTreino("Treino Hipertrofia 2", 60, musculacao);
		ProgramaTreino musculacaoAvançado3 = new ProgramaTreino("Corrida Indoor 2", 60, corridaIndoor);
		Cliente pedro = new Cliente("000003", "Pedro Duarte", "Intermediário", musculacao, musculacaoIntermediario1);
		Cliente victor = new Cliente("000004", "Victor Duarte", "Avançado", corridaIndoor,	musculacaoAvançado3);
		
		EntityManager em = JpaUtil.getEntityManager();
		ModalidadeDao md = new ModalidadeDao(em);
		ProgramaTreinoDao ptd = new ProgramaTreinoDao(em);
		ClienteDao cd = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		md.cadastrar(musculacao);
		md.cadastrar(corridaIndoor);
		ptd.cadastrar(musculacaoIntermediario1);
		ptd.cadastrar(musculacaoAvançado3);
		cd.cadastrar(pedro);
		cd.cadastrar(victor);
		
		em.getTransaction().commit();
		
		ListaClientesDao ld = new ListaClientesDao(em);
		List<Cliente> listaClientes = ld.listaClientes();
		listaClientes.stream().forEach(c -> System.out.println("Nome: " + c.getNome() + " CPF: " +  c.getCpf()));
		em.close();
		
		
	}

}
