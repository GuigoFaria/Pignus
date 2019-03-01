package br.com.pignus.pignusproject.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.pignus.pignusproject.entities.LoginUsuarioComum;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;

public class LoginControllerTest {

	LoginUsuarioComum usuarioComum = new LoginUsuarioComum("email", "senha", "nome", "endereco");

	private LoginController controller;
	private SegurancaDaAplicacao seguranca = Mockito.mock(SegurancaDaAplicacao.class);

	@Before
	public void iniciar() {
		controller = new LoginController(seguranca);
	}

	// TESTE DO EMAIL VALIDO
	@Test
	public void emailValido() {
		Mockito.when(seguranca.permitirAcesso(usuarioComum)).thenReturn(true);
		Assert.assertEquals("loginEfetuado", controller.loginEfetuado());

	}

	// TESTE DO EMAIL INVALIDO
	@Test
	public void emailInvalido() {
		Mockito.when(seguranca.permitirAcesso(usuarioComum)).thenReturn(false);
		Assert.assertEquals("loginErro", controller.loginInvalido());

	}

	// TESTE EMAIL E SENHA NULA

	
	

	// TESTE EMAIL NULA E SENHA

	
	

}
