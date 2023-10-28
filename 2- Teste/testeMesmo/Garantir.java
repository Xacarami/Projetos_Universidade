package testeMesmo;

public class Garantir extends Mesmo {

    private String habla;

    public Garantir(String cor, String habla) {
        super(cor);

        this.habla = habla;
        
    }

    @Override
    public String funcionalidades() {
        return "vish" + habla;
    }
    
}
