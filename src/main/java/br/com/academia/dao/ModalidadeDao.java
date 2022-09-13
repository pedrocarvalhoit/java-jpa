package br.com.academia.dao;

import javax.persistence.EntityManager;

import br.com.academia.modelo.Modalidade;

public class ModalidadeDao {
	
	EntityManager em;

	public ModalidadeDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Modalidade modalidade) {
		this.em.persist(modalidade);
	}
	
	//Coloca o item em MANAGED, para voltar a mexer
		public void atualizar(Modalidade modalidade) {
			this.em.merge(modalidade);
		}
		
		//Para remover preciso trazer de DETACHED para MANAGED
		public void remover(Modalidade modalidade) {
			modalidade = em.merge(modalidade);
			this.em.remove(modalidade);
		}
		

}
