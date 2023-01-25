package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.domain.Usuario;
import com.rest.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listUsuario() {
		List<Usuario> listaUsuario = usuarioRepository.findAll();
		return listaUsuario;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adiciona(@RequestBody Usuario usuario) {
		Usuario usuarioCriado = usuarioRepository.save(usuario);
		return usuarioCriado;
	}
}
