package br.com.pignus.pignusproject.infra;

import org.springframework.stereotype.Component;

@Component
public class SegurancaDaAplicacao {

	public Boolean permitirAcesso(String email, String senha) {
		boolean resposta = false;
		String matrizLogin[][] = new String[5][2];
		matrizLogin[0][0] = "teste@teste";
		matrizLogin[0][1] = "1234";

		matrizLogin[1][0] = "gui@teste";
		matrizLogin[1][1] = "4321";

		matrizLogin[2][0] = "bianca@teste";
		matrizLogin[2][1] = "eminem";

		matrizLogin[3][0] = "eu@meu";
		matrizLogin[3][1] = "nos";

		matrizLogin[4][0] = "gui@teste";
		matrizLogin[4][1] = "4321";

		for (int i = 0; i < matrizLogin.length; i++) {
			boolean respostaEmail = false;
			boolean respostaSenha = false;
			if (matrizLogin[i][0].equals(email)) {
				respostaEmail = true;
			}
			for (int j = 0; j < matrizLogin[0].length; j++) {
				if (matrizLogin[i][j].equals(senha)) {
					respostaSenha = true;
					break;
				}
			}
			if (respostaEmail && respostaSenha) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
}
