package br.com.banco.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.modelos.Transferencia;

@Repository
public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Integer> {

	@Query("select t from Transferencia t where t.dataTransferencia between :dataInicial and :dataFinal")
	List<Transferencia> findByDataTransferencia(LocalDateTime dataInicial, LocalDateTime dataFinal);

	@Query("select t from Transferencia t where t.dataTransferencia between :dataInicial and :dataFinal and t.nomeOperadorTransacao = :nomeOperador")
	List<Transferencia> findByDataTransferenciaAndNomeOperador(LocalDateTime dataInicial, LocalDateTime dataFinal,
			String nomeOperador);

	List<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);
}
