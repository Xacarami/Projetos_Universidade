package BitCell;

public class Notebook extends Equipamento {

    private static final long serialVersionUID = 1L;

    private String gpu;
    private String processador;
    private String armazenamento;
    private String memoriaRam;

    public Notebook(String marca, String modelo, float tamanhoDeTela, String gpu, String processador, String armazenamento, String memoriaRam) {
        super(marca, modelo, tamanhoDeTela);
        this.gpu = gpu;
        this.processador = processador;
        this.armazenamento = armazenamento;
        this.memoriaRam = memoriaRam;
        this.eletronico = "Notebook";
    }

    @Override
    public String funcionalidades() {
        return "Alto desempenho portatil"+"\nProcesador: "+processador+"\nGPU: "+ gpu+"\nMemoria RAM: "+memoriaRam+"\nArmazenamento: "+armazenamento;

    }
}