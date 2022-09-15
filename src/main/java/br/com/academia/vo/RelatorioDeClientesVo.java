package br.com.academia.vo;

import br.com.academia.modelo.Modalidade;

public class RelatorioDeClientesVo {

	private Long idCliente;
	private String nomeCliente;
	private Modalidade modalidadeCliente;

	public RelatorioDeClientesVo(Long idCliente, String nomeCliente, Modalidade modalidadeCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.modalidadeCliente = modalidadeCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Modalidade getModalidadeCliente() {
		return modalidadeCliente;
	}

	@Override
	public String toString() {
		return "RelatorioDeClientesVo [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", modalidadeCliente="
				+ modalidadeCliente + "]";
	}

}
