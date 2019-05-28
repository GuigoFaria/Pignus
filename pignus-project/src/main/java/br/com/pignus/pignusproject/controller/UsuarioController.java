package br.com.pignus.pignusproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.pignus.pignusproject.entities.Empresa;
import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;

@Controller
public class UsuarioController {
	public static final String PAGINA_DE_LOGIN = "login";
	public static final String PAGINA_LOGIN_ERRO = "paginaLoginErro";
	private SegurancaDaAplicacao seguranca;
	

	public UsuarioController(SegurancaDaAplicacao seguranca) {
		this.seguranca = seguranca;
	}

	@PostMapping("/login")
	public String loginUsuarioEfetuado(@ModelAttribute Usuario usuario, HttpSession session ) throws ClassNotFoundException {
		Usuario novoUsuario = seguranca.permitirAcessoUsuario(usuario.getEmail(), usuario.getSenha());
		if (novoUsuario == null) {
			return "redirect:login";
		}
		seguranca.historicoAcesso(usuario.getEmail(),novoUsuario);
		System.out.println(novoUsuario.getEmpresa());
		session.setAttribute("usuarioLogado", novoUsuario);
		return "redirect:home";
		
	}	

	
	@GetMapping("/login")
	public String acessarUsuarioLogin(@ModelAttribute Usuario usuario,@ModelAttribute Empresa empresa) {
		return PAGINA_DE_LOGIN;
	}
	
	
	
	@GetMapping("/logoff")
	public String logoff(HttpSession session) throws ClassNotFoundException {
		
    session.invalidate();
	
	return "redirect:login";
	
	}
	
	 
	


	
}
