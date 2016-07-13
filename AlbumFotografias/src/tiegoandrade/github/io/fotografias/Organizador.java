package tiegoandrade.github.io.fotografias;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Organiza as fotos em um álbum.
 * @author Tiego
 */
public class Organizador {
	
	/**
	 *  Cria um album de fotos.
	 * @param diretorio: É o diretório onde está as fotos.
	 * @return: Retorna o álbum criado.
	 * @throws ParseException: Caso haja complicações na conversão de um tipo para outro, é lançado uma exceção.
	 */
	 
	public Album carregarFotos(File diretorio) throws ParseException {
		
		//Formatador de datas.
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		//Lista as imagens que estão no diretório e as armazena em um array de arquivos.
		File[] arquivos = diretorio.listFiles();

		//Cria um objeto da classe Album.
		 Album album = new Album();
		
		// Itera sobre os arquivos do diretório
		for (File arquivo : arquivos) {
			
			// Obtém o nome do arquivo
			String nomeArquivo = arquivo.getName();
			
			/*
			 * Remove os últimos 4 caracteres do nome do arquivo, 
			 * que são a extensão das imagens.
			 */
			nomeArquivo = nomeArquivo.substring(0, nomeArquivo.length() - 4);

			// Cria um objeto Scanner para executar a tokenização
			Scanner scanner = new Scanner(nomeArquivo);
			
			/* 
			 * O delimitador é uma expressão regular. 
			 * Os caracteres '-' ou '_' são delimitadores.
			 */
			scanner.useDelimiter("[-_//]");
			
			// Cria uma String que irá armazena os tokens que estão no nome das imagens.
			String token = null;

			// Lê o primeiro token
			token = scanner.next();
			
			// Descarta a string 'IMG' e converte o que sobra para inteiro para formar o ID
			int id = Integer.parseInt(token.substring(3));

			// Lê o segundo token
			token = scanner.next();
			
			// Faz o parse da data, criando um objeto Date
			Date data = df.parse(token);

			
			String local = null;
			
			// Antes de ler o token do local, é preciso checar se ele existe
			if (scanner.hasNext()) {
				local = scanner.next();
			}

			// Fecha o Scanner
			scanner.close();

			// Adiciona uma nova foto ao álbum
			album.adicionar(id, data, local);
		}
		
		return album;
	}
}
