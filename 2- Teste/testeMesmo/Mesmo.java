package testeMesmo;
public abstract class Mesmo {
    private String cor;

    public Mesmo(String cor){
        this.cor = cor;
    }

    public String toString(){
        return cor;
    }

    public abstract String funcionalidades();

}
