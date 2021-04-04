package com.eduardo.myapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.myapi.domain.Usuario;
import com.eduardo.myapi.repositories.UsuarioRepository;
import com.eduardo.myapi.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositoty;

	public Usuario findById(Integer id) {

		Optional<Usuario> obj = repositoty.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}