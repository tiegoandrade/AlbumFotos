package tiegoandrade.github.io.fotografias;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Organiza as fotos em um �lbum.
 * @author Tiego
 */
public class Organizador {
	
	/**
	 *  Cria um album de fotos.
	 * @param diretorio: � o diret�rio onde est� as fotos.
	 * @return: Retorna o �lbum criado.
	 * @throws ParseException: Caso haja complica��es na convers�o de um tipo para outro, � lan�ado uma exce��o.
	 */
	 
	public Album carregarFotos(File diretorio) throws ParseException {
		
		//Formatador de datas.
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		//Lista as imagens que est�o no diret�rio e as armazena em um array de arquivos.
		File[] arquivos = diretorio.listFiles();

		//Cria um objeto da classe Album.
		 Album album = new Album();
		
		// Itera sobre os arquivos do diret�rio
		for (File arquivo : arquivos) {
			
			// Obt�m o nome do arquivo
			String nomeArquivo = arquivo.getName();
			
			/*
			 * Remove os �ltimos 4 caracteres do nome do arquivo, 
			 * que s�o a extens�o das imagens.
			 */
			nomeArquivo = nomeArquivo.substring(0, nomeArquivo.length() - 4);

			// Cria um objeto Scanner para executar a tokeniza��o
			Scanner scanner = new Scanner(nomeArquivo);
			
			/* 
			 * O delimitador � uma express�o regular. 
			 * Os caracteres '-' ou '_' s�o delimitadores.
			 */
			scanner.useDelimiter("[-_//]");
			
			// Cria uma String que ir� armazena os tokens que est�o no nome das imagens.
			String token = null;

			// L� o primeiro token
			token = scanner.next();
			
			// Descarta a string 'IMG' e converte o que sobra para inteiro para formar o ID
			int id = Integer.parseInt(token.substring(3));

			// L� o segundo token
			token = scanner.next();
			
			// Faz o parse da data, criando um objeto Date
			Date data = df.parse(token);

			
			String local = null;
			
			// Antes de ler o token do local, � preciso checar se ele existe
			if (scanner.hasNext()) {
				local = scanner.next();
			}

			// Fecha o Scanner
			scanner.close();

			// Adiciona uma nova foto ao �lbum
			album.adicionar(id, data, local);
		}
		
		return album;
	}
}
