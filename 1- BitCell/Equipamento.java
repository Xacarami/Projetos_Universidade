package BitCell;

import java.io.Serializable;

public abstract class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String marca;
	private   String modelo;
	private   float tamanhoDeTela;
	protected String eletronico;

	public Equipamento(String marca, String modelo, float tamanhoDeTela) {
		this.marca = marca;
		this.modelo = modelo;
		this.tamanhoDeTela = tamanhoDeTela;
	}
	public String toString() {
		String retorno = "";
		retorno += "Marca: "    + this.marca    + "\n";
		retorno += "Modelo: "     + this.modelo     + "\n";
		retorno += "Tamanho Da Tela: "  + this.tamanhoDeTela  + " polegadas\n";
		retorno +=  "Eletronico: " + this.eletronico + "\n";
		retorno += "Funcionalidade: "  + funcionalidades()        + "\n";
		return retorno;
	}
	public abstract String funcionalidades();


}