package br.com.banco.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.modelos.Conta;
import br.com.banco.repositorios.ContaRepositorio;

@Service
public class ContaServicoImpl {

	@Autowired
	private ContaRepositorio repositorio;

	public void cadastrar(Conta conta) {
		Conta usuario = new Conta();
		usuario.setNomeResponsavel(conta.getNomeResponsavel());
		repositorio.save(conta);
	}

	public Conta buscarPorId(Integer id) {
		Conta conta = repositorio.findById(id).orElseThrow();
		return conta;
	}

}
