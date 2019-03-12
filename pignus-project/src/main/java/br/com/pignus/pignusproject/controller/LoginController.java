package br.com.pignus.pignusproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;

@Controller
public class LoginController {
	public static final String PAGINA_DE_LOGIN = "paginaDeLogin";
	public static final String PAGINA_LOGIN_ERRO = "paginaLoginErro";
	public static final String PAGINA_PRINCIPAL = "paginaPrincipal";

	@SuppressWarnings("unused")
	private SegurancaDaAplicacao seguranca;

	public LoginController(SegurancaDaAplicacao seguranca) {
		this.seguranca = seguranca;
	}

	@PostMapping("/login")
	public String loginEfetuado(@ModelAttribute Usuario usuarioComum) {
		if (seguranca.permitirAcesso(usuarioComum.getEmail(), usuarioComum.getSenha()))
			return PAGINA_PRINCIPAL;
		else
			return PAGINA_LOGIN_ERRO;
	}

	@GetMapping("/login")
	public String acessarLogin() {
		return PAGINA_DE_LOGIN;
	}

}
