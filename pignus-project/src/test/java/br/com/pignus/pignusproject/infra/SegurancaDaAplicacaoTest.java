package br.com.pignus.pignusproject.infra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.pignus.pignusproject.entities.Usuario;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class SegurancaDaAplicacaoTest {
	Usuario usuario;
	@Autowired
	private SegurancaDaAplicacao seguranca;

	@Before
	public void iniciar() {
		usuario = new Usuario();
	}

	@Test
	public void loginCorreto() {
		usuario.setEmail("guilherme@guilherme.com");
		usuario.setSenha("1234");

		Assert.assertEquals(true, seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}

	@Test
	public void loginErrado() {
		usuario.setEmail("");
		usuario.setSenha("");

		Assert.assertEquals(false, seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}

	@Test
	public void emailErrado() {
		usuario.setEmail("teste@teste");
		usuario.setSenha("12341");

		Assert.assertEquals(false, seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}

	@Test
	public void senhaErrada() {
		usuario.setEmail("teste1@teste");
		usuario.setSenha("1234");

		Assert.assertEquals(false, seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}

	@Test
	public void gerarLogEmailValido() {
		usuario.setEmail("teste@teste");
		usuario.setSenha("1234");
		if (seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha())) {
			seguranca.adicionaMatrizLog(usuario.getEmail());
			seguranca.adicionaMatrizLog(usuario.getEmail());
		}
	}

	// @Test
	public void gerarLogEmailInvalido() {
		usuario.setEmail("gggg@ggggg");
		usuario.setSenha("ggggg");
		if (seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha())) {
			seguranca.adicionaMatrizLog(usuario.getEmail());
		} else {
			System.out.println("Email e login invalido");
		}
	}

}
