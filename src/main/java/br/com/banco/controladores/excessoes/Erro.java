package br.com.banco.controladores.excessoes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Erro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String erro;
	private Integer codigo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	private String path;
	private List<Campo> campos = new ArrayList<>();

	public void setCampos(String nome, String erro) {
		campos.add(new Campo(nome, erro));
	}
}
