package br.com.banco.servicos;

import java.time.LocalDateTime;
import java.util.List;

import br.com.banco.modelos.Transferencia;

public interface TransferenciaServico {

	List<Transferencia> buscarTransferenciasPorNumeroConta(Integer id);

	List<Transferencia> buscarTransferenciasPorPeriodoTransferencia(LocalDateTime dataInicial, LocalDateTime dataFinal);

	List<Transferencia> buscarTransferenciasPorNomeOperador(String nomeOperadorTransacao);

	List<Transferencia> buscarTransferenciasPorPeriodoTransferenciaMaisNomeOperador(LocalDateTime dataInicial,
			LocalDateTime dataFinal, String nomeOperador);

}
