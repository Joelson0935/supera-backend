package br.com.banco.controladores.excessoes;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcessaoControlador {

	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<Erro> objetoNaoEncontrado(ObjetoNaoEncontrado e, HttpServletRequest request) {
		Erro erro = new Erro();
		erro.setErro(e.getMessage());
		erro.setData(LocalDate.now());
		erro.setCodigo(HttpStatus.NOT_FOUND.value());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
