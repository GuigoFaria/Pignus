package br.com.pignus.pignusproject.infra;

import org.springframework.stereotype.Component;

import br.com.pignus.pignusproject.entities.Usuario;

@Component
public class SegurancaDaAplicacao {

	public Boolean permitirAcesso(Usuario usuarioComum) {
		if(usuarioComum.getEmail() == "" || usuarioComum.getSenha() == "") return false;
		return usuarioComum.getEmail().equals(usuarioComum.getSenha());
	}
	
	
	
	
	}
	
	
	
	
	
			
	
