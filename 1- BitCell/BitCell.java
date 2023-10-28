package BitCell;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class BitCell {
	private ArrayList<Equipamento> equipamentos;

	public BitCell() {
		this.equipamentos = new ArrayList<Equipamento>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];
		
		for (int i = 0; i < dadosIn.length; i++){
			dadosOut[i] = JOptionPane.showInputDialog  ("Incluir:\n " + dadosIn[i]+ ": ");

			if (dadosOut[i] == null){
				JOptionPane.showMessageDialog(null, "Atribuição Cancelada!");
				menuBitCell();
			}
		}
		return dadosOut;
	}

	public Smartphone leSmartphone(){

		String[] valores;
		String[] nomeVal = {"Marca", "Modelo", "Tamanho da tela", "Quantidade de chips de operadora", "Tamanho da bateria", "Qualidade da camera"};
		valores = leValores(nomeVal);

		float tamanhoTela = Float.parseFloat(valores[2]);
		int qtdChipsDeOperadora = Integer.parseInt(valores[3]);
		int tamanhoBat = Integer.parseInt(valores[4]);
		String qualidadeCam = valores[5];

		Smartphone smartphone = new Smartphone(valores[0], valores[1], tamanhoTela, qtdChipsDeOperadora, tamanhoBat, qualidadeCam);
		return smartphone;

	}

	public Smartwatch leSmartwatch(){

		String [] valores;
		String [] nomeVal = {"Marca", "Modelo", "Tamanho da tela", "Tipo de Pulseira", " Waterproof?"};
		valores = leValores (nomeVal);

		float tamanhoTela = Float.parseFloat(valores[2]);
		String tipoPulseira= valores[3];
		String aprovaDeAgua = valores[4];

		Smartwatch smartwatch = new Smartwatch(valores[0],valores[1],tamanhoTela,tipoPulseira,aprovaDeAgua);
		return smartwatch;
	}

	public Notebook leNotebook (){

		String [] valores;
		String [] nomeVal = {"Marca", "Modelo","Tamanho da tela","GPU","Processador","Armazenamento","Memoria RAM"};
		valores = leValores (nomeVal);

		float tamanhoTela = Float.parseFloat(valores[2]);
		String gpu = valores[3];
		String processador = valores[4];
		String armazenamento = valores[5];
		String memoriaRam = valores[6];

		Notebook notebook = new Notebook(valores[0],valores[1],tamanhoTela, gpu, processador, armazenamento, memoriaRam);
		return notebook;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // Não conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		int numInt;

		//Caso nao corresponda a um valor apresentado pelas opcoes do menu volta o menu
		if (!this.intValido(entrada)) {
			JOptionPane.showMessageDialog(null, "Valor incorreto!\n\n Voltando ao menu principal");
			menuBitCell();
		}
		return Integer.parseInt(entrada);
	}

	public void salvaEquipamentos(ArrayList<Equipamento> equipamentos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\BitCell.dados"));
			for (int i=0; i < equipamentos.size(); i++)
				outputStream.writeObject(equipamentos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Equipamento> recuperaEquipamentos (){
		ArrayList<Equipamento> equipamentosTemp = new ArrayList<Equipamento>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\BitCell.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Equipamento) {
					equipamentosTemp.add((Equipamento) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com equipamentos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return equipamentosTemp;
		}
	}

	public void menuBitCell (){

		try {

			String menu = "";
			String entrada;
			int opc1, opc2;

			do {
				menu = "Controle BitCell\n" +
						"Opções:\n" +
						"1. Entrar Equipamentos\n" +
						"2. Exibir Equipamentos\n" +
						"3. Limpar Equipamentos\n" +
						"4. Gravar Equipamentos\n" +
						"5. Recuperar Equipamentos\n" +
						"9. Sair";
				entrada = JOptionPane.showInputDialog(menu + "\n\n");

				if (entrada == null){
					JOptionPane.showMessageDialog(null, "Fim do aplicativo BitCell");
					System.exit(0);
				}

				opc1 = this.retornaInteiro(entrada);
				switch (opc1) {
					case 1:// Entrar dados
						menu = "Entrada de Equipamentos\n" +
								"Opções:\n" +
								"1. Smartphone\n" +
								"2. Smartwatch\n" +
								"3. Notebook\n" +
								"9. Voltar";

						entrada = JOptionPane.showInputDialog(menu + "\n\n");

						if (entrada == null){
							menuBitCell();
						}
						opc2 = this.retornaInteiro(entrada);
						
						switch (opc2) {
							case 1:
								equipamentos.add((Equipamento) leSmartphone());
								break;

							case 2:
								equipamentos.add((Equipamento) leSmartwatch());
								break;

							case 3:
								equipamentos.add((Equipamento) leNotebook());
								break;

							default:
								JOptionPane.showMessageDialog(null, "Equipamento para entrada NÃO escolhido!");
						}

						break;
					case 2: // Exibir dados
						if (equipamentos.size() == 0) {
							JOptionPane.showMessageDialog(null, "Entre com os equipamentos primeiramente");
							break;
						}
						String dados = "";
						for (int i = 0; i < equipamentos.size(); i++) {
							dados += equipamentos.get(i).toString() + "---------------\n";
						}
						JOptionPane.showMessageDialog(null, dados);
						break;
					case 3: // Limpar Dados
						if (equipamentos.size() == 0) {
							JOptionPane.showMessageDialog(null, "Entre com os equipamentos primeiramente");
							break;
						}
						equipamentos.clear();
						JOptionPane.showMessageDialog(null, "Dados LIMPOS com sucesso!");
						break;
					case 4: // Grava Dados
						if (equipamentos.size() == 0) {
							JOptionPane.showMessageDialog(null, "Entre com os equipamentos primeiramente");
							break;
						}
						salvaEquipamentos(equipamentos);
						JOptionPane.showMessageDialog(null, "Dados SALVOS com sucesso!");
						break;
					case 5: // Recupera Dados
						equipamentos = recuperaEquipamentos();
						if (equipamentos.size() == 0) {
							JOptionPane.showMessageDialog(null, "Sem dados para apresentar.");
							break;
						}
						JOptionPane.showMessageDialog(null, "Dados RECUPERADOS com sucesso!");
						break;
					case 9:
						JOptionPane.showMessageDialog(null, "Fim do aplicativo BitCell");
						System.exit(0);
						break;
					
				}
			} while (opc1 != 9);
		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Entrada com numeros muito grandes ou caracteres invalidos!");
			menuBitCell();
		}catch (NullPointerException e){
			JOptionPane.showMessageDialog(null,"Erro ao manipular dados inseridos, cancelando operacoes por seguranca!");
			menuBitCell();
		}
	}

	public static void main (String [] args){

		BitCell bit = new BitCell();
		bit.menuBitCell();

	}

}