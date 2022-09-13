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

public class CadastroCliente {
/** Adicionar numero de sócio */
/** Criar métodos busca*/
	public static void main(String[] args) {
		//Cadastrando modalidades programas e clientes
		Modalidade musculacao = new Modalidade("Musculação", "Ginásio");
		Modalidade corridaIndoor = new Modalidade("Corrida Indoor", "Passadeira");
		
		ProgramaTreino musculacaoIntermediario1 = new ProgramaTreino("Treino Hipertrofia 2", 60, musculacao);
		ProgramaTreino corridaIndoorIniciate2 = new ProgramaTreino("Corrida Indoor 2", 60, corridaIndoor);
		
		Cliente pedro = new Cliente(000001, "Pedro Duarte", "Intermediário", musculacao, musculacaoIntermediario1);
		Cliente thamires = new Cliente(000002, "Thamires Guimaraes", "Iniciante", corridaIndoor, corridaIndoorIniciate2);
		
		
		EntityManager em = JpaUtil.getEntityManager();
		
		ProgramaTreinoDao programaDAO = new ProgramaTreinoDao(em);
		ModalidadeDao modalidadeDAO = new ModalidadeDao(em);
		ClienteDao clienteDAO = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		programaDAO.cadastrar(musculacaoIntermediario1);
		programaDAO.cadastrar(corridaIndoorIniciate2);		
		
		modalidadeDAO.cadastrar(musculacao);
		modalidadeDAO.cadastrar(corridaIndoor);
		
		clienteDAO.cadastrar(pedro);
		clienteDAO.cadastrar(thamires);
		
		em.getTransaction().commit();
		em.close();
		System.out.println(pedro.getNivelDeAtividade());
	
		EntityManager em2 = JpaUtil.getEntityManager();
		ListaClientesDao lcDAO = new ListaClientesDao(em2);
		
		List<Cliente> listaClientes = lcDAO.listaClientes();
		listaClientes.stream()
			.forEach(c -> System.out.println(c.getPrograma() ));
			
	}

}
