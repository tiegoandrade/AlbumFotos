package tiegoandrade.github.io.testes;

import java.io.File;

import tiegoandrade.github.io.fotografias.Album;
import tiegoandrade.github.io.fotografias.Organizador;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		// Instancia um organizador
		Organizador o = new Organizador();

		// Cria um �lbum usando as fotos do diret�rio 'fotos'
		Album a = o.carregarFotos(new File("fotos"));

		// Exibe os dados das fotos do �lbum
		a.listarFotos();
	}
}
