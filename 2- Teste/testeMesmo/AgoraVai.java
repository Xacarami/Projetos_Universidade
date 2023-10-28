package testeMesmo;

import java.util.ArrayList;

public class AgoraVai {

    AgoraVai(){
    }    

    public static void main(String[] args) {
        ArrayList<Garantir> tudo = new ArrayList<Garantir>();

        Garantir sla = new Garantir("vermelho", "Sim");
        Garantir slaa = new Garantir("verde", "Sim");

        tudo.add(sla);
        tudo.add(slaa);
    
        for (Mesmo v : tudo){
            System.out.println(v.funcionalidades());
        }

        // for (Garantir v : tudo){
        //     System.out.println(v.funcionalidades());
        // }
    }

    
}
