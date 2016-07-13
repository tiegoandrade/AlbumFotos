package tiegoandrade.github.io.fotografias;

import java.util.Date;

/**
 *  Representa uma única foto do álbum
 * @author Tiego
 */
public class Foto {

	// Identificador da foto.
	private int id;
	
	// Data que a foto foi tirada.
	private Date data;
	
	// Local onde a foto foi tirada.
	private String local;
	
	/**
	 *  Construtor
	 * @param id
	 * @param data
	 * @param local
	 */
	public Foto(int id, Date data, String local) {
		this.id = id;
		this.data = data;
		this.local = local;
	}
	
	// Métodos getter
	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public String getLocal() {
		return local;
	}
}