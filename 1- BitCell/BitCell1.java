package BitCell;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BitCell1 {

	private ArrayList<Equipamento> equipamentos;


	public BitCell1( ) {
		this.equipamentos = new ArrayList<Equipamento>();
	}

	public void adicionaEquipamento(Equipamento mani) {
		this.equipamentos.add(mani);
	}

	public void listarEquipamento() {
		for(Equipamento mani:equipamentos) {
			System.out.println(mani.toString());
		}
		System.out.println("Total = " + this.equipamentos.size() + " equipamentos listados com sucesso!\n");
	}
	
	public void excluirEquipamento(Equipamento mani) {
		if (this.equipamentos.contains(mani)) {
			this.equipamentos.remove(mani);
			System.out.println("[Equipamento " + mani.toString() + "excluido com sucesso!]\n");
		}
		else
			System.out.println("Equipamento inexistente!\n");
	}

	public void excluirEquipamento() {
		equipamentos.clear();
		System.out.println("Equipamentos excluidos com sucesso!\n");
	}
	public void gravarEquipamento()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\equipamentos.dat"));
			for(Equipamento mani:equipamentos) {
				outputStream.writeObject(mani);
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void recuperarEquipamento() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\equipamentos.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Notebook)  
					this.equipamentos.add((Notebook)obj);
				else if (obj instanceof Smartphone)  
					this.equipamentos.add((Smartphone)obj);
			}
		}catch (EOFException ex) {     // when EOF is reached
			System.out.println ("End of file reached");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Equipamentos recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		BitCell1 equipamentosEletronicos  = new BitCell1();

		Notebook acer           = new Notebook("Acer", "Aspire E 14", 18, "GTX 1050Ti", "i5 7xxx", "SSD 120GB", "6GB");
		Notebook alienware      = new Notebook("AlienWare", "IdeaPad Gaming 3i", 15, "Grafico integrado","i3 3xxx", "HD 500GB", "4GB");
		Smartphone apple        = new Smartphone ("Apple",  "Iphone X", 5,2, 7200, "4k");
		Smartphone xiaomi       = new Smartphone ("Xiaomi", "Redmi Note 8 Pro", 5, 1, 12000, "FullHD");
		Smartwatch smartchApple = new Smartwatch("Apple", "Watch SE", 1.7f,"kevlar", "Nao");
		Smartwatch hrish        = new Smartwatch("Hrich", "Hrich SmartWatch", 1.9f,"couro","Sim");
		equipamentosEletronicos.adicionaEquipamento(acer);
		equipamentosEletronicos.adicionaEquipamento(alienware);
		equipamentosEletronicos.adicionaEquipamento(apple);
		equipamentosEletronicos.adicionaEquipamento(xiaomi);
		equipamentosEletronicos.adicionaEquipamento(smartchApple);
		equipamentosEletronicos.adicionaEquipamento(hrish);
		equipamentosEletronicos.listarEquipamento();
		equipamentosEletronicos.gravarEquipamento();
		equipamentosEletronicos.excluirEquipamento(alienware);
		equipamentosEletronicos.listarEquipamento();
		equipamentosEletronicos.excluirEquipamento(hrish);
		equipamentosEletronicos.listarEquipamento();
		equipamentosEletronicos.excluirEquipamento();
		equipamentosEletronicos.listarEquipamento();
		equipamentosEletronicos.recuperarEquipamento();
		equipamentosEletronicos.listarEquipamento();
	}

}
