package tiegoandrade.github.io.fotografias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * Álbum para agrupar as fotos.
 * @author Tiego
 */
public class Album {

	/**
	 *  Lista de fotos do álbum.
	 */
	private List<Foto> fotos = new ArrayList<Foto>();

	/** 
	 * Adiciona uma foto ao álbum.
	 * @param id: Identificador da foto.
	 * @param data: Data de quando foi tirado a foto.
	 * @param local: Local de onde foi tirado a foto.
	 */
	public void adicionar(int id, Date data, String local) {
		
		// Cria um objeto Foto com base nos parâmetros passados e o adiciona à lista.
		fotos.add(new Foto(id, data, local));
	}

	/**
	 *  Exibe as informações das fotos
	 */
	public void listarFotos() {
		
		// Itera sobre as fotos do álbum.
		for (Foto foto : fotos) {
			
			// Se não houver o local onde foi tirado a foto, exibe a string "Nenhum".
			String local = foto.getLocal() == null ? "Não há informações sobre o local" : foto.getLocal();
			
			// Formata os dados das fotos.
			String s = String.format("ID: %1$d - LOCAL: %2$s - DATA: %3$td/%3$tm/%3$tY",
					   foto.getId(), local, foto.getData());
			
			// Imprime os dados da foto.
			System.out.println(s);
		}
	}
}
