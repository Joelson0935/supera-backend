package br.com.banco.servicos.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.modelos.Conta;
import br.com.banco.modelos.Transferencia;
import br.com.banco.repositorios.TransferenciaRepositorio;
import br.com.banco.servicos.TransferenciaServico;

@Service
public class TransferenciaServicoImpl implements TransferenciaServico {

	@Autowired
	private TransferenciaRepositorio repositorio;

	@Autowired
	private ContaServicoImpl contaServico;

	@Override
	public List<Transferencia> buscarTransferenciasPorNumeroConta(Integer id) {
		Conta conta = contaServico.buscarPorId(id);
		List<Transferencia> transferencias = conta.getTransferencias();
		return transferencias;
	}

	@Override
	public List<Transferencia> buscarTransferenciasPorPeriodoTransferencia(LocalDateTime dataInicial,
			LocalDateTime dataFinal) {
		List<Transferencia> transferencias = repositorio.findByDataTransferencia(dataInicial, dataFinal);
		return transferencias;
	}

	@Override
	public List<Transferencia> buscarTransferenciasPorNomeOperador(String nomeOperadorTransacao) {
		List<Transferencia> transferencias = repositorio.findByNomeOperadorTransacao(nomeOperadorTransacao);
		return transferencias;
	}

	@Override
	public List<Transferencia> buscarTransferenciasPorPeriodoTransferenciaMaisNomeOperador(LocalDateTime dataInicial,
			LocalDateTime dataFinal, String nomeOperador) {
		List<Transferencia> transferencias = repositorio.findByDataTransferenciaAndNomeOperador(dataInicial, dataFinal,
				nomeOperador);
		return transferencias;
	}

}
