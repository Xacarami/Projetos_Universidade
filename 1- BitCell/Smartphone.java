package BitCell;

public class Smartphone extends Equipamento {

	private static final long serialVersionUID = 1L;

	private int qtdChipsDeOperadora;
	private  int tamanhoBat;

	private String qualidadeCam;

	public Smartphone(String marca, String modelo, float tamanhoDeTela, int qtdChipsDeOperadora, int tamanhoBat, String qualidadeCam) {
		super(marca, modelo, tamanhoDeTela);
		this.qtdChipsDeOperadora = qtdChipsDeOperadora;
		this.tamanhoBat = tamanhoBat;
		this.qualidadeCam = qualidadeCam;
		this.eletronico = "Smartphone";
	}
	@Override
	public String funcionalidades() {
		return "Mostra notificacoes"+"\nQualidade da camera: "+qualidadeCam+ "\nTamanho da bateria: "+tamanhoBat+"mAh"+"\nQuantidade de chips de operadora: "+qtdChipsDeOperadora;
	}
}