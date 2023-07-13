package br.com.banco.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.modelos.Transferencia;
import br.com.banco.servicos.TransferenciaServico;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaControlador {

	@Autowired
	private TransferenciaServico servico;

	@GetMapping("/listar-por-numero-conta")
	public ResponseEntity<List<Transferencia>> buscarTransferenciasPorNumeroConta(Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(servico.buscarTransferenciasPorNumeroConta(id));
	}

	@GetMapping("/listar-por-periodo-transferencia")
	public ResponseEntity<List<Transferencia>> buscarTransferenciasPorPeriodoTempo(LocalDateTime dataInicial,
			LocalDateTime dataFinal) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.buscarTransferenciasPorPeriodoTransferencia(dataInicial, dataFinal));
	}

	@GetMapping("/listar-por-nome-operador")
	public ResponseEntity<List<Transferencia>> buscarTransferenciasPorNomeOperador(String nomeOperadorTransacao) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(servico.buscarTransferenciasPorNomeOperador(nomeOperadorTransacao));
	}

	@GetMapping("/listar-por-periodo-transferencia-e-nome-operador")
	public ResponseEntity<List<Transferencia>> buscarTransferenciasPorPeriodoTempoMaisNomeOperador(
			LocalDateTime dataInicial, LocalDateTime dataFinal, String nomeOperador) {
		return ResponseEntity.status(HttpStatus.OK).body(
				servico.buscarTransferenciasPorPeriodoTransferenciaMaisNomeOperador(dataInicial, dataFinal, nomeOperador));
	}

}
