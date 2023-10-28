package BitCell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Smartwatch extends Equipamento {
	private static final long serialVersionUID = 1L;

	private String tipoPulseira;
	private String aprovaDeAgua;

	String data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()).toString();

	public Smartwatch(String marca, String modelo, float tamanhoDeTela, String tipoPulseira, String aprovaDeAgua) {
		super(marca, modelo, tamanhoDeTela);
		this.tipoPulseira = tipoPulseira;
		this.aprovaDeAgua = aprovaDeAgua;
		this.eletronico = "Smartwatch";
	}

	@Override
	public String funcionalidades() {
		return "Mostra o horario: " + data+"\nTipo de pulseira: "+ tipoPulseira+"\nWaterproof?: "+ aprovaDeAgua;
	}



}