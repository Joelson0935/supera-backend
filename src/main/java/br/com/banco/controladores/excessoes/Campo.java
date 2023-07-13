package br.com.banco.controladores.excessoes;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String erro;

}
