package br.com.banco.controladores.excessoes;

public class ObjetoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontrado(String message) {
		super(message);
	}

}
